package io.github.gregtechintergalactical.gtutility;

import io.github.gregtechintergalactical.gtutility.machine.DrumMachine;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterMaterialTypes;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.material.Element;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.TextureSet;

public class GTUtilityData {

    public static void init() {

    }

    public static DrumMachine createDrum(Material material, int maxCapacity){
        Machine<?> machine = AntimatterAPI.get(Machine.class, material.getId() + "_drum", GTUtility.ID);
        if (machine != null){
            if (machine instanceof DrumMachine drumMachine){
                return drumMachine;
            } else {
                throw new IllegalStateException("Drum registered not using DrumMachine");
            }
        }
        return new DrumMachine(GTUtility.ID, material, maxCapacity);
    }
}
