package io.github.gregtechintergalactical.gtutility.datagen;

import io.github.gregtechintergalactical.gtutility.GTUtility;
import muramasa.antimatter.datagen.providers.AntimatterLanguageProvider;

public class GTUtilityLang {
    public static class en_US extends AntimatterLanguageProvider {

        public en_US() {
            this("en_us");
        }

        public en_US(String locale) {
            super(GTUtility.ID, GTUtility.NAME + " " + locale + " Localization", locale);
        }

        @Override
        protected void addTranslations() {
            super.addTranslations();
            add("machine.drum.fluid", "Contains %s mb of %s");
            add("machine.drum.output", "Currently set to auto output");
            add("machine.drum.capacity", "Capacity: %sL(MB)");
        }
    }
}
