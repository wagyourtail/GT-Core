package io.github.gregtechintergalactical.gtcore.integration.top;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntityMassStorage;
import io.github.gregtechintergalactical.gtcore.data.SlotTypes;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoProvider;
import mcjty.theoneprobe.api.ProbeMode;
import mcjty.theoneprobe.apiimpl.elements.ElementItemStack;
import mcjty.theoneprobe.apiimpl.elements.ElementVertical;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.awt.*;

public class MassStorageProvider implements IProbeInfoProvider {
    @Override
    public ResourceLocation getID() {
        return new ResourceLocation(GTCore.ID, "mass_Storage");
    }

    @Override
    public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, Player player, Level level, BlockState blockState, IProbeHitData iProbeHitData) {
        BlockEntity blockEntity = level.getBlockEntity(iProbeHitData.getPos());
        if (blockEntity instanceof BlockEntityMassStorage massStorage){
            var handler = massStorage.itemHandler.map(i -> i.getHandler(SlotTypes.UNLIMITED)).orElse(null);
            if (handler != null){
                iProbeInfo.getElements().removeIf(iElement -> iElement instanceof ElementVertical);
                ElementVertical vertical = new ElementVertical();
                ElementVertical elementVertical = new ElementVertical(iProbeInfo.defaultLayoutStyle().spacing(2).leftPadding(7).rightPadding(7));
                elementVertical.getStyle().borderColor(Color.CYAN.darker().getRGB());
                ItemStack stack = handler.getItem(0);
                if (stack.getCount() > 0){
                    elementVertical.element(new ElementItemStack(stack, iProbeInfo.defaultItemStyle()));
                }
                if (!elementVertical.getElements().isEmpty()) vertical.element(elementVertical);
                vertical.element(new ElementVertical(iProbeInfo.defaultLayoutStyle().topPadding(4)));
            }
        }
    }
}
