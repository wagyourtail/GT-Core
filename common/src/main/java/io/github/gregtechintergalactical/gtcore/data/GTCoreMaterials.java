package io.github.gregtechintergalactical.gtcore.data;

import io.github.gregtechintergalactical.gtcore.GTCore;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.material.Material;

import static muramasa.antimatter.material.TextureSet.SHINY;

public class GTCoreMaterials {
    public static Material RUBBER = AntimatterAPI.register(Material.class, new Material(GTCore.ID, "rubber", 0x000000, SHINY));
    public static void init(){

    }
}
