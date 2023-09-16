package io.github.gregtechintergalactical.gtutility.blockentity;

import io.github.gregtechintergalactical.gtutility.machine.MaterialBasicMultiMachine;
import muramasa.antimatter.blockentity.multi.BlockEntityBasicMultiMachine;
import muramasa.antimatter.machine.types.Machine;
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
