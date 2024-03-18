package io.github.gregtechintergalactical.gtcore.block;

import io.github.gregtechintergalactical.gtcore.behaviour.BlockEntityRedstoneWire;
import muramasa.antimatter.Ref;
import muramasa.antimatter.pipe.BlockCable;
import muramasa.antimatter.pipe.BlockPipe;
import muramasa.antimatter.pipe.PipeSize;
import muramasa.antimatter.texture.Texture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BlockRedstoneWire<T extends RedstoneWire<T>> extends BlockPipe<T> {
    public BlockRedstoneWire(T type, PipeSize size) {
        super(type.getId(), type, size, 2);
        String prefix = "wire";
        this.side = new Texture(Ref.ID, "block/pipe/" + prefix + "_side");
        this.faces = new Texture[]{
                new Texture(Ref.ID, "block/pipe/" + prefix + "_vtiny"),
                new Texture(Ref.ID, "block/pipe/" + prefix + "_tiny"),
                new Texture(Ref.ID, "block/pipe/" + prefix + "_small"),
                new Texture(Ref.ID, "block/pipe/" + prefix + "_normal"),
                new Texture(Ref.ID, "block/pipe/" + prefix + "_large"),
                new Texture(Ref.ID, "block/pipe/" + prefix + "_huge")
        };
    }

    @Override
    public int getBlockColor(BlockState state, @Nullable BlockGetter world, @Nullable BlockPos pos, int i) {
        if (world != null && pos != null){
            if (world.getBlockEntity(pos) instanceof BlockEntityRedstoneWire<?> redstoneWire){
                if (redstoneWire.getState() > 0){
                    return getType().getOnColor();
                }
            }
        }
        return super.getBlockColor(state, world, pos, i);
    }
}
