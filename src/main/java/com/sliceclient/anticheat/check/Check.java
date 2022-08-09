package com.sliceclient.anticheat.check;

import lombok.Getter;
import lombok.Setter;
import com.sliceclient.anticheat.check.data.CheckInfo;
import com.sliceclient.anticheat.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/***
 * The check class.
 *
 * @author Nick
 * */
@Getter @Setter
public class Check {

    /** The check info */
    private final CheckInfo info = getClass().getAnnotation(CheckInfo.class);

    /** Info */
    private final String name, type, description;
    public User user;

    /**
     * Constructor.
     * */
    public Check() {
        if(info == null) throw new IllegalStateException("CheckInfo is null!");

        name = info.name();
        type = info.type();
        description = info.description();
    }

    /**
     * Flags the check as failed.
     * */
    public void flag() {
        String text = "&cSlice &7» &c" + user.getPlayer().getName() + " &7has been flagged for &c" + name + "  &7(&c" + type + "&7)";
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', text));
    }

}
