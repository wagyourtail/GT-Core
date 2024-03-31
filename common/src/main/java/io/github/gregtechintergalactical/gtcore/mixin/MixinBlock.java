package io.github.gregtechintergalactical.gtcore.mixin;

import io.github.gregtechintergalactical.gtcore.data.GTCoreTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.world.level.block.Block.getDrops;
import static net.minecraft.world.level.block.Block.popResource;

@Debug(export = true)
@Mixin(Block.class)
public class MixinBlock {

    @Inject(method = "dropResources(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/storage/loot/LootContext$Builder;)V", at = @At("HEAD"), cancellable = true)
    private static void injectDropResources(BlockState state, LootContext.Builder lootContextBuilder, CallbackInfo ci) {
        ItemStack tool = lootContextBuilder.getParameter(LootContextParams.TOOL);
        Entity entity = lootContextBuilder.getOptionalParameter(LootContextParams.THIS_ENTITY);
        if (tool.is(GTCoreTags.MAGNETIC_TOOL) && entity instanceof Player player){
            ServerLevel serverlevel = lootContextBuilder.getLevel();
            BlockPos blockpos = new BlockPos(lootContextBuilder.getParameter(LootContextParams.ORIGIN));

            state.getDrops(lootContextBuilder).forEach((arg3) -> {
                if (!player.addItem(arg3)) {
                    popResource(serverlevel, blockpos, arg3);
                }
            });
            state.spawnAfterBreak(serverlevel, blockpos, ItemStack.EMPTY);
            ci.cancel();
        }

    }

    @Inject(method = "dropResources(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/item/ItemStack;)V", at = @At("HEAD"), cancellable = true)
    private static void injectDropResources(BlockState state, Level level, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack tool, CallbackInfo ci) {
        if (level instanceof ServerLevel serverLevel && entity instanceof Player player && tool.is(GTCoreTags.MAGNETIC_TOOL)) {
            getDrops(state, serverLevel, pos, blockEntity, entity, tool).forEach((itemStack) -> {
                if (!player.addItem(itemStack)) {
                    popResource(level, pos, itemStack);
                }
            });
            state.spawnAfterBreak((ServerLevel)level, pos, tool);
            ci.cancel();
        }

    }
}
