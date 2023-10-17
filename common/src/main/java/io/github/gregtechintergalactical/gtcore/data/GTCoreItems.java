package io.github.gregtechintergalactical.gtcore.data;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.tree.item.ItemRubberBoat;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.item.ItemMultiTextureBattery;
import muramasa.antimatter.machine.Tier;

public class GTCoreItems {
    public static ItemBasic<?> StickyResin = new ItemBasic<>(GTCore.ID, "sticky_resin");
    public static ItemRubberBoat RubberBoat = new ItemRubberBoat();

    public static ItemBasic<?> CircuitBoardBasic = new ItemBasic<>(GTCore.ID, "basic_circuit_board", "circuits/");
    public static ItemBasic<?> CircuitBoardAdvanced = new ItemBasic<>(GTCore.ID, "advanced_circuit_board", "circuits/");
    public static ItemBasic<?> CircuitBoardEmpty = new ItemBasic<>(GTCore.ID, "empty_circuit_board", "circuits/");
    public static ItemBasic<?> CircuitBoardProcessor = new ItemBasic<>(GTCore.ID, "processor_circuit_board", "circuits/");
    public static ItemBasic<?> CircuitBoardProcessorEmpty = new ItemBasic<>(GTCore.ID, "empty_processor_circuit_board", "circuits/");

    public static ItemBasic<?> CircuitBasic = new ItemBasic<>(GTCore.ID, "basic_circuit", "circuits/").tip("A basic Circuit");
    public static ItemBasic<?> CircuitGood = new ItemBasic<>(GTCore.ID, "good_circuit", "circuits/").tip("A good Circuit");
    public static ItemBasic<?> CircuitAdv = new ItemBasic<>(GTCore.ID, "advanced_circuit", "circuits/").tip("An advanced Circuit");
    public static ItemBasic<?> CircuitDataStorage = new ItemBasic<>(GTCore.ID, "data_storage_circuit", "circuits/");
    public static ItemBasic<?> CircuitDataControl = new ItemBasic<>(GTCore.ID, "data_control_circuit", "circuits/");

    public static ItemBasic<?> CircuitEnergyFlow = new ItemBasic<>(GTCore.ID, "energy_flow_circuit", "circuits/").tip("A High Voltage Processor");
    public static ItemBasic<?> DataOrb = new ItemBasic<>(GTCore.ID, "data_orb", "circuits/");

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

    public static void init(){

    }
}
