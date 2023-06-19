package io.github.gregtechintergalactical.gtutility;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.material.Element;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.TextureSet;

public class GTUtilityData {


    public static Material ALUMINIUM = AntimatterAPI.register(Material.class, new Material(GTUtility.ID, "aluminium", 0x80c8f0,TextureSet.DULL, Element.Al));

    public static ItemBasic<?> IRIDIUM_ALLOY_INGOT = new ItemBasic<>(GTUtility.ID, "iridium_alloy_ingot");

    public static void init() {

    }
}
