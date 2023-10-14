package io.github.gregtechintergalactical.gtcore.datagen;

import io.github.gregtechintergalactical.gtcore.GTCore;
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
        }
    }
}
