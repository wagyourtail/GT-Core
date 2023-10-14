package io.github.gregtechintergalactical.gtcore.tree;

import io.github.gregtechintergalactical.gtcore.data.GTCoreData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityRubberSign extends SignBlockEntity {
    public BlockEntityRubberSign(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return GTCoreData.SIGN_BLOCK_ENTITY;
    }
}
