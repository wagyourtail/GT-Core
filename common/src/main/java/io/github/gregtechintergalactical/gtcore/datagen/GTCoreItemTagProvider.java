package io.github.gregtechintergalactical.gtcore.datagen;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreData;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemTagProvider;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

public class GTCoreItemTagProvider extends AntimatterItemTagProvider {
    public GTCoreItemTagProvider(String providerDomain, String providerName, boolean replace, AntimatterBlockTagProvider p) {
        super(providerDomain, providerName, replace, p);
    }

    @Override
    protected void processTags(String domain) {
        super.processTags(domain);
        this.copy(TagUtils.getBlockTag(new ResourceLocation(GTCore.ID, "rubber_logs")), GTCoreData.RUBBER_LOGS);
        this.tag(ItemTags.LEAVES).add(GTCoreData.RUBBER_LEAVES.asItem());
        this.tag(ItemTags.PLANKS).add(GTCoreData.RUBBER_PLANKS.asItem());
        this.tag(ItemTags.SLABS).add(GTCoreData.RUBBER_SLAB.asItem());
        this.tag(ItemTags.STAIRS).add(GTCoreData.RUBBER_STAIRS.asItem());
        this.tag(ItemTags.SIGNS).add(GTCoreData.RUBBER_SIGN.asItem());
        this.tag(ItemTags.WOODEN_BUTTONS).add(GTCoreData.RUBBER_BUTTON.asItem());
        this.tag(ItemTags.WOODEN_DOORS).add(GTCoreData.RUBBER_DOOR.asItem());
        this.tag(ItemTags.WOODEN_FENCES).add(GTCoreData.RUBBER_FENCE.asItem());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(GTCoreData.RUBBER_PRESSURE_PLATE.asItem());
        this.tag(ItemTags.WOODEN_SLABS).add(GTCoreData.RUBBER_SLAB.asItem());
        this.tag(ItemTags.WOODEN_STAIRS).add(GTCoreData.RUBBER_STAIRS.asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(GTCoreData.RUBBER_TRAPDOOR.asItem());
        if (AntimatterAPI.isModLoaded("tfc")){
            this.tag(ItemTags.WOODEN_FENCES).add(AntimatterAPI.get(Item.class, "rubber_log_fence", GTCore.ID));
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "lumber"))).add(AntimatterAPI.get(Item.class, "rubber_lumber", GTCore.ID));
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "twigs"))).add(AntimatterAPI.get(Item.class, "rubber_twig", GTCore.ID));
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "fallen_leaves"))).add(AntimatterAPI.get(Item.class, "rubber_fallen_leaves", GTCore.ID));
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "firepit_fuel"))).addTag(GTCoreData.RUBBER_LOGS);
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "firepit_logs"))).addTag(GTCoreData.RUBBER_LOGS);
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "firepit_fuel"))).addTag(GTCoreData.RUBBER_LOGS);
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "pit_kiln_logs"))).addTag(GTCoreData.RUBBER_LOGS);
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "log_pile_logs"))).addTag(GTCoreData.RUBBER_LOGS);

        }
    }
}
