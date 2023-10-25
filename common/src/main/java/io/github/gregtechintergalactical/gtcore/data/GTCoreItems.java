package io.github.gregtechintergalactical.gtcore.data;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.item.ItemPowerUnit;
import io.github.gregtechintergalactical.gtcore.tree.item.ItemRubberBoat;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.item.ItemMultiTextureBattery;
import muramasa.antimatter.machine.Tier;

import static io.github.gregtechintergalactical.gtcore.data.GTCoreMaterials.*;

public class GTCoreItems {
    public static ItemBasic<?> StickyResin = new ItemBasic<>(GTCore.ID, "sticky_resin");
    public static ItemRubberBoat RubberBoat = new ItemRubberBoat();

    public static ItemBasic<?> Biochaff = new ItemBasic<>(GTCore.ID, "biochaff");
    public static ItemBasic<?> CarbonFibre = new ItemBasic<>(GTCore.ID, "raw_carbon_fibre");
    public static ItemBasic<?> CarbonMesh = new ItemBasic<>(GTCore.ID, "carbon_mesh");
    public static ItemBasic<?> CoalBall = new ItemBasic<>(GTCore.ID, "coal_ball");
    public static ItemBasic<?> CompressedCoalBall = new ItemBasic<>(GTCore.ID, "compressed_coal_ball");
    public static ItemBasic<?> CoalChunk = new ItemBasic<>(GTCore.ID, "coal_chunk");
    public static ItemBasic<?> DiamondSawBlade = new ItemBasic<>(GTCore.ID, "diamond_saw_blade");
    public static ItemBasic<?> DiamondGrindHead = new ItemBasic<>(GTCore.ID, "diamond_grind_head");
    public static ItemBasic<?> TungstenGrindHead = new ItemBasic<>(GTCore.ID, "tungsten_grind_head");
    public static ItemBasic<?> IridiumAlloyIngot = new ItemBasic<>(GTCore.ID, "iridium_alloy_ingot").tip("Used to make Iridium Plates");
    public static ItemBasic<?> IridiumReinforcedPlate = new ItemBasic<>(GTCore.ID, "iridium_reinforced_plate").tip("GT2s Most Expensive Component");
    public static ItemBasic<?> IridiumNeutronReflector = new ItemBasic<>(GTCore.ID, "iridium_neutron_reflector").tip("Indestructible");

    public static ItemBasic<?> GlassTube = new ItemBasic<>(GTCore.ID, "glass_tube", "circuits/");

    public static ItemBasic<?> VacuumTube = new ItemBasic<>(GTCore.ID, "vacuum_tube", "circuits/");

    public static ItemBasic<?> CircuitBoardBasic = new ItemBasic<>(GTCore.ID, "basic_circuit_board", "circuits/");
    public static ItemBasic<?> CircuitBoardAdvanced = new ItemBasic<>(GTCore.ID, "advanced_circuit_board", "circuits/");
    public static ItemBasic<?> CircuitBoardEmpty = new ItemBasic<>(GTCore.ID, "empty_circuit_board", "circuits/");
    public static ItemBasic<?> CircuitBoardProcessor = new ItemBasic<>(GTCore.ID, "processor_circuit_board", "circuits/");
    public static ItemBasic<?> CircuitBoardProcessorEmpty = new ItemBasic<>(GTCore.ID, "empty_processor_circuit_board", "circuits/");

    public static ItemBasic<?> CircuitBasic = new ItemBasic<>(GTCore.ID, "basic_circuit", "circuits/").tip("A Basic Circuit");
    public static ItemBasic<?> CircuitGood = new ItemBasic<>(GTCore.ID, "good_circuit", "circuits/").tip("A Good Circuit");
    public static ItemBasic<?> CircuitAdv = new ItemBasic<>(GTCore.ID, "advanced_circuit", "circuits/").tip("A Advanced Circuit");
    public static ItemBasic<?> CircuitComplex = new ItemBasic<>(GTCore.ID, "complex_circuit", "circuits/").tip("A Complex Circuit");
    public static ItemBasic<?> CircuitDataStorage = new ItemBasic<>(GTCore.ID, "data_storage_circuit", "circuits/");
    public static ItemBasic<?> CircuitElite = new ItemBasic<>(GTCore.ID, "elite_circuit", "circuits/").tip("A Elite Circuit");
    public static ItemBasic<?> CircuitFuturistic = new ItemBasic<>(GTCore.ID, "futuristic_circuit", "circuits/").tip("A Futuristic Circuit");
    public static ItemBasic<?> Circuit3D = new ItemBasic<>(GTCore.ID, "3d_circuit", "circuits/").tip("A 3-Dimensional Circuit");
    public static ItemBasic<?> CircuitEnergyFlow = new ItemBasic<>(GTCore.ID, "energy_flow_circuit", "circuits/").tip("A High Voltage Processor"); //maybe name futuristic
    public static ItemBasic<?> CircuitInfinite = new ItemBasic<>(GTCore.ID, "infinite_circuit", "circuits/").tip("A Circuit with Infinite Power Throughput");
    public static ItemBasic<?> CircuitDataControl = new ItemBasic<>(GTCore.ID, "data_control_circuit", "circuits/"); //could be considered BIO
    public static ItemBasic<?> DataOrb = new ItemBasic<>(GTCore.ID, "data_orb", "circuits/");

    public static ItemPowerUnit PowerUnitLV = new ItemPowerUnit(GTCore.ID, "power_unit_lv", Aluminium);
    public static ItemPowerUnit PowerUnitMV = new ItemPowerUnit(GTCore.ID, "power_unit_mv", StainlessSteel);
    public static ItemPowerUnit PowerUnitHV = new ItemPowerUnit(GTCore.ID, "power_unit_hv", Titanium);
    public static ItemPowerUnit SmallPowerUnit = new ItemPowerUnit(GTCore.ID, "small_power_unit", Aluminium);

    public static ItemBasic<?> BatteryHullSmall = new ItemBasic<>(GTCore.ID, "small_battery_hull").tip("An empty LV Battery Hull");
    public static ItemBasic<?> BatteryHullMedium = new ItemBasic<>(GTCore.ID, "medium_battery_hull").tip("An empty MV Battery Hull");
    public static ItemBasic<?> BatteryHullLarge = new ItemBasic<>(GTCore.ID, "large_battery_hull").tip("An empty HV Battery Hull");
    public static ItemBasic<?> BatteryRE = new ItemMultiTextureBattery(GTCore.ID, "re_battery", Tier.LV, 10000, true).tip("Reusable Battery");
    public static ItemBasic<?> BatterySmallAcid = new ItemMultiTextureBattery(GTCore.ID, "small_acid_battery", Tier.LV, 18000, false).tip("Single Use");
    public static ItemBasic<?> BatterySmallMercury = new ItemMultiTextureBattery(GTCore.ID, "small_mercury_battery", Tier.LV, 32000, false).tip("Single Use");
    public static ItemBasic<?> BatterySmallCadmium = new ItemMultiTextureBattery(GTCore.ID, "small_cadmium_battery", Tier.LV,75000, 2, true).tip("Reusable");
    public static ItemBasic<?> BatterySmallLithium = new ItemMultiTextureBattery(GTCore.ID, "small_lithium_battery", Tier.LV, 100000, true).tip("Reusable");
    public static ItemBasic<?> BatterySmallSodium = new ItemMultiTextureBattery(GTCore.ID, "small_sodium_battery", Tier.LV, 50000, true).tip("Reusable");
    public static ItemBasic<?> BatteryMediumAcid = new ItemMultiTextureBattery(GTCore.ID, "medium_acid_battery", Tier.MV, 72000, false).tip("Single Use");
    public static ItemBasic<?> BatteryMediumMercury = new ItemMultiTextureBattery(GTCore.ID, "medium_mercury_battery", Tier.MV, 128000, false).tip("Single Use");
    public static ItemBasic<?> BatteryMediumCadmium = new ItemMultiTextureBattery(GTCore.ID, "medium_cadmium_battery", Tier.MV, 300000, 2, true).tip("Reusable");
    public static ItemBasic<?> BatteryMediumLithium = new ItemMultiTextureBattery(GTCore.ID, "medium_lithium_battery", Tier.MV, 400000, true).tip("Reusable");
    public static ItemBasic<?> BatteryMediumSodium = new ItemMultiTextureBattery(GTCore.ID, "medium_sodium_battery", Tier.MV,200000, true).tip("Reusable");
    public static ItemBasic<?> BatteryLargeAcid = new ItemMultiTextureBattery(GTCore.ID, "large_acid_battery", Tier.HV, 288000, false).tip("Single Use");
    public static ItemBasic<?> BatteryLargeMercury = new ItemMultiTextureBattery(GTCore.ID, "large_mercury_battery", Tier.HV, 512000, false).tip("Single Use");
    public static ItemBasic<?> BatteryLargeCadmium = new ItemMultiTextureBattery(GTCore.ID, "large_cadmium_battery", Tier.HV, 1200000, 2, true).tip("Reusable");
    public static ItemBasic<?> BatteryLargeLithium = new ItemMultiTextureBattery(GTCore.ID, "large_lithium_battery", Tier.HV, 1600000, true).tip("Reusable");
    public static ItemBasic<?> BatteryLargeSodium = new ItemMultiTextureBattery(GTCore.ID, "large_sodium_battery", Tier.HV, 800000, true).tip("Reusable");
    public static ItemBasic<?> EnergyCrystal = new ItemMultiTextureBattery(GTCore.ID, "energy_crystal", Tier.HV, 1_000_000, true);
    public static ItemBasic<?> LapotronCrystal = new ItemMultiTextureBattery(GTCore.ID, "lapotron_crystal", Tier.EV, 10_000_000, true);
    public static ItemBasic<?> BatteryEnergyOrb = new ItemMultiTextureBattery(GTCore.ID, "lapotronic_energy_orb", Tier.IV, 100_000_000, true);
    public static ItemBasic<?> BatteryEnergyOrbCluster = new ItemMultiTextureBattery(GTCore.ID, "lapotronic_energy_orb_cluster", Tier.LUV, 1_000_000_000, true);

    public static ItemBasic<?> EmptyShape = new ItemBasic<>(GTCore.ID, "empty_shape_plate", "molds/").tip("Raw plate to make Molds and Extruder Shapes");
    public static ItemBasic<?> MoldPlate = new ItemBasic<>(GTCore.ID, "plate_mold", "molds/").tip("Mold for making Plates");
    public static ItemBasic<?> MoldCasing = new ItemBasic<>(GTCore.ID, "casing_mold", "molds/").tip("Mold for making Item Casings");
    public static ItemBasic<?> MoldGear = new ItemBasic<>(GTCore.ID, "gear_mold", "molds/").tip("Mold for making Gears");
    public static ItemBasic<?> MoldGearSmall = new ItemBasic<>(GTCore.ID, "small_gear_mold", "molds/").tip("Mold for making Small Gears");
    public static ItemBasic<?> MoldCoinage = new ItemBasic<>(GTCore.ID, "coinage_mold", "molds/").tip("Secure Mold for making Coins (Don't lose it!)");
    public static ItemBasic<?> MoldBottle = new ItemBasic<>(GTCore.ID, "bottle_mold", "molds/").tip("Mold for making Bottles");
    public static ItemBasic<?> MoldIngot = new ItemBasic<>(GTCore.ID, "ingot_mold", "molds/").tip("Mold for making Ingots");
    public static ItemBasic<?> MoldBall = new ItemBasic<>(GTCore.ID, "ball_mold", "molds/").tip("Mold for making Balls");
    public static ItemBasic<?> MoldBlock = new ItemBasic<>(GTCore.ID, "block_mold", "molds/").tip("Mold for making Blocks");
    public static ItemBasic<?> MoldNugget = new ItemBasic<>(GTCore.ID, "nugget_mold", "molds/").tip("Mold for making Nuggets");
    public static ItemBasic<?> MoldAnvil = new ItemBasic<>(GTCore.ID, "anvil_mold", "molds/").tip("Mold for making Anvils");
    public static ItemBasic<?> ShapePlate = new ItemBasic<>(GTCore.ID, "plate_shape", "molds/").tip("Shape for making Plates");
    public static ItemBasic<?> ShapeCasing = new ItemBasic<>(GTCore.ID, "casing_shape", "molds/").tip("Shape for making Item Casings");
    public static ItemBasic<?> ShapeRod = new ItemBasic<>(GTCore.ID, "rod_shape", "molds/").tip("Shape for making Rods");
    public static ItemBasic<?> ShapeBolt = new ItemBasic<>(GTCore.ID, "bolt_shape", "molds/").tip("Shape for making Bolts");
    public static ItemBasic<?> ShapeRing = new ItemBasic<>(GTCore.ID, "ring_shape", "molds/").tip("Shape for making Rings");
    public static ItemBasic<?> ShapeCell = new ItemBasic<>(GTCore.ID, "cell_shape", "molds/").tip("Shape for making Cells");
    public static ItemBasic<?> ShapeIngot = new ItemBasic<>(GTCore.ID, "ingot_shape", "molds/").tip("Shape for making Ingots");
    public static ItemBasic<?> ShapeWire = new ItemBasic<>(GTCore.ID, "wire_shape", "molds/").tip("Shape for making Wires");
    public static ItemBasic<?> ShapePipeTiny = new ItemBasic<>(GTCore.ID, "tiny_pipe_shape", "molds/").tip("Shape for making Tiny Pipes");
    public static ItemBasic<?> ShapePipeSmall = new ItemBasic<>(GTCore.ID, "small_pipe_shape", "molds/").tip("Shape for making Small Pipes");
    public static ItemBasic<?> ShapePipeNormal = new ItemBasic<>(GTCore.ID, "normal_pipe_shape", "molds/").tip("Shape for making Normal Pipes");
    public static ItemBasic<?> ShapePipeLarge = new ItemBasic<>(GTCore.ID, "large_pipe_shape", "molds/").tip("Shape for making Large Pipes");
    public static ItemBasic<?> ShapePipeHuge = new ItemBasic<>(GTCore.ID, "huge_pipe_shape", "molds/").tip("Shape for making Huge Pipes");
    public static ItemBasic<?> ShapeBlock = new ItemBasic<>(GTCore.ID, "block_shape", "molds/").tip("Shape for making Blocks");
    public static ItemBasic<?> ShapeHeadSword = new ItemBasic<>(GTCore.ID, "sword_head_shape", "molds/").tip("Shape for making Sword Blades");
    public static ItemBasic<?> ShapeHeadPickaxe = new ItemBasic<>(GTCore.ID, "pickaxe_head_shape", "molds/").tip("Shape for making Pickaxe Heads");
    public static ItemBasic<?> ShapeHeadShovel = new ItemBasic<>(GTCore.ID, "shovel_head_shape", "molds/").tip("Shape for making Shovel Heads");
    public static ItemBasic<?> ShapeHeadAxe = new ItemBasic<>(GTCore.ID, "axe_head_shape", "molds/").tip("Shape for making Axe Heads");
    public static ItemBasic<?> ShapeHeadHoe = new ItemBasic<>(GTCore.ID, "hoe_head_shape", "molds/").tip("Shape for making Hoe Heads");
    public static ItemBasic<?> ShapeHeadHammer = new ItemBasic<>(GTCore.ID, "hammer_head_shape", "molds/").tip("Shape for making Hammer Heads");
    public static ItemBasic<?> ShapeHeadFile = new ItemBasic<>(GTCore.ID, "file_head_shape", "molds/").tip("Shape for making File Heads");
    public static ItemBasic<?> ShapeHeadSaw = new ItemBasic<>(GTCore.ID, "saw_head_shape", "molds/").tip("Shape for making Saw Heads");
    public static ItemBasic<?> ShapeGear = new ItemBasic<>(GTCore.ID, "gear_shape", "molds/").tip("Shape for making Gears");
    public static ItemBasic<?> ShapeGearSmall = new ItemBasic<>(GTCore.ID, "small_gear_shape", "molds/").tip("Shape for making Small Gears");

    public static void init(){

    }
}
