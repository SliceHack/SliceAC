package me.nickrest.anticheat.check.checks;

import me.nickrest.anticheat.check.Check;
import me.nickrest.anticheat.check.data.CheckInfo;
import me.nickrest.anticheat.event.data.EventInfo;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerMoveEvent;

@CheckInfo(name = "TestCheck")
public class TestCheck extends Check {

    @EventInfo
    public void onPlayerMove(PlayerMoveEvent e) {
        Bukkit.broadcastMessage(user.getPlayer().getName() + " is moving");
    }
}
