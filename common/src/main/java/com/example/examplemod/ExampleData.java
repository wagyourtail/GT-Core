package com.example.examplemod;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.material.Element;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.TextureSet;

public class ExampleData {


    public static Material ALUMINIUM = AntimatterAPI.register(Material.class, new Material(ExampleMod.ID, "aluminium", 0x80c8f0,TextureSet.DULL, Element.Al));

    public static ItemBasic<?> IRIDIUM_ALLOY_INGOT = new ItemBasic<>(ExampleMod.ID, "iridium_alloy_ingot");

    public static void init() {

    }
}
