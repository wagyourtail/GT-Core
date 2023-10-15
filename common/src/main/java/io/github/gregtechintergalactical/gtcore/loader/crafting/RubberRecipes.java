package io.github.gregtechintergalactical.gtcore.loader.crafting;

import com.google.common.collect.ImmutableMap;
import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreData;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.ForgeCTags;
import muramasa.antimatter.datagen.builder.AntimatterCookingRecipeBuilder;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.event.CraftingEvent;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.google.common.collect.ImmutableMap.of;
import static io.github.gregtechintergalactical.gtcore.data.GTCoreData.SAP_BAG;
import static muramasa.antimatter.data.AntimatterDefaultTools.SAW;
import static muramasa.antimatter.data.AntimatterMaterialTypes.DUST;

public class RubberRecipes {

    public static void addRecipes(Consumer<FinishedRecipe> consumer, AntimatterRecipeProvider provider){
        if (!AntimatterAPI.isModLoaded("gti") && !AntimatterAPI.isModLoaded("gt4r")) {
            AntimatterCookingRecipeBuilder.smeltingRecipe(Ingredient.of(GTCoreData.StickyResin), DUST.get(GTCoreData.RUBBER, 1), 0.1f, 200).addCriterion("has_resin", provider.hasSafeItem(GTCoreData.StickyResin)).build(consumer, "resin_to_rubber");
        }
        Item lumber = AntimatterAPI.isModLoaded("tfc") ? AntimatterAPI.get(Item.class, "rubber_lumber", GTCore.ID) : GTCoreData.RUBBER_PLANKS.asItem();
        if (!AntimatterAPI.isModLoaded("gt4r") && !AntimatterAPI.isModLoaded("tfc")){
            provider.shapeless(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_logs", provider.hasSafeItem(GTCoreData.RUBBER_LOGS), new ItemStack(GTCoreData.RUBBER_PLANKS, 4), GTCoreData.RUBBER_LOGS);
        } else if (AntimatterAPI.isModLoaded("tfc")){
            provider.shapeless(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_logs", provider.hasSafeItem(GTCoreData.RUBBER_LOGS), new ItemStack(lumber, 8), GTCoreData.RUBBER_LOGS, TagUtils.getItemTag(new ResourceLocation("tfc", "saws")));
            provider.addItemRecipe(consumer, "rubber_wood", "has_rubber_lumber", provider.hasSafeItem(lumber), GTCoreData.RUBBER_PLANKS, of('R', lumber), "RR", "RR");
            provider.shapeless(consumer, GTCore.ID, "rubber_lumber_from_planks", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_PLANKS), new ItemStack(lumber, 4), GTCoreData.RUBBER_PLANKS, TagUtils.getItemTag(new ResourceLocation("tfc", "saws")));
            provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_log", provider.hasSafeItem(GTCoreData.RUBBER_LOG), new ItemStack(AntimatterAPI.get(Item.class, "rubber_log_fence", GTCore.ID), 8), of('R', GTCoreData.RUBBER_LOG, 'L', lumber), "RLR", "RLR");
        }
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_log", provider.hasSafeItem(GTCoreData.RUBBER_LOG), new ItemStack(GTCoreData.RUBBER_WOOD, 3), ImmutableMap.of('R', GTCoreData.RUBBER_LOG), "RR", "RR");
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_stripped_rubber_log", provider.hasSafeItem(GTCoreData.STRIPPED_RUBBER_LOG), new ItemStack(GTCoreData.STRIPPED_RUBBER_WOOD, 3), ImmutableMap.of('R', GTCoreData.STRIPPED_RUBBER_LOG), "RR", "RR");
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_WOOD), new ItemStack(GTCoreData.RUBBER_SIGN, 3), ImmutableMap.of('R', lumber, 'S', TagUtils.getForgelikeItemTag("rods/wooden")), "RRR", "RRR", " S ");
        int fenceAmount = AntimatterAPI.isModLoaded("tfc") ? 8 : 3, fenceGateAmount = AntimatterAPI.isModLoaded("tfc") ? 2 : 1;
        Object stick = AntimatterAPI.isModLoaded("tfc") ? lumber : TagUtils.getForgelikeItemTag("rods/wooden");
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_WOOD), new ItemStack(GTCoreData.RUBBER_FENCE, fenceAmount), ImmutableMap.of('R', GTCoreData.RUBBER_PLANKS, 'S', stick), "RSR", "RSR");
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_WOOD), new ItemStack(GTCoreData.RUBBER_FENCE_GATE, fenceGateAmount), ImmutableMap.of('R', GTCoreData.RUBBER_PLANKS, 'S', stick), "SRS", "SRS");
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_WOOD), new ItemStack(GTCoreData.RUBBER_PRESSURE_PLATE, 1), ImmutableMap.of('R', lumber), "RR");
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_WOOD), new ItemStack(GTCoreData.RUBBER_SLAB, 6), ImmutableMap.of('R', GTCoreData.RUBBER_PLANKS), "RRR");
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_WOOD), new ItemStack(GTCoreData.RUBBER_STAIRS, 4), ImmutableMap.of('R', GTCoreData.RUBBER_PLANKS), "R  ", "RR ", "RRR");
        int doorAmount = AntimatterAPI.isModLoaded("tfc") ? 2 : 3, trapdoorAmount = AntimatterAPI.isModLoaded("tfc") ? 3 : 2;
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_WOOD), new ItemStack(GTCoreData.RUBBER_DOOR, doorAmount), ImmutableMap.of('R', lumber), "RR", "RR", "RR");
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_WOOD), new ItemStack(GTCoreData.RUBBER_TRAPDOOR, trapdoorAmount), ImmutableMap.of('R', lumber), "RRR", "RRR");
        provider.addStackRecipe(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_WOOD), new ItemStack(GTCoreData.RubberBoat), ImmutableMap.of('R', GTCoreData.RUBBER_PLANKS), "R R", "RRR");
        provider.shapeless(consumer, GTCore.ID, "", "rubber_wood", "has_rubber_planks", provider.hasSafeItem(GTCoreData.RUBBER_PLANKS), new ItemStack(GTCoreData.RUBBER_BUTTON), GTCoreData.RUBBER_PLANKS);
        provider.addStackRecipe(consumer, GTCore.ID, "sapbag", "blocks", "has_saw", provider.hasSafeItem(SAW.getTag()),
                new ItemStack(SAP_BAG), of('L', ForgeCTags.LEATHER, 'S', SAW.getTag(), 's', Items.STICK), "sss", "LSL", "LLL");
        provider.addStackRecipe(consumer, GTCore.ID, "torch", "torches", "has_sticky_resin", provider.hasSafeItem(GTCoreData.StickyResin), new ItemStack(Items.TORCH, 4), of('S', GTCoreData.StickyResin, 'R', Items.STICK), "S", "R");
    }

}
