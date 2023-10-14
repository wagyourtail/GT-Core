package io.github.gregtechintergalactical.gtcore.data;

import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntityMaterial;
import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.gui.ContainerWorkbench;
import muramasa.antimatter.capability.IGuiHandler;
import muramasa.antimatter.gui.MenuHandlerMachine;
import net.minecraft.world.entity.player.Inventory;

public class MenuHandlers {
    public static MenuHandlerMachine<? extends BlockEntityMaterial, ? extends ContainerWorkbench> WORKBENCH_HANDLER = new MenuHandlerMachine(GTCore.ID, "container_workbench") {
        @Override
        public ContainerWorkbench getMenu(IGuiHandler tile, Inventory playerInv, int windowId) {
            return tile instanceof BlockEntityMaterial ? new ContainerWorkbench((BlockEntityMaterial) tile, playerInv, this, windowId) : null;
        }

        @Override
        public String screenDomain() {
            return GTCore.ID;
        }

        @Override
        public String screenID() {
            return "workbench";
        }
    };

    public static void init(){

    }
}
