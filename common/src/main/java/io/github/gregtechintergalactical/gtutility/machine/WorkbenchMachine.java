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

public class WorkbenchMachine extends ChargingMachine{
    public WorkbenchMachine(String domain, Material material, boolean charge) {
        super(domain, material, "workbench", charge);
        setGUI(MenuHandlers.WORKBENCH_HANDLER);
        this.addFlags(ITEM, GUI);
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
        AntimatterAPI.register(WorkbenchMachine.class, this);
    }
}
