package io.github.gregtechintergalactical.gtcore.data;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.machine.DrumMachine;
import io.github.gregtechintergalactical.gtcore.machine.LockerMachine;
import io.github.gregtechintergalactical.gtcore.machine.WorkbenchMachine;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.material.Material;

public class GTCoreData {

    public static void init() {
    }

    public static DrumMachine createDrum(Material material, int maxCapacity){
        DrumMachine machine = AntimatterAPI.get(DrumMachine.class, material.getId() + "_drum", GTCore.ID);
        if (machine != null){
            return machine;
        }
        return new DrumMachine(GTCore.ID, material, maxCapacity);
    }

    public static WorkbenchMachine createWorkbench(Material material, boolean charge){
        WorkbenchMachine machine = AntimatterAPI.get(WorkbenchMachine.class, material.getId() + (charge ? "_charging" : "") + "_workbench", GTCore.ID);
        if (machine != null){
            return machine;
        }
        return new WorkbenchMachine(GTCore.ID, material, charge);
    }

    public static LockerMachine createLocker(Material material, boolean charge){
        LockerMachine machine = AntimatterAPI.get(LockerMachine.class, material.getId() + (charge ? "_charging" : "") + "_locker", GTCore.ID);
        if (machine != null){
            return machine;
        }
        return new LockerMachine(GTCore.ID, material, charge);
    }
}
