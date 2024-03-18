package io.github.gregtechintergalactical.gtcore.block;

import io.github.gregtechintergalactical.gtcore.behaviour.BlockEntityRedstoneWire;
import muramasa.antimatter.blockentity.BlockEntityBase;
import muramasa.antimatter.blockentity.pipe.BlockEntityPipe;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.pipe.BlockCable;
import muramasa.antimatter.pipe.PipeSize;
import muramasa.antimatter.pipe.types.Cable;
import muramasa.antimatter.pipe.types.PipeType;
import muramasa.antimatter.pipe.types.Wire;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.stream.Collectors;

public class RedstoneWire<T extends RedstoneWire<T>> extends PipeType<T> {
    int onColor;

    public RedstoneWire(String domain, Material material, int onColor) {
        super(domain, material, BlockEntityRedstoneWire::new);
        this.onColor = onColor;
        sizes(PipeSize.VTINY);
    }

    @Override
    public String getType() {
        return "wire";
    }

    @Override
    public Set<Block> getBlocks() {
        return sizes.stream().map(s -> new BlockRedstoneWire(this, s)).collect(Collectors.toSet());
    }

    @Override
    public String getTypeName() {
        return "redstone";
    }

    public int getOnColor() {
        return onColor;
    }
}
