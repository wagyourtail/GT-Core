package io.github.gregtechintergalactical.gtcore.fabric;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.proxy.ClientHandler;
import muramasa.antimatter.client.fabric.IAntimatterClientInitializer;
import net.minecraft.resources.ResourceLocation;

public class GTCoreClientInitializer implements IAntimatterClientInitializer {
    @Override
    public void onInitializeClient() {
        TerraformBoatClientHelper.registerModelLayer(new ResourceLocation(GTCore.ID, "rubber"));
        ClientHandler.init();
    }
}
