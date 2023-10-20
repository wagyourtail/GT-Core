package io.github.gregtechintergalactical.gtcore.data;

import io.github.gregtechintergalactical.gtcore.GTCore;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.pipe.types.Cable;
import muramasa.antimatter.pipe.types.Wire;

import static io.github.gregtechintergalactical.gtcore.data.GTCoreMaterials.*;

public class GTCoreCables {
    public static final Cable<?> CABLE_RED_ALLOY = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, RedAlloy, 0, Tier.ULV).amps(1));
    public static final Cable<?> CABLE_COBALT = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Cobalt, 2, Tier.LV).amps(2)); //L);
    public static final Cable<?> CABLE_LEAD = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Lead, 2, Tier.LV).amps(2));
    public static final Cable<?> CABLE_TIN = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Tin, 1, Tier.LV).amps(1));
    public static final Cable<?> CABLE_ZINC = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Zinc, 1, Tier.LV).amps(1));
    public static final Cable<?> CABLE_SOLDERING_ALLOY = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, SolderingAlloy, 1, Tier.LV).amps(1));
    public static final Cable<?> CABLE_IRON = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, AntimatterMaterials.Iron, 3, Tier.MV).amps(2)); //M);
    public static final Cable<?> CABLE_NICKEL = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Nickel, 3, Tier.MV).amps(3));
    public static final Cable<?> CABLE_CUPRONICKEL = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Cupronickel, 3, Tier.MV).amps(2));
    public static final Cable<?> CABLE_COPPER = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, AntimatterMaterials.Copper, 2, Tier.MV).amps(1));
    public static final Cable<?> CABLE_ANNEALED_COPPER = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, AnnealedCopper, 1, Tier.MV).amps(1));
    public static final Cable<?> CABLE_KANTHAL = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Kanthal, 3, Tier.HV).amps(4)); //H);
    public static final Cable<?> CABLE_GOLD = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, AntimatterMaterials.Gold, 2, Tier.HV).amps(3));
    public static final Cable<?> CABLE_ELECTRUM = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Electrum, 2, Tier.HV).amps(2));
    public static final Cable<?> CABLE_SILVER = AntimatterAPI.register(Cable.class,new Cable<>(GTCore.ID, Silver, 1, Tier.HV).amps(1));
    public static final Cable<?> CABLE_NICHROME = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Nichrome, 4, Tier.EV).amps(3)); //E);
    public static final Cable<?> CABLE_STEEL = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Steel, 2, Tier.EV).amps(2));
    public static final Cable<?> CABLE_TITANIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Titanium, 2, Tier.EV).amps(4));
    public static final Cable<?> CABLE_ALUMINIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Aluminium, 1, Tier.EV).amps(1));
    public static final Cable<?> CABLE_GRAPHENE = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Graphene, 1, Tier.IV).amps(1)); //I);
    public static final Cable<?> CABLE_OSMIUM = AntimatterAPI.register(Cable.class,new Cable<>(GTCore.ID, Osmium, 2, Tier.IV).amps(4));
    public static final Cable<?> CABLE_PLATINUM = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Platinum, 1, Tier.IV).amps(2));
    public static final Cable<?> CABLE_TUNGSTEN_STEEL = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, TungstenSteel, 2, Tier.IV).amps(3));
    public static final Cable<?> CABLE_TUNGSTEN = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Tungsten, 2, Tier.IV).amps(1));
    public static final Cable<?> CABLE_HSSG = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, HSSG, 2, Tier.LUV).amps(4)); //LU);
    public static final Cable<?> CABLE_NIOBIUM_TITANIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, NiobiumTitanium, 2, Tier.LUV).amps(4));
    public static final Cable<?> CABLE_VANADIUM_GALLIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, VanadiumGallium, 2, Tier.LUV).amps(4));
    public static final Cable<?> CABLE_YTTRIUM_BARIUM_CUPRATE = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, YttriumBariumCuprate, 4, Tier.LUV).amps(4));
    public static final Cable<?> CABLE_NAQUADAH = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Naquadah, 2, Tier.ZPM).amps(2)); //ZP);
    public static final Cable<?> CABLE_NAQUADAH_ALLOY = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, NaquadahAlloy, 4, Tier.ZPM).amps(2));
    public static final Cable<?> CABLE_DURANIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Duranium, 8, Tier.ZPM).amps(1));
    public static final Cable<?> CABLE_SUPERCONDUCTOR = AntimatterAPI.register(Cable.class, new Cable<>(GTCore.ID, Superconductor, 0, Tier.UHV).amps(4)); //MA);


    public static final Wire<?> WIRE_RED_ALLOY = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, RedAlloy, 1, Tier.ULV).amps(1));
    public static final Wire<?> WIRE_COBALT = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Cobalt, 4, Tier.LV).amps(2)); //L);
    public static final Wire<?> WIRE_LEAD = AntimatterAPI.register(Wire.class,  new Wire<>(GTCore.ID, Lead, 4, Tier.LV).amps(2));
    public static final Wire<?> WIRE_TIN = AntimatterAPI.register(Wire.class,  new Wire<>(GTCore.ID, Tin, 2, Tier.LV).amps(1));
    public static final Wire<?> WIRE_ZINC = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Zinc, 2, Tier.LV).amps(1));
    public static final Wire<?> WIRE_SOLDERING_ALLOY = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, SolderingAlloy, 2, Tier.LV).amps(1));
    public static final Wire<?> WIRE_IRON = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, AntimatterMaterials.Iron, 6, Tier.MV).amps(2)); //M);
    public static final Wire<?> WIRE_NICKEL = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Nickel, 6, Tier.MV).amps(3));
    public static final Wire<?> WIRE_CUPRONICKEL = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Cupronickel, 6, Tier.MV).amps(2));
    public static final Wire<?> WIRE_COPPER = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, AntimatterMaterials.Copper, 4, Tier.MV).amps(1));
    public static final Wire<?> WIRE_ANNEALED_COPPER = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, AnnealedCopper, 2, Tier.MV).amps(1));
    public static final Wire<?> WIRE_KANTHAL = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Kanthal, 6, Tier.HV).amps(4)); //H);
    public static final Wire<?> WIRE_GOLD = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, AntimatterMaterials.Gold, 4, Tier.HV).amps(3));
    public static final Wire<?> WIRE_ELECTRUM = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Electrum, 4, Tier.HV).amps(2));
    public static final Wire<?> WIRE_SILVER = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Silver, 2, Tier.HV).amps(1));
    public static final Wire<?> WIRE_NICHROME = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Nichrome, 8, Tier.EV).amps(3)); //E);
    public static final Wire<?> WIRE_STEEL = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Steel, 4, Tier.EV).amps(2));
    public static final Wire<?> WIRE_TITANIUM = AntimatterAPI.register(Wire.class,  new Wire<>(GTCore.ID, Titanium, 4, Tier.EV).amps(4));
    public static final Wire<?> WIRE_ALUMINIUM = AntimatterAPI.register(Wire.class,new Wire<>(GTCore.ID, Aluminium, 2, Tier.EV).amps(1));
    public static final Wire<?> WIRE_GRAPHENE = AntimatterAPI.register(Wire.class,  new Wire<>(GTCore.ID, Graphene, 2, Tier.IV).amps(1)); //I);
    public static final Wire<?> WIRE_OSMIUM = AntimatterAPI.register(Wire.class,new Wire<>(GTCore.ID, Osmium, 4, Tier.IV).amps(4));
    public static final Wire<?> WIRE_PLATINUM = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Platinum, 2, Tier.IV).amps(2));
    public static final Wire<?> WIRE_TUNGSTEN_STEEL = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, TungstenSteel, 2, Tier.IV).amps(3));
    public static final Wire<?> WIRE_TUNGSTEN = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, Tungsten, 2, Tier.IV).amps(1));
    public static final Wire<?> WIRE_HSSG = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, HSSG, 4, Tier.LUV).amps(4)); //LU);
    public static final Wire<?> WIRE_NIOBIUM_TITANIUM = AntimatterAPI.register(Wire.class,new Wire<>(GTCore.ID, NiobiumTitanium, 4, Tier.LUV).amps(4));
    public static final Wire<?> WIRE_VANADIUM_GALLIUM = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, VanadiumGallium, 4, Tier.LUV).amps(4));
    public static final Wire<?> WIRE_YTTRIUM_BARIUM_CUPRATE = AntimatterAPI.register(Wire.class, new Wire<>(GTCore.ID, YttriumBariumCuprate, 8, Tier.LUV).amps(4));
    public static final Wire<?> WIRE_NAQUADAH = AntimatterAPI.register(Wire.class,new Wire<>(GTCore.ID, Naquadah, 4, Tier.ZPM).amps(2)); //ZP);
    public static final Wire<?> WIRE_NAQUADAH_ALLOY = AntimatterAPI.register(Wire.class,new Wire<>(GTCore.ID, NaquadahAlloy, 8, Tier.ZPM).amps(2));
    public static final Wire<?> WIRE_DURANIUM = AntimatterAPI.register(Wire.class,new Wire<>(GTCore.ID, Duranium, 16, Tier.ZPM).amps(1));
    public static final Wire<?> WIRE_SUPERCONDUCTOR = AntimatterAPI.register(Wire.class,new Wire<>(GTCore.ID, Superconductor, 1, Tier.UHV).amps(4)); //MA);

    public static void init(){

    }
}
