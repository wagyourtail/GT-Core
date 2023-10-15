package io.github.gregtechintergalactical.gtcore.datagen;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreData;
import io.github.gregtechintergalactical.gtcore.machine.BlockMachineMaterial;
import io.github.gregtechintergalactical.gtcore.machine.BlockMultiMachineMaterial;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;


public class GTCoreBlockTagProvider extends AntimatterBlockTagProvider {

    public GTCoreBlockTagProvider(String providerDomain, String providerName, boolean replace) {
        super(providerDomain, providerName, replace);
    }

    @Override
    public void processTags(String domain) {
        super.processTags(domain);
        AntimatterAPI.all(BlockMachineMaterial.class, cas -> {
            this.tag(AntimatterDefaultTools.WRENCH.getToolType()).add(cas);
        });
        AntimatterAPI.all(BlockMultiMachineMaterial.class, cas -> {
            this.tag(AntimatterDefaultTools.WRENCH.getToolType()).add(cas);
        });
        /*AntimatterAPI.all(BlockMaterialChest.class, Ref.ID, cas -> {
            this.tag(AntimatterDefaultTools.WRENCH.getToolType()).add(cas);
        });
        AntimatterAPI.all(BlockNonSolidMachine.class, Ref.ID, cas -> {
            this.tag(AntimatterDefaultTools.WRENCH.getToolType()).add(cas);
        });
        AntimatterAPI.all(BlockRedstoneMachine.class, Ref.ID, cas -> {
            this.tag(AntimatterDefaultTools.WRENCH.getToolType()).add(cas);
        });*/
        this.tag(BlockTags.LEAVES).add(GTCoreData.RUBBER_LEAVES);
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(GTCoreData.RUBBER_LEAVES);
        this.tag(BlockTags.SAPLINGS).add(GTCoreData.RUBBER_SAPLING);
        this.tag(BlockTags.PLANKS).add(GTCoreData.RUBBER_PLANKS);
        this.tag(BlockTags.WOODEN_SLABS).add(GTCoreData.RUBBER_SLAB);
        this.tag(BlockTags.WOODEN_STAIRS).add(GTCoreData.RUBBER_STAIRS);
        this.tag(BlockTags.WOODEN_FENCES).add(GTCoreData.RUBBER_FENCE);
        this.tag(BlockTags.FENCE_GATES).add(GTCoreData.RUBBER_FENCE_GATE);
        this.tag(BlockTags.WOODEN_DOORS).add(GTCoreData.RUBBER_DOOR);
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(GTCoreData.RUBBER_TRAPDOOR);
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(GTCoreData.RUBBER_PRESSURE_PLATE);
        this.tag(BlockTags.WOODEN_BUTTONS).add(GTCoreData.RUBBER_BUTTON);
        this.tag(BlockTags.STANDING_SIGNS).add(GTCoreData.RUBBER_SIGN);
        this.tag(BlockTags.WALL_SIGNS).add(GTCoreData.RUBBER_WALL_SIGN);
        this.tag(TagUtils.getBlockTag(new ResourceLocation(GTCore.ID, "rubber_logs"))).add(GTCoreData.RUBBER_LOG, GTCoreData.STRIPPED_RUBBER_LOG, GTCoreData.RUBBER_WOOD, GTCoreData.STRIPPED_RUBBER_WOOD);
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(TagUtils.getBlockTag(new ResourceLocation(GTCore.ID, "rubber_logs")));
        if (AntimatterAPI.isModLoaded("tfc")){
            this.tag(BlockTags.WOODEN_FENCES).add(AntimatterAPI.get(Block.class, "rubber_log_fence", GTCore.ID));
            this.tag(TagUtils.getBlockTag(new ResourceLocation("tfc", "twigs"))).add(AntimatterAPI.get(Block.class, "rubber_twig", GTCore.ID));
            this.tag(TagUtils.getBlockTag(new ResourceLocation("tfc", "fallen_leaves"))).add(AntimatterAPI.get(Block.class, "rubber_fallen_leaves", GTCore.ID));
            this.tag(TagUtils.getBlockTag(new ResourceLocation("tfc", "mineable_with_sharp_tool"))).add(AntimatterAPI.get(Block.class, "rubber_fallen_leaves", GTCore.ID), GTCoreData.RUBBER_LEAVES);
            this.tag(TagUtils.getBlockTag(new ResourceLocation("tfc", "mineable_with_blunt_tool"))).addTag(TagUtils.getBlockTag(new ResourceLocation(GTCore.ID, "rubber_logs")));
            this.tag(TagUtils.getBlockTag(new ResourceLocation("tfc", "lit_by_dropped_torch"))).add(AntimatterAPI.get(Block.class, "rubber_fallen_leaves", GTCore.ID));
            this.tag(TagUtils.getBlockTag(new ResourceLocation("tfc", "converts_to_humus"))).add(AntimatterAPI.get(Block.class, "rubber_fallen_leaves", GTCore.ID));
            this.tag(TagUtils.getBlockTag(new ResourceLocation("tfc", "can_be_snow_piled"))).add(AntimatterAPI.get(Block.class, "rubber_twig", GTCore.ID), AntimatterAPI.get(Block.class, "rubber_fallen_leaves", GTCore.ID));
            this.tag(TagUtils.getBlockTag(new ResourceLocation("tfc", "single_block_replaceable"))).add(AntimatterAPI.get(Block.class, "rubber_twig", GTCore.ID), AntimatterAPI.get(Block.class, "rubber_fallen_leaves", GTCore.ID));
            this.tag(BlockTags.MINEABLE_WITH_AXE).add(AntimatterAPI.get(Block.class, "rubber_twig", GTCore.ID));
            this.tag(BlockTags.MINEABLE_WITH_HOE).add(AntimatterAPI.get(Block.class, "rubber_fallen_leaves", GTCore.ID));
            this.tag(TagUtils.getBlockTag(new ResourceLocation("replaceable_by_trees"))).add(AntimatterAPI.get(Block.class, "rubber_twig", GTCore.ID), AntimatterAPI.get(Block.class, "rubber_fallen_leaves", GTCore.ID));
        }
    }
}
