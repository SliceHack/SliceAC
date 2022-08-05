package com.sliceclient.anticheat.event.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.sliceclient.anticheat.SliceAC;
import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BrandListener implements PluginMessageListener {

    @SuppressWarnings("all")
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, byte[] message) {
        if(channel.equalsIgnoreCase("minecraft:brand") || channel.equalsIgnoreCase("MC|Brand")) {
            ByteArrayDataInput bytes;

            try {
                bytes = ByteStreams.newDataInput(message);
            } catch (Exception e) {
                return;
            }

            String brand = bytes.readLine().substring(0);

            SliceAC.INSTANCE.getUserManager().getUser(player).setBrand(brand);
        }
    }
}
