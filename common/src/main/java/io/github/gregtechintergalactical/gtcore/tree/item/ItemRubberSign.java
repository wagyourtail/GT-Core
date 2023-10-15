package io.github.gregtechintergalactical.gtcore.tree.item;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreBlocks;
import muramasa.antimatter.registration.IAntimatterObject;
import muramasa.antimatter.registration.IModelProvider;
import muramasa.antimatter.registration.ITextureProvider;
import muramasa.antimatter.texture.Texture;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.SignItem;

public class ItemRubberSign extends SignItem implements IAntimatterObject, ITextureProvider, IModelProvider {
    public ItemRubberSign() {
        super(new Properties().stacksTo(16).tab(CreativeModeTab.TAB_DECORATIONS), GTCoreBlocks.RUBBER_SIGN, GTCoreBlocks.RUBBER_WALL_SIGN);
    }

    @Override
    public String getDomain() {
        return GTCore.ID;
    }

    @Override
    public String getId() {
        return "rubber_sign";
    }

    @Override
    public Texture[] getTextures() {
        return new Texture[]{new Texture(GTCore.ID, "item/basic/rubber_sign")};
    }
}
