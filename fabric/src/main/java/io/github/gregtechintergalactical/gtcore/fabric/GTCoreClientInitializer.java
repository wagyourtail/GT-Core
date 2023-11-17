package io.github.gregtechintergalactical.gtcore.fabric;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import io.github.fabricators_of_create.porting_lib.event.client.TextureStitchCallback;
import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.proxy.ClientHandler;
import muramasa.antimatter.client.fabric.IAntimatterClientInitializer;
import net.minecraft.resources.ResourceLocation;

public class GTCoreClientInitializer implements IAntimatterClientInitializer {
    @Override
    public void onInitializeClient() {
        TerraformBoatClientHelper.registerModelLayer(new ResourceLocation(GTCore.ID, "rubber"));
        ClientHandler.init();
        TextureStitchCallback.PRE.register((ClientHandler::onStitch));
    }
}
