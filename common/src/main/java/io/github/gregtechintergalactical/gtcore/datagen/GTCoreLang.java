package io.github.gregtechintergalactical.gtcore.datagen;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreBlocks;
import io.github.gregtechintergalactical.gtcore.data.GTCoreItems;
import muramasa.antimatter.datagen.providers.AntimatterLanguageProvider;

public class GTCoreLang {
    public static class en_US extends AntimatterLanguageProvider {

        public en_US() {
            this("en_us");
        }

        public en_US(String locale) {
            super(GTCore.ID, GTCore.NAME + " " + locale + " Localization", locale);
        }

        @Override
        protected void addTranslations() {
            super.addTranslations();
            add("machine.drum.fluid", "Contains %s L of %s");
            add("machine.drum.output", "Currently set to auto output");
            add("machine.drum.capacity", "Capacity: %sL(MB)");
            add(GTCoreBlocks.RUBBER_LEAVES, "Rubber Leaves");
            add(GTCoreBlocks.RUBBER_LOG, "Rubber Log");
            add(GTCoreBlocks.STRIPPED_RUBBER_LOG, "Stripped Rubber Log");
            add(GTCoreBlocks.RUBBER_WOOD, "Rubber Wood");
            add(GTCoreBlocks.STRIPPED_RUBBER_WOOD, "Stripped Rubber Wood");
            add(GTCoreBlocks.RUBBER_PLANKS, "Rubber Planks");
            add(GTCoreBlocks.RUBBER_SAPLING, "Rubber Sapling");
            add(GTCoreBlocks.RUBBER_SIGN, "Rubber Sign");
            add(GTCoreBlocks.RUBBER_DOOR, "Rubber Door");
            add(GTCoreBlocks.RUBBER_TRAPDOOR, "Rubber Trapdoor");
            add(GTCoreBlocks.RUBBER_BUTTON, "Rubber Button");
            add(GTCoreBlocks.RUBBER_PRESSURE_PLATE, "Rubber Pressure Plate");
            add(GTCoreBlocks.RUBBER_SLAB, "Rubber Slab");
            add(GTCoreBlocks.RUBBER_STAIRS, "Rubber Stairs");
            add(GTCoreBlocks.RUBBER_FENCE, "Rubber Fence");
            add(GTCoreBlocks.RUBBER_FENCE_GATE, "Rubber Fence Gate");
            add(GTCoreItems.RubberBoat, "Rubber Boat");
            add(GTCoreBlocks.SAP_BAG, "Sap Bag");
            add("block.gtcore.rubber_twig", "Rubber Twig");
            add("block.gtcore.rubber_fallen_leaves", "Rubber Fallen Leaves");
            add("block.gtcore.rubber_log_fence", "Rubber Log Fence");
        }
    }
}
