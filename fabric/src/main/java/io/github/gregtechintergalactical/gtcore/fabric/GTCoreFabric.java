package io.github.gregtechintergalactical.gtcore.fabric;

import io.github.gregtechintergalactical.gtcore.GTCore;
import muramasa.antimatter.event.fabric.CraftingEvents;
import muramasa.antimatter.event.fabric.LoaderEvents;
import muramasa.antimatter.event.fabric.ProviderEvents;
import net.fabricmc.api.ModInitializer;

//initializer class for non antimatter related stuff
public class GTCoreFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ProviderEvents.PROVIDERS.register(GTCore::onProviders);
        CraftingEvents.CRAFTING.register(GTCore::onCrafting);
        LoaderEvents.LOADER.register(GTCore::registerRecipeLoaders);
    }
}
