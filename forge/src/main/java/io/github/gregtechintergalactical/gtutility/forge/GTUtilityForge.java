package io.github.gregtechintergalactical.gtutility.forge;

import io.github.gregtechintergalactical.gtutility.GTUtility;
import io.github.gregtechintergalactical.gtutility.proxy.ClientHandler;
import muramasa.antimatter.event.forge.AntimatterProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GTUtility.ID)
public class GTUtilityForge extends GTUtility {
    public GTUtilityForge(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onProvidersEvent);
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
}
