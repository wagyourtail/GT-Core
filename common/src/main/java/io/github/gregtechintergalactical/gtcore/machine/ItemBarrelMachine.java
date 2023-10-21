package io.github.gregtechintergalactical.gtcore.machine;

import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntityItemBarrel;
import muramasa.antimatter.material.Material;

public class ItemBarrelMachine  extends MaterialMachine{
    final int capacity;
    public ItemBarrelMachine(String domain, String id, Material material, int capacity) {
        super(domain, id, material);
        this.setTile((m, p, s) -> new BlockEntityItemBarrel(this, p, s));
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
