package me.nickrest.anticheat;

import lombok.Getter;
import me.nickrest.anticheat.manager.CheckManager;
import me.nickrest.anticheat.manager.EventManager;
import me.nickrest.anticheat.manager.UserManager;

/**
 * The Slice AntiCheat plugin.
 *
 * @author Nick
 * */
@Getter
public enum SliceAC {
    INSTANCE; // Instance of the plugin

    private final EventManager eventManager;
    private final UserManager userManager;
    private final CheckManager checkManager;


    /**
     * Constructor
     */
    SliceAC() {
        eventManager = new EventManager();
        userManager = new UserManager();
        checkManager = new CheckManager();
    }

}
