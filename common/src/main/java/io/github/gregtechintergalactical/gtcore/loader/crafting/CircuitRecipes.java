package io.github.gregtechintergalactical.gtcore.loader.crafting;

import io.github.gregtechintergalactical.gtcore.GTCore;
import muramasa.antimatter.data.AntimatterMaterialTypes;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.pipe.PipeSize;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

import static com.google.common.collect.ImmutableMap.of;
import static io.github.gregtechintergalactical.gtcore.data.GTCoreItems.CircuitBasic;
import static io.github.gregtechintergalactical.gtcore.data.GTCoreItems.VacuumTube;

public class CircuitRecipes {
    public static boolean harderCircuits = true;
    public static boolean goodCircuit = true; //has no effect with harder circuits
    public static boolean useSolderingAlloy = false;
    public static boolean advancedCircuitCraftingTableRecipe = true;
    public static boolean complexCircuitAndHigherCraftingTableRecipe = true;
    public static void initRecipes(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider){
        if (harderCircuits){ // make the condition the harder circuits config
            //provider.addStackRecipe(output, GTCore.ID, "circuit_basic_v", "parts", new ItemStack(CircuitBasic, 1), of('C', VacuumTube, 'R', VacuumTube, 'I', VacuumTube), "CRC", "CIC", "CRC");
        } else {

            if (goodCircuit){ // make the condition the good circuits config

            }
        }
    }
}
