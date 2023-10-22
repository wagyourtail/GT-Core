package io.github.gregtechintergalactical.gtcore.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntityMassStorage;
import io.github.gregtechintergalactical.gtcore.data.SlotTypes;
import muramasa.antimatter.gui.SlotType;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;


public class MassStorageRenderer<T extends BlockEntityMassStorage> implements BlockEntityRenderer<T> {


    @Override
    public void render(T tile, float pPartialTicks, PoseStack matrixStack, MultiBufferSource pBuffer, int pCombinedLight, int pCombinedOverlay) {
        if (Minecraft.getInstance().player != null && !tile.getBlockPos().closerThan(Minecraft.getInstance().player.getOnPos(), 16)) {
            return;
        }
        matrixStack.pushPose();

        Direction facing = tile.getFacing();
        matrixStack.mulPoseMatrix(createTransformMatrix(
                Vector3f.ZERO, new Vector3f(0, 180, 0), 1));

        if (facing == Direction.NORTH) {
            matrixStack.mulPoseMatrix(createTransformMatrix(
                    new Vector3f(-1, 0, 0), Vector3f.ZERO, 1));
        } else if (facing == Direction.EAST) {
            matrixStack.mulPoseMatrix(createTransformMatrix(
                    new Vector3f(-1, 0, -1), new Vector3f(0, -90, 0), 1));
        } else if (facing == Direction.SOUTH) {
            matrixStack.mulPoseMatrix(createTransformMatrix(
                    new Vector3f(0, 0, -1), new Vector3f(0, 180, 0), 1));
        } else if (facing == Direction.WEST) {
            matrixStack.mulPoseMatrix(createTransformMatrix(
                    new Vector3f(0, 0, 0), new Vector3f(0, 90, 0), 1));
        }
        matrixStack.translate(0,0,-0.5/16D);
        pCombinedLight = LevelRenderer.getLightColor(tile.getLevel(), tile.getBlockPos().relative(facing));
        renderSlot(matrixStack, pBuffer, pCombinedLight, pCombinedOverlay, tile);
        matrixStack.popPose();
    }

    private void renderSlot(PoseStack matrixStack, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn, BlockEntityMassStorage tile){

        var display = tile.itemHandler.map(i -> i.getHandler(SlotType.DISPLAY)).orElse(null);
        var storage = tile.itemHandler.map(i -> i.getHandler(SlotTypes.UNLIMITED)).orElse(null);
        if (display != null && storage != null){
            matrixStack.translate(0.5, 0.375, 0.0005f);
            ItemStack stack = display.getItem(0);
            renderStack(matrixStack, bufferIn, combinedLightIn, combinedOverlayIn, stack, stack.getCount(), 0.015f);
        }
    }


    /* Thanks Mekanism */
    public static void renderText(PoseStack matrix, MultiBufferSource renderer, int overlayLight, Component text, Direction side, float maxScale) {

        matrix.translate(0, -0.745, 0);


        float displayWidth = 1;
        float displayHeight = 1;
        //matrix.translate(displayWidth / 2, 0, displayHeight / 2);
        //matrix.mulPose(Vector3f.XP.rotationDegrees(-90));

        Font font = Minecraft.getInstance().font;

        int requiredWidth = Math.max(font.width(text), 1);
        int requiredHeight = font.lineHeight + 2;
        float scaler = 0.4F;
        float scaleX = displayWidth / requiredWidth;
        float scale = scaleX * scaler;
        if (maxScale > 0) {
            scale = Math.min(scale, maxScale);
        }

        matrix.scale(scale, -scale, scale);
        int realHeight = (int) Math.floor(displayHeight / scale);
        int realWidth = (int) Math.floor(displayWidth / scale);
        int offsetX = (realWidth - requiredWidth) / 2;
        int offsetY = (realHeight - requiredHeight) / 2;
        font.drawInBatch(text, offsetX - realWidth / 2, 3 + offsetY - realHeight / 2, overlayLight,
                false, matrix.last().pose(), renderer, false, 0, 0xF000F0);

    }

    public static void renderStack(PoseStack matrixStack, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn, ItemStack stack, int amount, float scale){
        BakedModel model = Minecraft.getInstance().getItemRenderer().getModel(stack, Minecraft.getInstance().level, null, 0);
        if (model.isGui3d()) {
            float thickness = 0.125f;
            // Avoid scaling normal matrix by using mulPoseMatrix() instead of scale()
            matrixStack.mulPoseMatrix(createTransformMatrix(
                    Vector3f.ZERO, Vector3f.ZERO, new Vector3f(.75f, .75f, thickness)));
        } else {
            matrixStack.mulPoseMatrix(createTransformMatrix(
                    Vector3f.ZERO, Vector3f.ZERO, .5f));
        }

        matrixStack.mulPose(Vector3f.YP.rotationDegrees(180));
        Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemTransforms.TransformType.FIXED, combinedLightIn, combinedOverlayIn, matrixStack, bufferIn, 0);

        matrixStack.mulPoseMatrix(createTransformMatrix(
                Vector3f.ZERO, new Vector3f(0, 180, 0), 1));
        if (!model.isGui3d()) {
            matrixStack.mulPoseMatrix(createTransformMatrix(
                    Vector3f.ZERO, Vector3f.ZERO, new Vector3f(0.5f / 0.5f, 0.5f / 0.5f, 1)));
        } else {
            matrixStack.mulPoseMatrix(createTransformMatrix(
                    Vector3f.ZERO, Vector3f.ZERO, .665f));
        }
        //renderText(matrixStack, bufferIn, combinedOverlayIn, new TextComponent(ChatFormatting.WHITE + "" + amount), Direction.NORTH, scale);

    }

    public static Matrix4f createTransformMatrix(Vector3f translation, Vector3f eulerDegrees, Vector3f scale) {
        Quaternion q = Quaternion.fromXYZDegrees(eulerDegrees);
        return createTransformMatrix(translation, q, scale);
    }

    public static Matrix4f createTransformMatrix(Vector3f translation, Vector3f eulerDegrees, float scale) {
        return createTransformMatrix(translation, eulerDegrees, new Vector3f(scale, scale, scale));
    }

    public static Matrix4f createTransformMatrix(Vector3f translation, Quaternion rotation, Vector3f scale) {
        Matrix4f transform = Matrix4f.createTranslateMatrix(translation.x(), translation.y(), translation.z());
        transform.multiply(rotation);
        Matrix4f scaleMat = Matrix4f.createScaleMatrix(scale.x(), scale.y(), scale.z());
        transform.multiply(scaleMat);
        return transform;
    }

    public static Matrix4f createTransformMatrix(Vector3f translation, Quaternion rotation, float scale) {
        return createTransformMatrix(translation, rotation, new Vector3f(scale, scale, scale));
    }
}
