package io.github.gregtechintergalactical.gtutility.gui.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.gregtechintergalactical.gtutility.blockentity.BlockEntityMaterial;
import muramasa.antimatter.gui.container.ContainerMachine;
import muramasa.antimatter.gui.screen.ScreenMachine;
import muramasa.antimatter.machine.MachineFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class ScreenChargingMaterialBlock<T extends BlockEntityMaterial<T>> extends ScreenMachine<T, ContainerMachine<T>> {
    public ScreenChargingMaterialBlock(ContainerMachine<T> container, Inventory inv, Component name, String location) {
        super(container, inv, name);
        boolean charged = container.getTile().has(MachineFlag.ENERGY);
        //gui = new ResourceLocation(Ref.ID, "textures/gui/machine/" + (charged ? "charging_" : "") + location + ".png");
    }

    @Override
    protected void drawTitle(PoseStack stack, int mouseX, int mouseY) {
    }
}
