package io.github.gregtechintergalactical.gtcore.blockentity;

import io.github.gregtechintergalactical.gtcore.data.SlotTypes;
import io.github.gregtechintergalactical.gtcore.item.ItemTape;
import io.github.gregtechintergalactical.gtcore.machine.MassStorageMachine;
import io.github.gregtechintergalactical.gtcore.machine.MassStoragelItemHandler;
import io.github.gregtechintergalactical.gtcore.network.MessageInventorySync;
import muramasa.antimatter.Antimatter;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.gui.SlotType;
import muramasa.antimatter.machine.MachineState;
import muramasa.antimatter.machine.event.IMachineEvent;
import muramasa.antimatter.network.AntimatterNetwork;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import tesseract.TesseractCapUtils;

import java.util.List;

import static io.github.gregtechintergalactical.gtcore.data.GTCoreItems.Lighter;
import static io.github.gregtechintergalactical.gtcore.data.GTCoreItems.LighterEmpty;

public class BlockEntityMassStorage extends BlockEntityMaterial<BlockEntityMassStorage> {
    boolean output = false;
    boolean outputOverflow = false;
    boolean syncSlots;
    public BlockEntityMassStorage(MassStorageMachine type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.itemHandler.set(() -> new MassStoragelItemHandler(this));
    }

    @Override
    public void onDrop(BlockState state, LootContext.Builder builder, List<ItemStack> drops) {
        if (!drops.isEmpty() && getMachineState() == MachineState.ACTIVE){
            ItemStack massStorage = drops.get(0);
            CompoundTag nbt = new CompoundTag();
            this.itemHandler.ifPresent(handler -> {
                handler.getAll().forEach((f, i) -> {
                    if (i.isEmpty()) return;
                    nbt.put(f.getId(), i.serialize(new CompoundTag()));
                });
            });
            if (!nbt.isEmpty()) {
                massStorage.getOrCreateTag().put("inventories", nbt);
            }
            massStorage.getOrCreateTag().putBoolean("taped", true);
        }
    }

    @Override
    public void dropInventory(BlockState state, LootContext.Builder builder, List<ItemStack> drops) {
        if (getMachineState() != MachineState.ACTIVE) {
            super.dropInventory(state, builder, drops);
        }
    }

    @Override
    public void onPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onPlacedBy(world, pos, state, placer, stack);
        CompoundTag nbt = stack.getTag();
        if (nbt != null && nbt.contains("taped") && nbt.contains("inventories")){
            CompoundTag inventories = nbt.getCompound("inventories");
            this.itemHandler.ifPresent(handler -> {
                handler.getAll().forEach((f, i) -> {
                    if (!inventories.contains(f.getId())) return;
                    i.deserialize(inventories.getCompound(f.getId()));
                });
            });
            this.setMachineState(MachineState.ACTIVE);
        }
    }

    @Override
    public InteractionResult onInteractServer(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, @Nullable AntimatterToolType type) {
        if (type == AntimatterDefaultTools.KNIFE && this.getMachineState() == MachineState.ACTIVE){
            setMachineState(MachineState.IDLE);
            Utils.damageStack(player.getItemInHand(hand), hand, player);
            return InteractionResult.SUCCESS;
        }
        if (this.getMachineState() == MachineState.ACTIVE) return super.onInteractServer(state, world, pos, player, hand, hit, type);
        Vec3 vec = hit.getLocation();
        var handler = itemHandler.map(i -> i.getHandler(SlotTypes.UNLIMITED)).orElse(null);
        ItemStack stack = player.getItemInHand(hand);
        if (stack.getItem() instanceof ItemTape tape && stack.isDamageableItem() && handler.getItem(0).getCount() <= stack.getMaxDamage() - stack.getDamageValue()){
            this.setMachineState(MachineState.ACTIVE);
            if (!player.isCreative()){
                stack.hurtAndBreak(handler.getItem(0).getCount(), player, (player2) -> {
                    player2.broadcastBreakEvent(hand);
                    if (!player2.addItem(new ItemStack(tape.getEmpty()))) player2.drop(new ItemStack(tape.getEmpty()), true);
                });
            }
        }
        if (type == AntimatterDefaultTools.WIRE_CUTTER){
            outputOverflow = !outputOverflow;
            //TODO: translation component
            player.sendMessage(Utils.literal(outputOverflow ? "Outputs overflow" : "Doesn't output overflow"), player.getUUID());
            Utils.damageStack(player.getItemInHand(hand), hand, player);
            return InteractionResult.SUCCESS;
        }
        if (type == AntimatterDefaultTools.WRENCH_ALT){
            Direction hitSide = Utils.getInteractSide(hit);
            if (hitSide == this.getFacing()){
                output = !output;
                //TODO: translation component
                player.sendMessage(Utils.literal(output ? "Auto output on" : "Auto output off"), player.getUUID());
                Utils.damageStack(player.getItemInHand(hand), hand, player);
                return InteractionResult.SUCCESS;
            }
        }

        if (hit.getDirection().getAxis().isHorizontal() && hit.getDirection() == this.getFacing() && handler != null){
            double x = hit.getDirection().getAxis() == Direction.Axis.Z ?  vec.x() - hit.getBlockPos().getX() : vec.z() - hit.getBlockPos().getZ(), y = vec.y() - hit.getBlockPos().getY();
            int amountToExtract = 0;


            if (x > 0.0625 && x < 0.1875) {
                if (y > 0.125 && y < 0.25){
                    amountToExtract = hit.getDirection().get2DDataValue() > 1 ? 16 : 1;
                }
                if (y > 0.3125 && y < 0.4375){
                    amountToExtract = hit.getDirection().get2DDataValue() > 1 ? 32 : 4;
                }
                if (y > 0.5 && y < 0.625){
                    amountToExtract = hit.getDirection().get2DDataValue() > 1 ? 64 : 8;
                }

            } else if (x > 0.8125 && x < 0.9375) {
                if (y > 0.125 && y < 0.25){
                    amountToExtract = hit.getDirection().get2DDataValue() > 1 ? 1 : 16;
                }
                if (y > 0.3125 && y < 0.4375){
                    amountToExtract = hit.getDirection().get2DDataValue() > 1 ? 4 : 32;
                }
                if (y > 0.5 && y < 0.625){
                    amountToExtract = hit.getDirection().get2DDataValue() > 1 ? 8 : 64;
                }

            } else if (x > 0.25 && x < 0.75){
                if (y > 0.125 && y < 0.625){
                    ItemStack stored = handler.getItem(0);
                    if (type == AntimatterDefaultTools.SOFT_HAMMER){
                        amountToExtract = stored.getCount();
                        Utils.damageStack(stack, hand, player);
                        itemHandler.get().getHandler(SlotType.DISPLAY).setItem(0, ItemStack.EMPTY);
                    } else {
                        if (!stack.isEmpty()){
                            ItemStack leftover = handler.insertItem(0, stack.copy(), true);
                            if (leftover.getCount() < stack.getCount()) {
                                handler.insertItem(0, stack.copy(), false);
                                stack.shrink(stack.getCount() - leftover.getCount());
                                return InteractionResult.SUCCESS;
                            }
                        } else {
                            if (!stored.isEmpty()) {
                                boolean sucess = false;
                                for (int i = 0; i < player.getInventory().items.size(); i++){
                                    ItemStack stack1 = player.getInventory().items.get(i);
                                    if (Utils.equals(stack1, handler.getItem(0))){
                                        ItemStack inserted = handler.insertItem(0, stack1.copy(), false);
                                        stack1.shrink(stack1.getCount() - inserted.getCount());
                                        sucess = true;
                                        if (inserted.getCount() > 0) break;
                                    }
                                }
                                if (sucess) {
                                    return InteractionResult.SUCCESS;
                                }
                            }
                        }
                    }

                }
            }
            ItemStack held = handler.getItem(0);
            if (amountToExtract > 0 && !held.isEmpty()){
                int extract = Math.min(amountToExtract, held.getCount());

                if (extract > held.getMaxStackSize()){
                    int toExtract = extract;
                    while (toExtract > 0){
                        ItemStack toAdd = Utils.ca(Math.min(held.getMaxStackSize(), toExtract), held);
                        toExtract -= toAdd.getCount();
                        if (!player.addItem(toAdd)){
                            player.drop(toAdd, true);
                        }
                    }
                } else {
                    ItemStack toAdd = Utils.ca(extract, held);
                    if (!player.addItem(toAdd)){
                        player.drop(toAdd, true);
                    }
                }

                handler.extractItem(0, extract, false);
                world.playSound(null, this.getBlockPos(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }

        return super.onInteractServer(state, world, pos, player, hand, hit, type);
    }

    @Override
    public void serverTick(Level level, BlockPos pos, BlockState state) {
        super.serverTick(level, pos, state);
        if (output){
            processItemOutput(ItemStack.EMPTY);
        }
        if (getLevel() != null && getLevel().getGameTime() % 200 == 0) syncSlots = true;
        if (syncSlots){
            syncSlots();
            syncSlots = false;
        }
    }

    public void setSyncSlots(boolean syncSlots) {
        this.syncSlots = syncSlots;
    }

    public void syncSlots(){
        if (getLevel() != null && isServerSide()){
            itemHandler.ifPresent(i -> {
                i.getAll().keySet().forEach(s -> {
                    var handler = i.getHandler(s);
                    for (int i1 = 0; i1 < handler.getSlots(); i1++) {
                        AntimatterNetwork.NETWORK.sendToPlayersInRange(new MessageInventorySync(this.getBlockPos(), s, i1, i.getHandler(s).getItem(i1)), this.getLevel(), this.getBlockPos(), 32.0);
                    }
                });
            });
        }
    }


    public void processItemOutput(ItemStack itemStack) {
        Direction outputDir = Direction.DOWN;
        BlockEntity adjTile = Utils.getTile(this.getLevel(), this.getBlockPos().relative(outputDir));
        if (adjTile == null) return;
        if (!itemStack.isEmpty()) {
            TesseractCapUtils.getItemHandler(adjTile, outputDir.getOpposite()).ifPresent(adjHandler -> {
                ItemStack transferred = Utils.insertItem(adjHandler, itemStack.copy(), false);
                itemStack.shrink(itemStack.getCount() - transferred.getCount());
            });
        } else {
            TesseractCapUtils.getItemHandler(adjTile, outputDir.getOpposite()).ifPresent(adjHandler -> {
                this.itemHandler.ifPresent(h -> Utils.transferItems(h.getHandler(SlotTypes.UNLIMITED), adjHandler,true));
            });
        }
    }

    @Override
    public boolean canPlayerOpenGui(Player playerEntity) {
        return playerEntity.isCreative();
    }

    @Override
    public void onMachineEvent(IMachineEvent event, Object... data) {
        if (event instanceof SlotType<?> slotType && data.length > 0 && data[0] instanceof Integer integer){
            if (isServerSide() && getLevel() != null){
                AntimatterNetwork.NETWORK.sendToAllLoaded(new MessageInventorySync(this.getBlockPos(), slotType, integer, itemHandler.map(i -> i.getHandler(slotType).getItem(integer)).orElse(ItemStack.EMPTY)), this.getLevel(), this.getBlockPos());
            }
        }
        super.onMachineEvent(event, data);
    }

    public boolean isOutputOverflow() {
        return outputOverflow;
    }

    public boolean isOutput() {
        return output;
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("outputOverflow", outputOverflow);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        outputOverflow = tag.getBoolean("outputOverflow");
    }
}
