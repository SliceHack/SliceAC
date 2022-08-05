package me.nickrest.anticheat;

import lombok.Getter;
import me.nickrest.anticheat.event.listener.Listener;
import me.nickrest.anticheat.manager.CheckManager;
import me.nickrest.anticheat.manager.EventManager;
import me.nickrest.anticheat.manager.UserManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

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
