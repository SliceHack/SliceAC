package com.sliceclient.anticheat;

import com.sliceclient.anticheat.event.listener.BrandListener;
import com.sliceclient.anticheat.manager.EventManager;
import lombok.Getter;
import com.sliceclient.anticheat.event.listener.Listener;
import com.sliceclient.anticheat.manager.UserManager;
import org.bukkit.plugin.messaging.PluginMessageListener;

/**
 * The Slice AntiCheat plugin.
 *
 * @author Nick
 * */
@Getter
public enum SliceAC {
    INSTANCE;

    private final EventManager eventManager;
    private final UserManager userManager;

    /**
     * Constructor
     */
    SliceAC() {
        eventManager = new EventManager();
        AntiCheat.instance().getServer().getPluginManager().registerEvents(new Listener(), AntiCheat.instance());
        AntiCheat.instance().getServer().getPluginManager().registerEvents(userManager = new UserManager(), AntiCheat.instance());

        /*
         * MC|Brand 1.8-
         * minecraft:brand 1.9+
         */
        registerPluginChannel("minecraft:brand", new BrandListener());
//        registerPluginChannel("MC|Brand", new BrandListener());
    }

    /**
     * Registers a plugin channel.
     *
     * @param channel The channel to register.
     * @param listener The listener to register.
     */
    private void registerPluginChannel(String channel, PluginMessageListener listener) {
        AntiCheat.instance().getServer().getMessenger().registerIncomingPluginChannel(AntiCheat.instance(), channel, listener);
    }

}
