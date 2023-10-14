package io.github.gregtechintergalactical.gtcore.datagen;

import io.github.gregtechintergalactical.gtcore.machine.BlockMachineMaterial;
import io.github.gregtechintergalactical.gtcore.machine.BlockMultiMachineMaterial;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockLootProvider;


public class GTCoreBlockLootProvider extends AntimatterBlockLootProvider {
    public GTCoreBlockLootProvider(String providerDomain, String providerName) {
        super(providerDomain, providerName);
    }

    @Override
    protected void loot() {
        super.loot();
        AntimatterAPI.all(BlockMachineMaterial.class, this::add);
        AntimatterAPI.all(BlockMultiMachineMaterial.class, this::add);
    }
}
