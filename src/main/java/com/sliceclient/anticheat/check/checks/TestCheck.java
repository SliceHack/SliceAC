package com.sliceclient.anticheat.check.checks;

import com.sliceclient.anticheat.check.Check;
import com.sliceclient.anticheat.check.data.CheckInfo;
import com.sliceclient.anticheat.event.data.EventInfo;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerMoveEvent;

@CheckInfo(name = "TestCheck")
public class TestCheck extends Check {

    @EventInfo
    public void onPlayerMove(PlayerMoveEvent e) {
        Bukkit.broadcastMessage(user.getPlayer().getName() + " is moving");
    }
}
