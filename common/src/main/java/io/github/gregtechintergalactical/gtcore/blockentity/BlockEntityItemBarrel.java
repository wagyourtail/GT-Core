package io.github.gregtechintergalactical.gtcore.blockentity;

import io.github.gregtechintergalactical.gtcore.machine.ItemBarrelMachine;
import io.github.gregtechintergalactical.gtcore.machine.ItemBarrelItemHandler;
import muramasa.antimatter.Antimatter;
import muramasa.antimatter.capability.item.TrackedItemHandler;
import muramasa.antimatter.gui.SlotType;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class BlockEntityItemBarrel extends BlockEntityMaterial<BlockEntityItemBarrel> {
    public BlockEntityItemBarrel(ItemBarrelMachine type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.itemHandler.set(() -> new ItemBarrelItemHandler(this));
    }

    @Override
    public InteractionResult onInteractServer(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, @Nullable AntimatterToolType type) {
        Vec3 vec = hit.getLocation();
        var handler = itemHandler.map(i -> i.getHandler(SlotType.STORAGE)).orElse(null);
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
                    ItemStack stack = player.getItemInHand(hand);
                    if (!stack.isEmpty()){
                        ItemStack leftover = handler.insertItem(0, stack.copy(), true);
                        if (leftover.getCount() < stack.getCount()) {
                            handler.insertItem(0, stack.copy(), false);
                            stack.shrink(stack.getCount() - leftover.getCount());
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
            }
            ItemStack held = handler.getItem(0);
            if (amountToExtract > 0 && !held.isEmpty()){
                int extract = Math.min(amountToExtract, held.getCount());
                ItemStack toAdd = Utils.ca(extract, held);
                if (!player.addItem(toAdd)){
                    player.drop(toAdd, true);
                }
                handler.extractItem(0, extract, false);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }

        return super.onInteractServer(state, world, pos, player, hand, hit, type);
    }

    //TODO
    /*@Override
    public void drawInfo(MatrixStack stack, FontRenderer renderer, int left, int top) {
        this.itemHandler.ifPresent(m -> {
            if (m instanceof QuantumChestItemHandler){
                QuantumChestItemHandler handler = (QuantumChestItemHandler) m;
                handler.drawInfo(stack, renderer, left, top);
            }
        });
    }*/
}
