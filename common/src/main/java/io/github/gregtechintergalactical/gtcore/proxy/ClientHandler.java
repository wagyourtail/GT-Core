package io.github.gregtechintergalactical.gtcore.proxy;

import io.github.gregtechintergalactical.gtcore.machine.BlockMachineMaterial;
import io.github.gregtechintergalactical.gtcore.machine.BlockMultiMachineMaterial;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.client.ModelUtils;
import net.minecraft.client.renderer.RenderType;

public class ClientHandler {

    public static void init(){
        AntimatterAPI.runLaterClient(() -> {
            AntimatterAPI.all(BlockMachineMaterial.class, b -> ModelUtils.setRenderLayer(b, RenderType.cutout()));
            AntimatterAPI.all(BlockMultiMachineMaterial.class, b -> ModelUtils.setRenderLayer(b, RenderType.cutout()));
        });
    }
}
