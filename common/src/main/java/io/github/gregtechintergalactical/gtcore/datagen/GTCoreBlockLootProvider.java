package io.github.gregtechintergalactical.gtcore.datagen;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreData;
import io.github.gregtechintergalactical.gtcore.machine.BlockMachineMaterial;
import io.github.gregtechintergalactical.gtcore.machine.BlockMultiMachineMaterial;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockLootProvider;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;


public class GTCoreBlockLootProvider extends AntimatterBlockLootProvider {
    public GTCoreBlockLootProvider(String providerDomain, String providerName) {
        super(providerDomain, providerName);
    }

    @Override
    protected void loot() {
        super.loot();
        AntimatterAPI.all(BlockMachineMaterial.class, this::add);
        AntimatterAPI.all(BlockMultiMachineMaterial.class, this::add);
        tables.put(GTCoreData.RUBBER_LEAVES, b -> createLeavesDrops(GTCoreData.RUBBER_LEAVES, GTCoreData.RUBBER_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
        this.add(GTCoreData.RUBBER_LOG);
        this.add(GTCoreData.RUBBER_SAPLING);
        this.add(GTCoreData.STRIPPED_RUBBER_LOG);
        this.add(GTCoreData.RUBBER_WOOD);
        this.add(GTCoreData.STRIPPED_RUBBER_WOOD);
        this.add(GTCoreData.RUBBER_PLANKS);
        this.add(GTCoreData.RUBBER_FENCE);
        this.add(GTCoreData.RUBBER_FENCE_GATE);
        this.add(GTCoreData.RUBBER_PRESSURE_PLATE);
        this.add(GTCoreData.RUBBER_BUTTON);
        this.add(GTCoreData.RUBBER_STAIRS);
        tables.put(GTCoreData.RUBBER_SLAB, BlockLoot::createSlabItemTable);
        tables.put(GTCoreData.RUBBER_DOOR, BlockLoot::createDoorTable);
        this.add(GTCoreData.RUBBER_TRAPDOOR);
        tables.put(GTCoreData.RUBBER_SIGN, b -> BlockLoot.createSingleItemTable(GTCoreData.RUBBER_SIGN.asItem()));
        tables.put(GTCoreData.RUBBER_WALL_SIGN, b -> BlockLoot.createSingleItemTable(GTCoreData.RUBBER_SIGN.asItem()));
        this.add(GTCoreData.SAP_BAG);
        if (AntimatterAPI.isModLoaded("tfc")) {
            this.add(AntimatterAPI.get(Block.class, "rubber_twig", GTCore.ID));
            this.add(AntimatterAPI.get(Block.class, "rubber_fallen_leaves", GTCore.ID));
        }
    }
}
