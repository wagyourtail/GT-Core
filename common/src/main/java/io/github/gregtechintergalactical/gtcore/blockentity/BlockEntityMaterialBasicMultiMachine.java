package io.github.gregtechintergalactical.gtcore.blockentity;

import io.github.gregtechintergalactical.gtcore.machine.MaterialBasicMultiMachine;
import muramasa.antimatter.blockentity.multi.BlockEntityBasicMultiMachine;
import muramasa.antimatter.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityMaterialBasicMultiMachine<T extends BlockEntityMaterialBasicMultiMachine<T>> extends BlockEntityBasicMultiMachine<T> {
    protected Material material;
    public BlockEntityMaterialBasicMultiMachine(MaterialBasicMultiMachine type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        material = type.getMaterial();
    }

    public Material getMaterial() {
        return material;
    }
}
