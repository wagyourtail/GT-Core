package io.github.gregtechintergalactical.gtcore.blockentity;

import io.github.gregtechintergalactical.gtcore.gui.ContainerWorkbench;
import io.github.gregtechintergalactical.gtcore.machine.MaterialMachine;
import muramasa.antimatter.capability.machine.MachineCoverHandler;
import muramasa.antimatter.cover.ICover;
import muramasa.antimatter.gui.event.GuiEvents;
import muramasa.antimatter.gui.event.IGuiEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import tesseract.api.item.ExtendedItemContainer;

import javax.annotation.Nonnull;

public class BlockEntityWorkbench extends BlockEntityMaterial<BlockEntityWorkbench>{
    public BlockEntityWorkbench(MaterialMachine type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public ResourceLocation getGuiTexture() {
        return super.getGuiTexture();
    }

    @Override
    public void onGuiEvent(IGuiEvent event, Player playerEntity) {
        super.onGuiEvent(event, playerEntity);
        if (event.getFactory() == GuiEvents.EXTRA_BUTTON && !openContainers.isEmpty()){
            final int[] data = ((GuiEvents.GuiEvent)event).data;
            if (data[1] == 0){
                openContainers.forEach(o -> {
                    if (playerEntity.getUUID().compareTo(o.getPlayerInv().player.getUUID()) == 0){
                        ((ContainerWorkbench<?>)o).clearCraftingGrid();
                    }
                });
            } else if (data[1] == 1){
                openContainers.forEach(o -> {
                    if (playerEntity.getUUID().compareTo(o.getPlayerInv().player.getUUID()) == 0){
                        ((ContainerWorkbench<?>)o).clearCraftingGridToPlayer();
                    }
                });
            }
        }
    }

    @Override
    public <V> boolean blocksCapability(@Nonnull Class<V> cap, Direction side) {
        return super.blocksCapability(cap, side) || cap == ExtendedItemContainer.class;
    }
}
