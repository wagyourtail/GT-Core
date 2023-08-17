package io.github.gregtechintergalactical.gtutility.datagen;

import io.github.gregtechintergalactical.gtutility.machine.BlockMachineMaterial;
import io.github.gregtechintergalactical.gtutility.machine.BlockMultiMachineMaterial;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterMaterialTypes;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.data.AntimatterStoneTypes;
import muramasa.antimatter.datagen.providers.AntimatterBlockLootProvider;
import muramasa.antimatter.material.MaterialTags;
import muramasa.antimatter.mixin.BlockLootTablesAccessor;
import muramasa.antimatter.ore.BlockOre;
import muramasa.antimatter.ore.BlockOreStone;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.Function;


public class GTUtilityBlockLootProvider extends AntimatterBlockLootProvider {
    public GTUtilityBlockLootProvider(String providerDomain, String providerName) {
        super(providerDomain, providerName);
    }

    @Override
    protected void loot() {
        super.loot();
        AntimatterAPI.all(BlockMachineMaterial.class, this::add);
        AntimatterAPI.all(BlockMultiMachineMaterial.class, this::add);
    }
}
