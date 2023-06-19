package io.github.gregtechintergalactical.gtutility.fabric;

import io.github.gregtechintergalactical.gtutility.proxy.ClientHandler;
import muramasa.antimatter.client.fabric.IAntimatterClientInitializer;

public class GTUtilityClientInitializer implements IAntimatterClientInitializer {
    @Override
    public void onInitializeClient() {
        ClientHandler.init();
    }
}
