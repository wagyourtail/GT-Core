package io.github.gregtechintergalactical.gtcore.blockentity;

import io.github.gregtechintergalactical.gtcore.machine.ItemBarrelMachine;
import io.github.gregtechintergalactical.gtcore.machine.ItemBarreltItemHandler;
import io.github.gregtechintergalactical.gtcore.machine.MaterialMachine;
import muramasa.antimatter.machine.types.Machine;
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
        this.itemHandler.set(() -> new ItemBarreltItemHandler(this));
    }

    @Override
    public InteractionResult onInteractServer(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, @Nullable AntimatterToolType type) {
        Vec3 vec = hit.getLocation();
        if (hit.getDirection().getAxis().isHorizontal()){
            double x = hit.getDirection().getAxis() == Direction.Axis.Z ?  vec.x() - hit.getBlockPos().getX() : vec.z() - hit.getBlockPos().getZ(), y = vec.y() - hit.getBlockPos().getY();
            int amountToExtract = 0;


            if (x > 0.0625 && x < 0.1875) {
                if (y > 0.0625 && y < 0.1875){
                    amountToExtract = 1;
                }

            } else if (x > 0.8125 && x < 0.9375) {
                if (y > 0.0625 && y < 0.1875){
                    amountToExtract = 16;
                }

            } else if (x > 0.25 && x < 0.75){
                if (y > 0.0625 && y < 0.625){
                    ItemStack stack = player.getItemInHand(hand);

                }
            }
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
