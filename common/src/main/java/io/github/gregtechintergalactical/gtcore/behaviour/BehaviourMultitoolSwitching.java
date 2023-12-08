package io.github.gregtechintergalactical.gtcore.behaviour;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.behaviour.IItemRightClick;
import muramasa.antimatter.tool.IAntimatterTool;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static io.github.gregtechintergalactical.gtcore.data.GTCoreTools.*;

public class BehaviourMultitoolSwitching implements IItemRightClick<IAntimatterTool> {

    public static BehaviourMultitoolSwitching INSTANCE = new BehaviourMultitoolSwitching();
    @Override
    public InteractionResultHolder<ItemStack> onRightClick(IAntimatterTool instance, Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        if (player.isShiftKeyDown() && !level.isClientSide){
            var toolType = instance.getAntimatterToolType();
            String id = getId();
            if (toolType == POCKET_MULTITOOL) id = getId() + "_knife";
            if (toolType == POCKET_MULTITOOL_KNIFE) id = getId().replace("knife", "saw");
            if (toolType == POCKET_MULTITOOL_SAW) id = getId().replace("saw", "file");
            if (toolType == POCKET_MULTITOOL_FILE) id = getId().replace("file", "screwdriver");
            if (toolType == POCKET_MULTITOOL_SCREWDRIVER) id = getId().replace("screwdriver", "wire_cutter");
            if (toolType == POCKET_MULTITOOL_WIRE_CUTTER) id = getId().replace("wire_cutter", "scissors");
            if (toolType == POCKET_MULTITOOL_SCISSORS) id = getId().replace("_scissors", "");
            Item newWrench = AntimatterAPI.get(IAntimatterTool.class, id).getItem();
            ItemStack newStack = new ItemStack(newWrench);
            newStack.setTag(stack.getTag());
            player.setItemSlot(usedHand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND, newStack);
            return InteractionResultHolder.success(newStack);
        }
        return InteractionResultHolder.pass(stack);
    }
}
