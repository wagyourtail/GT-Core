package io.github.gregtechintergalactical.gtcore.tree.item;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.entity.RubberBoatEntity;
import muramasa.antimatter.Ref;
import muramasa.antimatter.item.ItemBasic;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class ItemRubberBoat extends ItemBasic<ItemRubberBoat> {
    private static final Predicate<Entity> RIDERS = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    public ItemRubberBoat() {
        super(GTCore.ID, "rubber_boat", new Properties().tab(Ref.TAB_ITEMS).stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);

        HitResult hitResult = Item.getPlayerPOVHitResult(world, user, ClipContext.Fluid.ANY);
        if (hitResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(stack);
        }

        Vec3 rotationVec = user.getViewVector(1f);
        List<Entity> riders = world.getEntities(user, user.getBoundingBox().expandTowards(rotationVec.scale(5d)).inflate(1d), RIDERS);

        // Prevent collision with user
        if (!riders.isEmpty()) {
            Vec3 eyePos = user.getEyePosition();
            for (Entity entity : riders) {
                AABB box = entity.getBoundingBox().inflate(entity.getPickRadius());
                if (box.contains(eyePos)) {
                    return InteractionResultHolder.pass(stack);
                }
            }
        }

        // Spawn boat entitygetTargetingMargin
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            RubberBoatEntity boatEntity = new RubberBoatEntity(world, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);


            boatEntity.setYRot(user.getYRot());

            if (!world.noCollision(boatEntity, boatEntity.getBoundingBox().inflate(-0.1d))) {
                return InteractionResultHolder.fail(stack);
            }

            if (!world.isClientSide()) {
                world.addFreshEntity(boatEntity);
                world.gameEvent(user, GameEvent.ENTITY_PLACE, new BlockPos(hitResult.getLocation()));

                if (!user.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }

            user.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResultHolder.sidedSuccess(stack, world.isClientSide());
        }

        return InteractionResultHolder.pass(stack);
    }
}
