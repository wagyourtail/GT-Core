package io.github.gregtechintergalactical.gtutility;

import io.github.gregtechintergalactical.gtutility.machine.DrumMachine;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Ref;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.data.AntimatterMaterialTypes;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.material.Material;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.machine.Tier.LV;

public class GTUtilityRecipes {
    public static void initRecipes(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider){
        AntimatterAPI.all(DrumMachine.class).forEach(d -> {
            Material m = d.getMaterial();
            if (m.has(AntimatterMaterialTypes.PLATE) && m.has(AntimatterMaterialTypes.ROD)){
                provider.addItemRecipe(output, GTUtility.ID, "", "machines", "has_hammer", provider.hasSafeItem(AntimatterDefaultTools.HAMMER.getTag()), d.getItem(Tier.NONE), of('H', AntimatterDefaultTools.HAMMER.getTag(), 'R', AntimatterMaterialTypes.ROD.getMaterialTag(m), 'P', AntimatterMaterialTypes.PLATE.getMaterialTag(m)), " H ", "PRP", "PRP");
            }
        });
    }
}
