package io.github.gregtechintergalactical.gtcore.integration.jei;

import io.github.gregtechintergalactical.gtcore.gui.ContainerWorkbench;
import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.machine.WorkbenchMachine;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import muramasa.antimatter.Antimatter;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Ref;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JeiPlugin
public class GTCoreJeiPlugin implements IModPlugin {
    public GTCoreJeiPlugin(){
        Antimatter.LOGGER.debug("GTUtilityJEIPlugin created");
    }

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(GTCore.ID, "jei_plugin");
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        if (AntimatterAPI.isModLoaded(Ref.MOD_REI)) return;
        registration.addRecipeTransferHandler(new GTUtilityRecipeTransferInfo());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        if (AntimatterAPI.isModLoaded(Ref.MOD_REI)) return;
        /*AntimatterAPI.all(WorkbenchMachine.class).forEach(m -> {
            m.getTiers().forEach(t -> {
                registration.addRecipeCatalyst(new ItemStack(m.getItem(t)), RecipeTypes.CRAFTING);
            });
        });*/
        Optional<WorkbenchMachine> machine = AntimatterAPI.all(WorkbenchMachine.class).stream().findFirst();
        if (machine.isPresent()){
            registration.addRecipeCatalyst(new ItemStack(machine.get().getItem(machine.get().getFirstTier())), RecipeTypes.CRAFTING);
        }
    }

    public static class GTUtilityRecipeTransferInfo implements IRecipeTransferInfo<ContainerWorkbench, CraftingRecipe>{
        @Override
        public Class<ContainerWorkbench> getContainerClass() {
            return ContainerWorkbench.class;
        }

        @Override
        public RecipeType<CraftingRecipe> getRecipeType() {
            return RecipeTypes.CRAFTING;
        }

        @Override
        public boolean canHandle(ContainerWorkbench containerWorkbench, CraftingRecipe recipe) {
            return true;
        }

        @Override
        public List<Slot> getRecipeSlots(ContainerWorkbench containerWorkbench, CraftingRecipe recipe) {
            List<Slot> slots = new ArrayList<>();
            for (int i = 17; i < 26; i++) {
                slots.add(containerWorkbench.getSlot(i));
            }
            return slots;
        }

        @Override
        public List<Slot> getInventorySlots(ContainerWorkbench containerWorkbench, CraftingRecipe recipe) {
            List<Slot> slots = new ArrayList<>();
            for (int i = 1; i < 17; i++) {
                slots.add(containerWorkbench.getSlot(i));
            }
            for (int i = 26; i < 68; i++) {
                slots.add(containerWorkbench.getSlot(i));
            }
            return slots;
        }

        @Override
        public Class<CraftingRecipe> getRecipeClass() {
            return CraftingRecipe.class;
        }

        @Override
        public ResourceLocation getRecipeCategoryUid() {
            return VanillaRecipeCategoryUid.CRAFTING;
        }
    }
}
