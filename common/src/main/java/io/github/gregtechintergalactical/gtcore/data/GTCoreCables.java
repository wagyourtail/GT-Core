package io.github.gregtechintergalactical.gtcore.data;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.block.RedstoneWire;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.material.SubTag;
import muramasa.antimatter.pipe.types.Cable;
import muramasa.antimatter.pipe.types.Wire;

import static io.github.gregtechintergalactical.gtcore.data.GTCoreMaterials.*;
import static muramasa.antimatter.material.MaterialTags.CABLE;
import static muramasa.antimatter.material.MaterialTags.WIRE;

public class GTCoreCables {

    public static final SubTag TIN_WIRE = new SubTag("tin_wire");

    public static final SubTag TIN_CABLE = new SubTag("tin_cable");
    public static final RedstoneWire<?> WIRE_RED_ALLOY = AntimatterAPI.register(RedstoneWire.class, new RedstoneWire<>(GTCore.ID, RedAlloy, 0xd00000));

    public static void init(){
        WIRE.subTag(TIN_WIRE, Tin);
        CABLE.subTag(TIN_CABLE, Tin);
    }
}
