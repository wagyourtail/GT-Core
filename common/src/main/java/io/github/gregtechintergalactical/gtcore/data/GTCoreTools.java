package io.github.gregtechintergalactical.gtcore.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Ref;
import muramasa.antimatter.tool.AntimatterItemTier;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.IAntimatterTool;
import muramasa.antimatter.tool.MaterialTool;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

import static muramasa.antimatter.data.AntimatterDefaultTools.*;
import static muramasa.antimatter.data.AntimatterMaterialTypes.*;
import static net.minecraft.world.level.material.Material.*;
import static net.minecraft.world.level.material.Material.LEAVES;

public class GTCoreTools {
    private static final AntimatterToolType.IToolSupplier POWERED_TOOL_SUPPLIER = new AntimatterToolType.IToolSupplier() {
        @Override
        public IAntimatterTool create(String domain, AntimatterToolType toolType, AntimatterItemTier tier, Item.Properties properties) {
            return null;
        }

        @Override
        public IAntimatterTool create(String domain, AntimatterToolType toolType, AntimatterItemTier tier, Item.Properties properties, int energyTier) {
            return new PoweredTool(domain, toolType, tier, properties, energyTier);
        }
    };
    public static final AntimatterToolType DRILL = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(Ref.ID, "drill", 2, 2, 10, 3.0F, -3.0F, false)).setToolSupplier(POWERED_TOOL_SUPPLIER).setType(PICKAXE).setUseAction(UseAnim.BLOCK).setPowered(100000, 1, 2, 3).setMaterialType(DRILLBIT).setUseSound(Ref.DRILL).addTags("pickaxe", "shovel").addEffectiveMaterials(ICE_SOLID, PISTON, DIRT, CLAY, GRASS, SAND).setRepairability(false);
    public static final AntimatterToolType BUZZSAW = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(Ref.ID, "buzzsaw", 2, 2, 2, 0.5F, -2.7F, false)).setToolSupplier(POWERED_TOOL_SUPPLIER).setTag(SAW).setPowered(100000, 1, 2, 3).setOverlayLayers(2).addTags("saw").setMaterialType(SAW_HEAD);
    public static final AntimatterToolType ELECTRIC_SCREWDRIVER = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(Ref.ID, "electric_screwdriver", SCREWDRIVER)).setTag(SCREWDRIVER).setPowered(100000, 1, 2, 3).setToolSupplier(POWERED_TOOL_SUPPLIER).setUseSound(Ref.WRENCH).setOverlayLayers(2);
    public static final AntimatterToolType CHAINSAW = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(Ref.ID, "chainsaw", 2, 1, 5, 3.0F, -2.0F, false)).setToolSupplier(POWERED_TOOL_SUPPLIER).setUseAction(UseAnim.BLOCK).setPowered(100000, 1, 2, 3).setMaterialType(CHAINSAWBIT).addEffectiveMaterials(WOOD, PLANT, REPLACEABLE_PLANT, BAMBOO, LEAVES).addTags("axe", "saw");

    public static final AntimatterToolType JACKHAMMER = AntimatterAPI.register(AntimatterToolType.class, new AntimatterToolType(Ref.ID, "jackhammer", 2, 2, 10, 1.0F, -3.2F, false)).setToolSupplier(POWERED_TOOL_SUPPLIER).setPowered(100000, 1, 2, 3).setToolSpeedMultiplier(12.0f).setUseSound(Ref.DRILL).addEffectiveMaterials(STONE).setOverlayLayers(2);

    public static class PoweredTool extends MaterialTool {

        public PoweredTool(String domain, AntimatterToolType type, AntimatterItemTier tier, Properties properties, int energyTier) {
            super(domain, type, tier, properties, energyTier);
        }

        @Override
        public int getItemColor(ItemStack stack, @Nullable Block block, int i) {
            if (i == 1){
                if (energyTier == 1) return GTCoreMaterials.Aluminium.getRGB();
                if (energyTier == 2) return GTCoreMaterials.StainlessSteel.getRGB();
                if (energyTier == 3) return GTCoreMaterials.Titanium.getRGB();
            }
            return super.getItemColor(stack, block, i);
        }
    }

    public static void init(){

    }

}
