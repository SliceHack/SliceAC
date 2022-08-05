package com.sliceclient.anticheat;

import com.sliceclient.anticheat.manager.EventManager;
import lombok.Getter;
import com.sliceclient.anticheat.event.listener.Listener;
import com.sliceclient.anticheat.manager.UserManager;

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
    }

}
