package io.github.gregtechintergalactical.gtcore.behaviour;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.blockentity.pipe.BlockEntityPipe;
import muramasa.antimatter.capability.ICoverHandler;
import muramasa.antimatter.cover.CoverFactory;
import muramasa.antimatter.cover.CoverPlate;
import muramasa.antimatter.pipe.types.PipeType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.Redstone;

public class BlockEntityRedstoneWire<T extends PipeType<T>> extends BlockEntityPipe<T> {
    int state = 0;
    public BlockEntityRedstoneWire(T type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public CoverFactory[] getValidCovers() {
        return AntimatterAPI.all(CoverFactory.class).stream().filter(t -> {
            try {
                return !t.get().get(ICoverHandler.empty(this), t.getValidTier(), Direction.SOUTH, t).isNode();
            } catch (Exception ex) {
                return false;
            }
        }).toArray(CoverFactory[]::new);
    }

    @Override
    public Class<?> getCapClass() {
        return Redstone.class;
    }

    @Override
    protected void register() {

    }

    @Override
    protected boolean deregister() {
        return false;
    }

    public int getState() {
        return state;
    }
}
