package io.github.gregtechintergalactical.gtcore.integration.tfc;


import io.github.gregtechintergalactical.gtcore.tree.RubberTreeWorldGen;
import net.dries007.tfc.world.feature.tree.TFCTreeGrower;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class TFCRubberTree extends TFCTreeGrower {
    public TFCRubberTree() {
        super(null, null);
    }

    @Override
    public ConfiguredFeature<?, ?> getNormalFeature(Registry<ConfiguredFeature<?, ?>> registry) {
        return RubberTreeWorldGen.TREE_FEATURE_CONFIG.value();
    }
}
