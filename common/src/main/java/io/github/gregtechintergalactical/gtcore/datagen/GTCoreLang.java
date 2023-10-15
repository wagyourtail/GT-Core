package io.github.gregtechintergalactical.gtcore.datagen;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreData;
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
            add(GTCoreData.RUBBER_LEAVES, "Rubber Leaves");
            add(GTCoreData.RUBBER_LOG, "Rubber Log");
            add(GTCoreData.STRIPPED_RUBBER_LOG, "Stripped Rubber Log");
            add(GTCoreData.RUBBER_WOOD, "Rubber Wood");
            add(GTCoreData.STRIPPED_RUBBER_WOOD, "Stripped Rubber Wood");
            add(GTCoreData.RUBBER_PLANKS, "Rubber Planks");
            add(GTCoreData.RUBBER_SAPLING, "Rubber Sapling");
            add(GTCoreData.RUBBER_SIGN, "Rubber Sign");
            add(GTCoreData.RUBBER_DOOR, "Rubber Door");
            add(GTCoreData.RUBBER_TRAPDOOR, "Rubber Trapdoor");
            add(GTCoreData.RUBBER_BUTTON, "Rubber Button");
            add(GTCoreData.RUBBER_PRESSURE_PLATE, "Rubber Pressure Plate");
            add(GTCoreData.RUBBER_SLAB, "Rubber Slab");
            add(GTCoreData.RUBBER_STAIRS, "Rubber Stairs");
            add(GTCoreData.RUBBER_FENCE, "Rubber Fence");
            add(GTCoreData.RUBBER_FENCE_GATE, "Rubber Fence Gate");
            add(GTCoreData.RubberBoat, "Rubber Boat");
            add(GTCoreData.SAP_BAG, "Sap Bag");
            add("block.gtcore.rubber_twig", "Rubber Twig");
            add("block.gtcore.rubber_fallen_leaves", "Rubber Fallen Leaves");
            add("block.gtcore.rubber_log_fence", "Rubber Log Fence");
        }
    }
}
