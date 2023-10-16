package io.github.gregtechintergalactical.gtcore;

import io.github.gregtechintergalactical.gtcore.data.GTCoreItems;
import io.github.gregtechintergalactical.gtcore.machine.DrumMachine;
import io.github.gregtechintergalactical.gtcore.machine.LockerMachine;
import io.github.gregtechintergalactical.gtcore.machine.WorkbenchMachine;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.AntimatterRemapping;
import muramasa.antimatter.machine.BlockMachine;
import muramasa.antimatter.registration.IAntimatterObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

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
        AntimatterAPI.all(Block.class, GTCore.ID).stream().filter(b -> b instanceof IAntimatterObject && !(b instanceof BlockMachine)).map(b -> (IAntimatterObject)b).forEach(b -> {
            AntimatterRemapping.remap(new ResourceLocation("gtrubber", b.getId()), b.getLoc());
        });
        AntimatterRemapping.remapBlockEntity(new ResourceLocation("gtrubber", "sap_bag"), new ResourceLocation(GTCore.ID, "sap_bag"));
        AntimatterRemapping.remap(new ResourceLocation("gtrubber", "sticky_resin"), GTCoreItems.StickyResin.getLoc());
        AntimatterRemapping.remap(new ResourceLocation("gtrubber", "rubber_boat"), GTCoreItems.RubberBoat.getLoc());
        AntimatterRemapping.remap(new ResourceLocation("gtrubber", "rubber_lumber"), new ResourceLocation(GTCore.ID, "rubber_lumber"));
    }
}
