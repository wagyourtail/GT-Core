package io.github.gregtechintergalactical.gtcore.data;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import dev.architectury.injectables.annotations.ExpectPlatform;
import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.block.BlockSapBag;
import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntitySapBag;
import io.github.gregtechintergalactical.gtcore.machine.DrumMachine;
import io.github.gregtechintergalactical.gtcore.machine.LockerMachine;
import io.github.gregtechintergalactical.gtcore.machine.WorkbenchMachine;
import io.github.gregtechintergalactical.gtcore.tree.block.*;
import io.github.gregtechintergalactical.gtcore.tree.item.ItemRubberBoat;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.block.BlockBasic;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.texture.Texture;
import muramasa.antimatter.util.AntimatterPlatformUtils;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

import static muramasa.antimatter.material.TextureSet.SHINY;

public class GTCoreData {

    public static final TagKey<Item> RUBBER_LOGS = TagUtils.getItemTag(new ResourceLocation(GTCore.ID, "rubber_logs"));

    public static Material RUBBER = AntimatterAPI.register(Material.class, new Material(GTCore.ID, "rubber", 0x000000, SHINY));

    public static WoodType RUBBER_WOOD_TYPE = new WoodType("rubber"){};



    public static Block RUBBER_LEAVES;
    public static final BlockRubberLog RUBBER_LOG = new BlockRubberLog(GTCore.ID, "rubber_log");
    public static final BlockRubberLog STRIPPED_RUBBER_LOG = new BlockRubberLog(GTCore.ID, "stripped_rubber_log");
    public static final BlockRubberWood RUBBER_WOOD = new BlockRubberWood(GTCore.ID, "rubber_wood");
    public static final BlockRubberWood STRIPPED_RUBBER_WOOD = new BlockRubberWood(GTCore.ID, "stripped_rubber_wood");
    public static final BlockBasic RUBBER_PLANKS = new BlockBasic(GTCore.ID, "rubber_planks", BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.WOOD).strength(2.0F).sound(SoundType.WOOD)){
        @Override
        public Texture[] getTextures() {
            return new Texture[]{new Texture(domain, "block/tree/rubber_planks")};
        }
    };

    public static final BlockRubberSign RUBBER_SIGN = new BlockRubberSign();
    public static final BlockRubberWallSign RUBBER_WALL_SIGN = new BlockRubberWallSign();
    public static Block RUBBER_SAPLING;
    public static final BlockRubberButton RUBBER_BUTTON = new BlockRubberButton();
    public static final BlockRubberPressurePlate RUBBER_PRESSURE_PLATE = new BlockRubberPressurePlate();
    public static final BlockRubberDoor RUBBER_DOOR = new BlockRubberDoor();
    public static final BlockRubberTrapDoor RUBBER_TRAPDOOR = new BlockRubberTrapDoor();

    public static final BlockRubberSlab RUBBER_SLAB = new BlockRubberSlab();
    public static final BlockRubberStairs RUBBER_STAIRS = new BlockRubberStairs();

    public static final BlockRubberFence RUBBER_FENCE = new BlockRubberFence();
    public static final BlockRubberFenceGate RUBBER_FENCE_GATE = new BlockRubberFenceGate();

    public static final BlockSapBag SAP_BAG = new BlockSapBag();


    public static final BlockEntityType<?> SAP_BAG_BLOCK_ENTITY = BlockEntityType.Builder.of(BlockEntitySapBag::new, SAP_BAG).build(null);
    public static ItemBasic<?> StickyResin = new ItemBasic<>(GTCore.ID, "sticky_resin");

    public static ItemRubberBoat RubberBoat = new ItemRubberBoat();

    public static void init() {
        if (!AntimatterAPI.isModLoaded("tfc")){
            RUBBER_LEAVES = new BlockRubberLeaves();
            RUBBER_SAPLING = new BlockRubberSapling();
        } else if (AntimatterPlatformUtils.isForge()){
            initTFC();
        }
        AntimatterAPI.register(BlockEntityType.class, "sap_bag", GTCore.ID, SAP_BAG_BLOCK_ENTITY);
    }

    @ExpectPlatform
    private static void initTFC(){
        throw new AssertionError();
    }

    public static DrumMachine createDrum(Material material, int maxCapacity){
        DrumMachine machine = AntimatterAPI.get(DrumMachine.class, material.getId() + "_drum", GTCore.ID);
        if (machine != null){
            return machine;
        }
        return new DrumMachine(GTCore.ID, material, maxCapacity);
    }

    public static WorkbenchMachine createWorkbench(Material material, boolean charge){
        WorkbenchMachine machine = AntimatterAPI.get(WorkbenchMachine.class, material.getId() + (charge ? "_charging" : "") + "_workbench", GTCore.ID);
        if (machine != null){
            return machine;
        }
        return new WorkbenchMachine(GTCore.ID, material, charge);
    }

    public static LockerMachine createLocker(Material material, boolean charge){
        LockerMachine machine = AntimatterAPI.get(LockerMachine.class, material.getId() + (charge ? "_charging" : "") + "_locker", GTCore.ID);
        if (machine != null){
            return machine;
        }
        return new LockerMachine(GTCore.ID, material, charge);
    }
}
