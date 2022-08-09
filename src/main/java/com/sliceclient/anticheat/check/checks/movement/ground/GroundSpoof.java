package com.sliceclient.anticheat.check.checks.movement.ground;

import com.sliceclient.anticheat.check.Check;
import com.sliceclient.anticheat.check.data.CheckInfo;
import com.sliceclient.anticheat.event.data.EventInfo;
import com.sliceclient.anticheat.utils.PlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerMoveEvent;

@CheckInfo(name = "GroundSpoof", description = "Checks if the player is on the ground.")
public class GroundSpoof extends Check {


    private boolean lastOnGround, lastLastOnGround;

    @EventInfo @SuppressWarnings("all")
    public void onMove(PlayerMoveEvent e) {

        boolean onGround = PlayerUtil.isOnGround(e.getPlayer());

        boolean lastOnGround = this.lastOnGround;
        this.lastOnGround = onGround;

        boolean lastLastOnGround = this.lastLastOnGround;
        this.lastLastOnGround = lastOnGround;

        // check's if player is spoofing on or off ground
        if(!onGround && !lastOnGround && !lastLastOnGround && user.getPlayer().isOnGround()) {
            flag();
        }
    }
}
