package io.github.gregtechintergalactical.gtcore.machine;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntityMassStorage;
import io.github.gregtechintergalactical.gtcore.item.ItemBlockMassStorage;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.machine.MachineState;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.texture.Texture;

public class MassStorageMachine extends MaterialMachine{
    final int capacity;
    public MassStorageMachine(String domain, Material material, String suffix, int capacity) {
        super(domain, material.getId() + "_" + suffix, material);
        this.setTiers(Tier.NONE);
        this.setTile((m, p, s) -> new BlockEntityMassStorage(this, p, s));
        this.setItemBlock(ItemBlockMassStorage::new);
        this.capacity = capacity;
        tesr();
        String barrel = material.getId().contains("wood") ? "item_storage" : "mass_storage";
        baseTexture((m, t, s) -> new Texture[] {
                new Texture(GTCore.ID, "block/machine/base/" + barrel + "/bottom"),
                new Texture(GTCore.ID, "block/machine/base/" + barrel + "/top"),
                new Texture(GTCore.ID, "block/machine/base/" + barrel + "/side"),
                new Texture(GTCore.ID, "block/machine/base/" + barrel + "/side"),
                new Texture(GTCore.ID, "block/machine/base/" + barrel + "/side"),
                new Texture(GTCore.ID, "block/machine/base/" + barrel + "/side"),
        });
        overlayTexture((m, s, t, i) -> {
            s = s.getTextureState();
            String stateDir = s == MachineState.IDLE ? "" : s.getId() + "/";
            return new Texture[]{
                    new Texture(domain, "block/machine/overlay/" + barrel + "/" + stateDir + "bottom"),
                    new Texture(domain, "block/machine/overlay/" + barrel + "/" + stateDir + "top"),
                    new Texture(domain, "block/machine/overlay/" + barrel + "/" + stateDir + "back"),
                    new Texture(domain, "block/machine/overlay/" + barrel + "/" + stateDir + "front"),
                    new Texture(domain, "block/machine/overlay/" + barrel + "/" + stateDir + "side"),
                    new Texture(domain, "block/machine/overlay/" + barrel + "/" + stateDir + "side")
            };
        });
        AntimatterAPI.register(MassStorageMachine.class, this);
    }

    public int getCapacity() {
        return capacity;
    }
}
