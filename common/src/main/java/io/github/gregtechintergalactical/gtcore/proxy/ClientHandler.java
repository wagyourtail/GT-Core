package io.github.gregtechintergalactical.gtcore.proxy;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntityMassStorage;
import io.github.gregtechintergalactical.gtcore.client.MassStorageRenderer;
import io.github.gregtechintergalactical.gtcore.data.GTCoreBlocks;
import io.github.gregtechintergalactical.gtcore.machine.BlockMachineMaterial;
import io.github.gregtechintergalactical.gtcore.machine.BlockMultiMachineMaterial;
import io.github.gregtechintergalactical.gtcore.machine.MassStorageMachine;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.client.ModelUtils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ClientHandler {

    public static void init(){
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new Material(Sheets.SIGN_SHEET, GTCoreBlocks.RUBBER_SIGN.getTexture()));
        AntimatterAPI.all(BlockMachineMaterial.class, b -> {
            if (b.getType() instanceof MassStorageMachine) {
                muramasa.antimatter.proxy.ClientHandler.registerBlockEntityRenderer((BlockEntityType<BlockEntityMassStorage>) b.getType().getTileType(), c -> new MassStorageRenderer<>());
            }
        });
        AntimatterAPI.runLaterClient(() -> {
            AntimatterAPI.all(BlockMachineMaterial.class, b -> ModelUtils.setRenderLayer(b, RenderType.cutout()));
            AntimatterAPI.all(BlockMultiMachineMaterial.class, b -> ModelUtils.setRenderLayer(b, RenderType.cutout()));
            ModelUtils.setRenderLayer(GTCoreBlocks.RUBBER_SAPLING, RenderType.cutout());
            ModelUtils.setRenderLayer(GTCoreBlocks.RUBBER_LEAVES, RenderType.cutout());
            ModelUtils.setRenderLayer(GTCoreBlocks.RUBBER_TRAPDOOR, RenderType.cutout());
            ModelUtils.setRenderLayer(GTCoreBlocks.RUBBER_DOOR, RenderType.cutout());
            ModelUtils.setRenderLayer(GTCoreBlocks.SAP_BAG, RenderType.cutout());
        });
    }
}
