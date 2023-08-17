package io.github.gregtechintergalactical.gtutility.blockentity;

import io.github.gregtechintergalactical.gtutility.machine.MaterialBasicMultiMachine;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.tile.multi.TileEntityBasicMultiMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityMaterialBasicMultiMachine<T extends BlockEntityMaterialBasicMultiMachine<T>> extends TileEntityBasicMultiMachine<T> {
    protected Material material;
    public BlockEntityMaterialBasicMultiMachine(MaterialBasicMultiMachine type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        material = type.getMaterial();
    }

    public Material getMaterial() {
        return material;
    }
}
