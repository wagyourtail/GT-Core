package io.github.gregtechintergalactical.gtutility;

import io.github.gregtechintergalactical.gtutility.machine.DrumMachine;
import io.github.gregtechintergalactical.gtutility.machine.WorkbenchMachine;
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
        DrumMachine machine = AntimatterAPI.get(DrumMachine.class, material.getId() + "_drum", GTUtility.ID);
        if (machine != null){
            return machine;
        }
        return new DrumMachine(GTUtility.ID, material, maxCapacity);
    }

    public static WorkbenchMachine createWorkbench(Material material, boolean charge){
        WorkbenchMachine machine = AntimatterAPI.get(WorkbenchMachine.class, material.getId() + (charge ? "_charging" : "") + "_workbench", GTUtility.ID);
        if (machine != null){
            return machine;
        }
        return new WorkbenchMachine(GTUtility.ID, material, charge);
    }
}
