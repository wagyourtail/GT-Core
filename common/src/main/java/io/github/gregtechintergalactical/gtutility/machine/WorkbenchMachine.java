package io.github.gregtechintergalactical.gtutility.machine;

import io.github.gregtechintergalactical.gtutility.GTUtility;
import io.github.gregtechintergalactical.gtutility.blockentity.BlockEntityWorkbench;
import io.github.gregtechintergalactical.gtutility.data.MenuHandlers;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Ref;
import muramasa.antimatter.machine.MachineFlag;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.texture.Texture;
import net.minecraft.resources.ResourceLocation;

import static io.github.gregtechintergalactical.gtutility.data.SlotTypes.*;
import static muramasa.antimatter.gui.ButtonBody.NO_OVERLAY;
import static muramasa.antimatter.gui.SlotType.STORAGE;
import static muramasa.antimatter.machine.MachineFlag.*;

public class WorkbenchMachine extends MaterialMachine{
    public WorkbenchMachine(String domain, Material material, boolean charge) {
        super(domain, material.getId() + (charge ? "_charging" : "") + "_workbench", material);
        setGUI(MenuHandlers.WORKBENCH_HANDLER);
        this.addFlags(ITEM, GUI);
        if (charge) this.addFlags(ENERGY);
        this.setTiers(charge ? Tier.HV : Tier.NONE);
        this.setTile(BlockEntityWorkbench::new);
        for (int y = 0; y < 4; y++){
            for (int x = 0; x < 4; x++){
                this.add(STORAGE, 8 + (x * 18), 8 + (y * 18));
            }
        }
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 3; x++){
                this.add(CRAFTING, 82 + (x * 18), 28 + (y * 18));
            }
        }
        for (int x = 0; x < 5; x++){
            this.add(charge ? TOOL_CHARGE : TOOLS, 82 + (x * 18), 8);
        }
        this.add(PARK, 154, 46);
        this.addGuiCallback(t -> {
            t.addButton(136, 28, 16, 16, NO_OVERLAY);
            t.addButton(154, 28, 16, 16, NO_OVERLAY);
        });
        this.getGui().setOverrideLocation(new ResourceLocation(GTUtility.ID, "textures/gui/machine/" + (charge ? "charging_" : "") + "workbench.png"));
        this.baseTexture((m, t) -> new Texture[] {
                new Texture(GTUtility.ID, "block/machine/base/workbench/bottom"),
                new Texture(GTUtility.ID, "block/machine/base/workbench/top"),
                new Texture(GTUtility.ID, "block/machine/base/workbench/back"),
                new Texture(GTUtility.ID, "block/machine/base/workbench/front"),
                new Texture(GTUtility.ID, "block/machine/base/workbench/side"),
                new Texture(GTUtility.ID, "block/machine/base/workbench/side"),
        });
        this.overlayTexture((type, state, tier) -> new Texture[] {
                new Texture(GTUtility.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + "workbench/bottom"),
                new Texture(GTUtility.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + "workbench/top"),
                new Texture(GTUtility.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + "workbench/back"),
                new Texture(GTUtility.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + "workbench/front"),
                new Texture(GTUtility.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + "workbench/side"),
                new Texture(GTUtility.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + "workbench/side"),
        });
        AntimatterAPI.register(WorkbenchMachine.class, this);
    }
}
