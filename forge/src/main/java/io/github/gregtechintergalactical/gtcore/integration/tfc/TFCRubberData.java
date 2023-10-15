package io.github.gregtechintergalactical.gtcore.integration.tfc;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreBlocks;
import muramasa.antimatter.item.ItemBasic;
import net.minecraft.world.level.block.Block;

public class TFCRubberData {

    public static final Block RUBBER_TWIG = new BlockRubberTwig();
    public static final Block RUBBER_FALLEN_LEAVES = new BlockFallenRubberLeaves();
    public static final Block RUBBER_LOG_FENCE = new BlockRubberLogFence();
    public static final ItemBasic<?> RUBBER_LUMBER = new ItemBasic<>(GTCore.ID, "rubber_lumber");

    public static void init(){
        GTCoreBlocks.RUBBER_LEAVES = new BlockTFCRubberLoaves();
        GTCoreBlocks.RUBBER_SAPLING = new BlockTFCRubberSapling();
    }
}
