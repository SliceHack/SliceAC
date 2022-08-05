package me.nickrest.anticheat.event.listener;

import me.nickrest.anticheat.SliceAC;
import me.nickrest.anticheat.manager.CheckManager;
import me.nickrest.anticheat.user.User;
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
