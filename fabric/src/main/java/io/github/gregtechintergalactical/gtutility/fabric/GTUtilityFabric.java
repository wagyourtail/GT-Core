package io.github.gregtechintergalactical.gtutility.fabric;

import io.github.gregtechintergalactical.gtutility.GTUtility;
import muramasa.antimatter.event.fabric.ProviderEvents;
import net.fabricmc.api.ModInitializer;

//initializer class for non antimatter related stuff
public class GTUtilityFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ProviderEvents.PROVIDERS.register(GTUtility::onProviders);
    }
}
