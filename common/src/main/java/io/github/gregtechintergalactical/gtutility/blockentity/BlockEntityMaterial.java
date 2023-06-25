package io.github.gregtechintergalactical.gtutility.blockentity;

import io.github.gregtechintergalactical.gtutility.machine.MaterialMachine;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.tile.TileEntityMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityMaterial<T extends BlockEntityMaterial<T>> extends TileEntityMachine<T> {
    protected Material material;
    public BlockEntityMaterial(MaterialMachine type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        material = type.getMaterial();
    }

    public Material getMaterial() {
        return material;
    }
}
