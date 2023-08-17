package io.github.gregtechintergalactical.gtutility.machine;

import io.github.gregtechintergalactical.gtutility.blockentity.BlockEntityMaterial;
import io.github.gregtechintergalactical.gtutility.blockentity.BlockEntityMaterialBasicMultiMachine;
import muramasa.antimatter.Data;
import muramasa.antimatter.machine.types.BasicMultiMachine;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static muramasa.antimatter.Data.WRENCH_MATERIAL;
import static muramasa.antimatter.machine.MachineFlag.COVERABLE;

public class MaterialBasicMultiMachine extends BasicMultiMachine<MaterialBasicMultiMachine> {
    Material material;
    public MaterialBasicMultiMachine(String domain, String id, Material material) {
        super(domain, id);
        this.material = material;
        setItemBlockClass(() -> BlockMachineMaterial.class);
        setBlock(BlockMultiMachineMaterial::new);
        setTile(BlockEntityMaterialBasicMultiMachine::new);
        addFlags(COVERABLE);
        this.setGUI(Data.BASIC_MENU_HANDLER);
        noCovers();
        allowFrontIO();
    }

    public Material getMaterial() {
        return material;
    }
}
