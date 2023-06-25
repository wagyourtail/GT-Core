package io.github.gregtechintergalactical.gtutility;

import io.github.gregtechintergalactical.gtutility.data.MenuHandlers;
import io.github.gregtechintergalactical.gtutility.data.SlotTypes;
import io.github.gregtechintergalactical.gtutility.data.client.ScreenFactories;
import io.github.gregtechintergalactical.gtutility.datagen.GTUtilityBlockLootProvider;
import io.github.gregtechintergalactical.gtutility.datagen.GTUtilityBlockTagProvider;
import io.github.gregtechintergalactical.gtutility.datagen.GtUtilityLang;
import io.github.gregtechintergalactical.gtutility.network.MessageCraftingSync;
import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.AntimatterDynamics;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.event.CraftingEvent;
import muramasa.antimatter.event.MaterialEvent;
import muramasa.antimatter.event.ProvidersEvent;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.registration.Side;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trinsdar.networkapi.api.PacketRegistration;

public class GTUtility extends AntimatterMod {

    public static final Logger LOGGER = LogManager.getLogger(); // Directly reference a log4j logger.
    public static final String ID = "gtutility", NAME = "GT Utility";
    public static final ResourceLocation SYNC_ID = new ResourceLocation(GTUtility.ID, "crafting_sync");

    @Override
    public void onRegistrarInit() {
        super.onRegistrarInit();
        AntimatterDynamics.clientProvider(ID, () -> new AntimatterBlockStateProvider(ID, NAME + " BlockStates"));
        AntimatterDynamics.clientProvider(ID, () -> new AntimatterItemModelProvider(ID, NAME + " Item Models"));
        AntimatterDynamics.clientProvider(ID, GtUtilityLang.en_US::new);
        PacketRegistration.registerPacket(MessageCraftingSync.class, SYNC_ID, b -> new MessageCraftingSync(), PacketRegistration.NetworkDirection.PLAY_TO_SERVER);
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {
        switch (event) {
            case DATA_INIT -> {
                SlotTypes.init();
                MenuHandlers.init();
                GTUtilityData.init();
            }
            case CLIENT_DATA_INIT -> ScreenFactories.init();
        }
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void onMaterialEvent(MaterialEvent event) {
    }

    public static void onCrafting(CraftingEvent event){
        event.addLoader(GTUtilityRecipes::initRecipes);
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
