package io.github.gregtechintergalactical.gtcore.machine;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntityMassStorage;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.texture.Texture;

public class MassStorageMachine extends MaterialMachine{
    final int capacity;
    public MassStorageMachine(String domain, Material material, String suffix, int capacity) {
        super(domain, material.getId() + "_" + suffix, material);
        this.setTiers(Tier.NONE);
        this.setTile((m, p, s) -> new BlockEntityMassStorage(this, p, s));
        this.capacity = capacity;
        tesr();
        baseTexture((m, t) -> new Texture[] {
                new Texture(GTCore.ID, "block/machine/base/item_barrel/bottom"),
                new Texture(GTCore.ID, "block/machine/base/item_barrel/top"),
                new Texture(GTCore.ID, "block/machine/base/item_barrel/side"),
                new Texture(GTCore.ID, "block/machine/base/item_barrel/side"),
                new Texture(GTCore.ID, "block/machine/base/item_barrel/side"),
                new Texture(GTCore.ID, "block/machine/base/item_barrel/side"),
        });
    }

    public int getCapacity() {
        return capacity;
    }
}
