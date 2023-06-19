package io.github.gregtechintergalactical.gtutility.datagen;

import io.github.gregtechintergalactical.gtutility.GTUtility;
import io.github.gregtechintergalactical.gtutility.machine.BlockMachineMaterial;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Ref;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.data.AntimatterStoneTypes;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;


public class GTUtilityBlockTagProvider extends AntimatterBlockTagProvider {

    public GTUtilityBlockTagProvider(String providerDomain, String providerName, boolean replace) {
        super(providerDomain, providerName, replace);
    }

    @Override
    public void processTags(String domain) {
        super.processTags(domain);
        AntimatterAPI.all(BlockMachineMaterial.class, GTUtility.ID, cas -> {
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
    }
}
