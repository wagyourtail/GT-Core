package io.github.gregtechintergalactical.gtutility.blockentity;

import earth.terrarium.botarium.common.fluid.base.FluidContainer;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.fluid.base.PlatformFluidHandler;
import earth.terrarium.botarium.common.fluid.utils.FluidHooks;
import io.github.gregtechintergalactical.gtutility.machine.DrumMachine;
import muramasa.antimatter.Ref;
import muramasa.antimatter.capability.fluid.FluidTank;
import muramasa.antimatter.capability.fluid.FluidTanks;
import muramasa.antimatter.capability.machine.MachineFluidHandler;
import muramasa.antimatter.data.AntimatterTags;
import muramasa.antimatter.machine.event.ContentEvent;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.util.AntimatterPlatformUtils;
import muramasa.antimatter.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
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
import tesseract.FluidPlatformUtils;
import tesseract.TesseractCapUtils;
import tesseract.TesseractGraphWrappers;
import tesseract.api.fluid.FluidContainerHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

import static muramasa.antimatter.data.AntimatterDefaultTools.ELECTRIC_WRENCH;
import static muramasa.antimatter.data.AntimatterDefaultTools.WRENCH;
import static net.minecraft.core.Direction.DOWN;
import static net.minecraft.core.Direction.UP;

public class BlockEntityDrum extends BlockEntityMaterial<BlockEntityDrum> {
    FluidHolder drop = FluidHooks.emptyFluid();
    boolean output = false;
    public BlockEntityDrum(DrumMachine type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.fluidHandler.set(() -> new DrumFluidHandler(this));
    }

    @Override
    public InteractionResult onInteractServer(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, @Nullable AntimatterToolType type) {
        boolean[] success = new boolean[1];
        this.fluidHandler.ifPresent(f -> {
            DrumFluidHandler dF = (DrumFluidHandler) f;
            if ((type == WRENCH || type == ELECTRIC_WRENCH) && !player.isShiftKeyDown()){
                dF.setOutput(!dF.isOutput());
                success[0] = true;
                player.playNotifySound(Ref.WRENCH, SoundSource.BLOCKS, 1.0f, 1.0f);
                // TODO: Replace by new TranslationTextComponent()
                player.sendMessage(new TextComponent((dF.isOutput() ? "Will" : "Won't") + " fill adjacent Tanks"), player.getUUID());
            }
        });
        if (success[0]){
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onRemove() {
        this.fluidHandler.ifPresent(f -> {
            this.drop = f.getFluidInTank(0);
            this.output = ((DrumFluidHandler)f).isOutput();
        });
       super.onRemove();
    }

    @Override
    public void onDrop(BlockState state, LootContext.Builder builder, List<ItemStack> drops) {
        if (!drops.isEmpty()){
            ItemStack stack = drops.get(0);
            if (!getDrop().isEmpty()){
                CompoundTag nbt = stack.getOrCreateTag();
                nbt.put("Fluid", getDrop().serialize());
            }
            if (isOutput()){
                CompoundTag nbt = stack.getOrCreateTag();
                nbt.putBoolean("Outputs", isOutput());
            }
        }
    }

    @Override
    public void onPlacedBy(Level world, BlockPos pos, BlockState state, @org.jetbrains.annotations.Nullable LivingEntity placer, ItemStack stack) {
        CompoundTag nbt = stack.getTag();
        if (nbt != null && (nbt.contains("Fluid") || nbt.contains("Outputs"))){
            this.fluidHandler.ifPresent(f -> {
                FluidHolder fluid = nbt.contains("Fluid") ? FluidHooks.fluidFromCompound(nbt.getCompound("Fluid")) : FluidHooks.emptyFluid();
                if (!fluid.isEmpty()){
                    f.insertFluid(fluid, false);
                }
                if (nbt.contains("Outputs")){
                    ((DrumFluidHandler)f).setOutput(nbt.getBoolean("Outputs"));
                }
            });
        }
    }

    public FluidHolder getDrop() {
        return drop;
    }

    public boolean isOutput() {
        return output;
    }

    @Override
    public List<String> getInfo() {
        List<String> list = super.getInfo();
        fluidHandler.ifPresent(f -> {
            FluidHolder stack = f.getInputTanks().getFluidInTank(0);
            String addition = AntimatterPlatformUtils.isFabric() && !stack.isEmpty() ? "/" + stack.getFluidAmount() + "droplets" : "";
            list.add("Fluid: " + (stack.isEmpty() ? "Empty" : (stack.getFluidAmount() / TesseractGraphWrappers.dropletMultiplier) + "mb" + addition + " of " + FluidPlatformUtils.getFluidDisplayName(stack).getString()));
        });
        return list;
    }

    public static class DrumFluidHandler extends MachineFluidHandler<BlockEntityDrum> implements FluidContainerHandler {
        boolean output = false;
        public DrumFluidHandler(BlockEntityDrum tile) {
            super(tile);
            tanks.put(FluidDirection.INPUT, FluidTanks.create(tile, ContentEvent.FLUID_INPUT_CHANGED, b -> {
                b.tank(((DrumMachine)tile.getMachineType()).maxCapacity);
                return b;
            }));
        }

        public void setOutput(boolean output) {
            this.output = output;
        }

        public boolean isOutput() {
            return output;
        }

        @Nullable
        @Override
        public FluidTanks getOutputTanks() {
            return super.getInputTanks();
        }

        @Override
        protected FluidTank getTank(int tank) {
            return getInputTanks().getTank(tank);
        }

        @Override
        public FluidTanks getTanks(int tank) {
            return getInputTanks();
        }

        @Override
        public void onUpdate() {
            super.onUpdate();
            if (tile.getLevel().getGameTime() % 20 == 0 && output){
                Direction dir = FluidPlatformUtils.isFluidGaseous(getTank(0).getStoredFluid().getFluid()) ? UP : DOWN;
                if (getTank(0).getStoredFluid().getFluidAmount() > 0){

                    BlockEntity adjacent = tile.getLevel().getBlockEntity(tile.getBlockPos().relative(dir));
                    if (adjacent != null){
                        Optional<PlatformFluidHandler> cap = TesseractCapUtils.getFluidHandler(tile.getLevel(), tile.getBlockPos().relative(dir), dir.getOpposite());
                        cap.ifPresent(other -> Utils.transferFluids(this, other, 1000));
                    }
                }
            }
        }

        @Override
        public CompoundTag serialize(CompoundTag nbt) {
            super.serialize(nbt);
            nbt.putBoolean("Output", output);
            return nbt;
        }

        @Override
        public void deserialize(CompoundTag nbt) {
            super.deserialize(nbt);
            this.output = nbt.getBoolean("Output");
        }

        @Override
        public boolean canInput(FluidHolder fluid, Direction direction) {
            boolean gaseous = FluidPlatformUtils.isFluidGaseous(fluid.getFluid());
            if (output && ((direction == UP && gaseous) || (direction == DOWN && !gaseous))) return false;
            return super.canInput(fluid, direction);
        }

        @Override
        public long insertFluid(FluidHolder fluid, boolean simulate) {
            if (tile.getMachineType() instanceof DrumMachine drumMachine && !drumMachine.isAcidProof() && fluid.getFluid().is(AntimatterTags.ACID)){
                return 0;
            }
            return super.insertFluid(fluid, simulate);
        }

        @Override
        public FluidContainer getFluidContainer() {
            return this;
        }
    }
}
