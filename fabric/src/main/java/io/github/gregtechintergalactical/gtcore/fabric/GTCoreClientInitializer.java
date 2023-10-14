package io.github.gregtechintergalactical.gtcore.fabric;

import io.github.gregtechintergalactical.gtcore.proxy.ClientHandler;
import muramasa.antimatter.client.fabric.IAntimatterClientInitializer;

public class GTCoreClientInitializer implements IAntimatterClientInitializer {
    @Override
    public void onInitializeClient() {
        ClientHandler.init();
    }
}
