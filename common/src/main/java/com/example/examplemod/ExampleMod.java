package com.example.examplemod;

import muramasa.antimatter.datagen.AntimatterDynamics;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.event.MaterialEvent;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.cover.ICover;
import muramasa.antimatter.registration.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleMod extends AntimatterMod {

    public static final Logger LOGGER = LogManager.getLogger(); // Directly reference a log4j logger.
    public static final String ID = "examplemod", NAME = "Example Mod";

    @Override
    public void onRegistrarInit() {
        super.onRegistrarInit();
        AntimatterDynamics.clientProvider(ID, () -> new AntimatterBlockStateProvider(ID, NAME + " BlockStates"));
        AntimatterDynamics.clientProvider(ID, () -> new AntimatterItemModelProvider(ID, NAME + " Item Models"));
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {
        switch (event) {
            case DATA_INIT -> {
                ExampleData.init();
                //todo until I fix antimatter
                ICover test = ICover.empty;
            }
        }
    }

    @Override
    public String getId() {
        return "example";
    }

    @Override
    public void onMaterialEvent(MaterialEvent event) {
        event.setMaterial(ExampleData.ALUMINIUM).asMetal(933);
    }
}
