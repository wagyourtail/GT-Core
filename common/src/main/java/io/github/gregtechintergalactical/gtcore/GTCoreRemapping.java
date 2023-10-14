package io.github.gregtechintergalactical.gtcore;

import io.github.gregtechintergalactical.gtcore.machine.DrumMachine;
import io.github.gregtechintergalactical.gtcore.machine.LockerMachine;
import io.github.gregtechintergalactical.gtcore.machine.WorkbenchMachine;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.AntimatterRemapping;
import net.minecraft.resources.ResourceLocation;

public class GTCoreRemapping {

    public static void init(){
        AntimatterAPI.all(DrumMachine.class, GTCore.ID).forEach(m -> {
            AntimatterRemapping.remapMachine(new ResourceLocation("gtutility", m.getId()), m);
        });
        AntimatterAPI.all(WorkbenchMachine.class, GTCore.ID).forEach(m -> {
            AntimatterRemapping.remapMachine(new ResourceLocation("gtutility", m.getId()), m);
        });
        AntimatterAPI.all(LockerMachine.class, GTCore.ID).forEach(m -> {
            AntimatterRemapping.remapMachine(new ResourceLocation("gtutility", m.getId()), m);
        });
    }
}
