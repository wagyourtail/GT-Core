package io.github.gregtechintergalactical.gtcore.forge;

import io.github.gregtechintergalactical.gtcore.proxy.ClientHandler;
import io.github.gregtechintergalactical.gtcore.GTCore;
import muramasa.antimatter.event.forge.AntimatterCraftingEvent;
import muramasa.antimatter.event.forge.AntimatterProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GTCore.ID)
public class GTCoreForge extends GTCore {
    public GTCoreForge(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onProvidersEvent);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCraftingEvent);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        });
    }

    @OnlyIn(Dist.CLIENT)
    private void clientSetup(FMLClientSetupEvent event){
        ClientHandler.init();
    }

    private void onProvidersEvent(AntimatterProvidersEvent event){
        onProviders(event.event);
    }

    private void onCraftingEvent(AntimatterCraftingEvent event){
        onCrafting(event.getEvent());
    }
}
