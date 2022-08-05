package com.sliceclient.anticheat.check.checks.movement;

import com.sliceclient.anticheat.utils.MathUtil;
import com.sliceclient.anticheat.utils.MovementUtil;
import com.sliceclient.anticheat.check.Check;
import com.sliceclient.anticheat.check.data.CheckInfo;
import com.sliceclient.anticheat.event.data.EventInfo;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerMoveEvent;

@CheckInfo(name = "Fabricated Movement")
public class Fabricated extends Check {

    @EventInfo
    public void onPlayerMove(PlayerMoveEvent e) {
        if (!MovementUtil.isMoving(e)) return;

        double diff = MathUtil.roundTo(MovementUtil.getDeltaXZ(e), 7) * 10000000;
        String diffString = String.valueOf(diff);

        Bukkit.broadcastMessage(diffString);
    }
}
