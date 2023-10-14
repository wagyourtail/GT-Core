package io.github.gregtechintergalactical.gtcore.data.client;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.gui.ContainerWorkbench;
import io.github.gregtechintergalactical.gtcore.gui.screen.ScreenChargingMaterialBlock;
import muramasa.antimatter.AntimatterAPI;
import net.minecraft.client.gui.screens.MenuScreens;

public class ScreenFactories {
    public final static MenuScreens.ScreenConstructor SCREEN_WORKBENCH = AntimatterAPI.register(MenuScreens.ScreenConstructor.class, "workbench", GTCore.ID,(MenuScreens.ScreenConstructor)(a, b, c) -> new ScreenChargingMaterialBlock<>((ContainerWorkbench) a,b,c, "workbench"));

    public static void init(){}
}
