package io.github.gregtechintergalactical.gtutility.network;

import muramasa.antimatter.network.packets.IAntimatterPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import trinsdar.networkapi.api.IPacket;

public class MessageCraftingSync implements IPacket {

    @Override
    public void encode(FriendlyByteBuf buf) {
    }

    @Override
    public void handleClient(ServerPlayer player) {
        if (player != null) {
            AbstractContainerMenu container = player.containerMenu;
            if (container != null) {
                container.slotsChanged(null);
            }
        }
    }

    @Override
    public void handleServer() {
    }
}
