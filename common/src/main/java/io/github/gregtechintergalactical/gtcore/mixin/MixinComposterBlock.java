package io.github.gregtechintergalactical.gtcore.mixin;

import io.github.gregtechintergalactical.gtcore.GTCoreConfig;
import io.github.gregtechintergalactical.gtcore.data.GTCoreItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ComposterBlock.class)
public class MixinComposterBlock {

    @ModifyArg(method = "extractProduce", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;<init>(Lnet/minecraft/world/level/ItemLike;)V"))
    private static ItemLike modifyResult(ItemLike item){
        if (GTCoreConfig.COMPOSTER_OUTPUT_RePLACEMENT.get()){
            return GTCoreItems.Fertilizer;
        }
        return item;
    }
}
