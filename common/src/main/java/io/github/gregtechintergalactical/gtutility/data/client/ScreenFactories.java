package io.github.gregtechintergalactical.gtutility.data.client;

import io.github.gregtechintergalactical.gtutility.GTUtility;
import io.github.gregtechintergalactical.gtutility.gui.ContainerWorkbench;
import io.github.gregtechintergalactical.gtutility.gui.screen.ScreenChargingMaterialBlock;
import muramasa.antimatter.AntimatterAPI;
import net.minecraft.client.gui.screens.MenuScreens;

public class ScreenFactories {
    public final static MenuScreens.ScreenConstructor SCREEN_WORKBENCH = AntimatterAPI.register(MenuScreens.ScreenConstructor.class, "workbench", GTUtility.ID,(MenuScreens.ScreenConstructor)(a, b, c) -> new ScreenChargingMaterialBlock<>((ContainerWorkbench) a,b,c, "workbench"));

    public static void init(){}
}
