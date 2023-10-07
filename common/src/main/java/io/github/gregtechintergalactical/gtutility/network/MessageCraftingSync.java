package io.github.gregtechintergalactical.gtutility.network;

import com.teamresourceful.resourcefullib.common.networking.base.Packet;
import com.teamresourceful.resourcefullib.common.networking.base.PacketContext;
import com.teamresourceful.resourcefullib.common.networking.base.PacketHandler;
import io.github.gregtechintergalactical.gtutility.GTUtility;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class MessageCraftingSync implements Packet<MessageCraftingSync> {
    public static final Handler HANDLER = new Handler();

    @Override
    public ResourceLocation getID() {
        return GTUtility.SYNC_ID;
    }

    @Override
    public PacketHandler<MessageCraftingSync> getHandler() {
        return HANDLER;
    }

    private static class Handler implements PacketHandler<MessageCraftingSync>{
        @Override
        public void encode(MessageCraftingSync messageCraftingSync, FriendlyByteBuf friendlyByteBuf) {
        }

        @Override
        public MessageCraftingSync decode(FriendlyByteBuf friendlyByteBuf) {
            return new MessageCraftingSync();
        }

        @Override
        public PacketContext handle(MessageCraftingSync messageCraftingSync) {
            return (player, level) -> {
                if (player != null) {
                    AbstractContainerMenu container = player.containerMenu;
                    if (container != null) {
                        container.slotsChanged(null);
                    }
                }
            };
        }
    }
}
