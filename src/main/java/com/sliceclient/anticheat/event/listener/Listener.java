package com.sliceclient.anticheat.event.listener;

import com.sliceclient.anticheat.AntiCheat;
import com.sliceclient.anticheat.SliceAC;
import com.sliceclient.anticheat.user.User;
import com.sliceclient.anticheat.manager.CheckManager;
import com.sliceclient.anticheat.utils.PlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/***
 * The listener class.
 *
 * @author Nick
 * */
public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if(SliceAC.INSTANCE.getUserManager().getUser(event.getPlayer()) == null) {
            User user = new User(event.getPlayer());
            SliceAC.INSTANCE.getUserManager().addUser(user);
            user.setCheckManager(new CheckManager(user));
            SliceAC.INSTANCE.getEventManager().runEvent(event);
            return;
        }

        User user = SliceAC.INSTANCE.getUserManager().getUser(event.getPlayer());

        if(PlayerUtil.isOnWhitelistedBlock(user.getPlayer()) && !user.isExempted()) {
            user.setExempted(true);
            Bukkit.getScheduler().runTaskLater(AntiCheat.instance(), () -> user.setExempted(false), 20);
        }

        SliceAC.INSTANCE.getEventManager().runEvent(event);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if(SliceAC.INSTANCE.getUserManager().getUser(event.getPlayer()) == null)
            return;

        SliceAC.INSTANCE.getUserManager().removeUser(SliceAC.INSTANCE.getUserManager().getUser(event.getPlayer()));
        SliceAC.INSTANCE.getEventManager().runEvent(event);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        User user = new User(event.getPlayer());
        SliceAC.INSTANCE.getUserManager().addUser(user);
        user.setCheckManager(new CheckManager(user));
        SliceAC.INSTANCE.getEventManager().runEvent(event);
    }
}
