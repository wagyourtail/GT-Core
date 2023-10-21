package io.github.gregtechintergalactical.gtcore.machine;


import io.github.gregtechintergalactical.gtcore.blockentity.BlockEntityItemBarrel;
import muramasa.antimatter.capability.IGuiHandler;
import muramasa.antimatter.capability.item.TrackedItemHandler;
import muramasa.antimatter.capability.machine.MachineItemHandler;
import muramasa.antimatter.gui.SlotType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.BiPredicate;

public class ItemBarreltItemHandler extends MachineItemHandler<BlockEntityItemBarrel> {
    int maxSize = Integer.MAX_VALUE;
    int digitalCount;
    public ItemBarreltItemHandler(BlockEntityItemBarrel tile) {
        super(tile);
        inventories.put(SlotType.STORAGE, new QuantumSlotTrackedHandler(tile, SlotType.STORAGE, 1, SlotType.STORAGE.output, SlotType.STORAGE.input, SlotType.STORAGE.tester, ((ItemBarrelMachine)tile.getMachineType()).getCapacity()));
    }

    public static class QuantumSlotTrackedHandler extends TrackedItemHandler<BlockEntityItemBarrel> {

        public QuantumSlotTrackedHandler(BlockEntityItemBarrel tile, SlotType<?> type, int size, boolean output, boolean input, BiPredicate<IGuiHandler, ItemStack> validator, int limit) {
            super(tile, type, size, output, input, validator, limit);
        }

        @Override
        protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
            return getSlotLimit(slot);
        }

        @Override
        public CompoundTag serialize(CompoundTag nbt) {
            ListTag nbtTagList = new ListTag();
            for (int i = 0; i < stacks.size(); i++) {
                if (!stacks.get(i).isEmpty()) {
                    CompoundTag itemTag = new CompoundTag();
                    itemTag.putInt("Slot", i);
                    stacks.get(i).save(itemTag);
                    itemTag.putInt("count", stacks.get(i).getCount());
                    nbtTagList.add(itemTag);
                }
            }
            nbt.put("Items", nbtTagList);
            return nbt;
        }

        @Override
        public void deserialize(CompoundTag nbt) {
            ListTag tagList = nbt.getList("Items", Tag.TAG_COMPOUND);
            for (int i = 0; i < tagList.size(); i++) {
                CompoundTag itemTags = tagList.getCompound(i);
                int slot = itemTags.getInt("Slot");
                if (slot >= 0 && slot < stacks.size()) {
                    stacks.set(slot, ItemStack.of(itemTags));
                    stacks.get(slot).setCount(itemTags.getInt("count"));
                }
            }
            onLoad();
        }


    }

    /*public void drawInfo(MatrixStack stack, FontRenderer renderer, int left, int top) {
        // TODO: Replace by new TranslationTextComponent()
        renderer.draw(stack,"Item amount: " + digitalCount, left + 10, top + 19, 16448255);
    }*/
}
