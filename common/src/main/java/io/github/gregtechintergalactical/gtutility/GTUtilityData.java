package io.github.gregtechintergalactical.gtutility;

import io.github.gregtechintergalactical.gtutility.machine.DrumMachine;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.material.Element;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.TextureSet;

public class GTUtilityData {


    public static DrumMachine IRON_DRUM = new DrumMachine(GTUtility.ID, "iron_drum", AntimatterMaterials.Iron, 16000);

    public static void init() {

    }
}
