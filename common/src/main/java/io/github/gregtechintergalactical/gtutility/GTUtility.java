package io.github.gregtechintergalactical.gtutility;

import io.github.gregtechintergalactical.gtutility.datagen.GTUtilityBlockLootProvider;
import io.github.gregtechintergalactical.gtutility.datagen.GTUtilityBlockTagProvider;
import io.github.gregtechintergalactical.gtutility.datagen.GtUtilityLang;
import muramasa.antimatter.datagen.AntimatterDynamics;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.datagen.providers.AntimatterTagProvider;
import muramasa.antimatter.event.MaterialEvent;
import muramasa.antimatter.event.ProvidersEvent;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.cover.ICover;
import muramasa.antimatter.registration.Side;
import muramasa.antimatter.util.AntimatterPlatformUtils;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GTUtility extends AntimatterMod {

    public static final Logger LOGGER = LogManager.getLogger(); // Directly reference a log4j logger.
    public static final String ID = "gtutility", NAME = "GT Utility";

    @Override
    public void onRegistrarInit() {
        super.onRegistrarInit();
        AntimatterDynamics.clientProvider(ID, () -> new AntimatterBlockStateProvider(ID, NAME + " BlockStates"));
        AntimatterDynamics.clientProvider(ID, () -> new AntimatterItemModelProvider(ID, NAME + " Item Models"));
        AntimatterDynamics.clientProvider(ID, GtUtilityLang.en_US::new);
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {
        switch (event) {
            case DATA_INIT -> {
                GTUtilityData.init();
            }
        }
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void onMaterialEvent(MaterialEvent event) {
    }

    public static void onProviders(ProvidersEvent ev) {
        final AntimatterBlockTagProvider[] p = new AntimatterBlockTagProvider[1];
        ev.addProvider(ID, () -> {
            p[0] = new GTUtilityBlockTagProvider(ID, NAME.concat(" Block Tags"), false);
            return p[0];
        });

        ev.addProvider(ID, () -> new GTUtilityBlockLootProvider(ID, NAME.concat(" Loot generator")));
    }
}
