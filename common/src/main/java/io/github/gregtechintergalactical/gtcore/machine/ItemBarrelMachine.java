package io.github.gregtechintergalactical.gtcore.machine;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntityItemBarrel;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.texture.Texture;

public class ItemBarrelMachine  extends MaterialMachine{
    final int capacity;
    public ItemBarrelMachine(String domain, String id, Material material, int capacity) {
        super(domain, id, material);
        this.setTile((m, p, s) -> new BlockEntityItemBarrel(this, p, s));
        this.capacity = capacity;
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
