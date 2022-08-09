package com.sliceclient.anticheat.check.checks.movement.motion;

import com.sliceclient.anticheat.check.Check;
import com.sliceclient.anticheat.check.data.CheckInfo;
import com.sliceclient.anticheat.event.data.EventInfo;
import com.sliceclient.anticheat.utils.PlayerUtil;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

@CheckInfo(name = "Motion", description = "Checks if the player's MotionY is suspicious.")
public class MotionA extends Check {

    private boolean last;

    @EventInfo
    public void onMove(PlayerMoveEvent e) {
        if(e.getTo() == null) return;
        if(PlayerUtil.isOnWhitelistedBlock(user.getPlayer())) return;
        if(user.getPlayer().hasPotionEffect(PotionEffectType.JUMP)) return;

        double y = e.getTo().getY();
        double lastY = e.getFrom().getY();
        double diff = y - lastY;

        boolean invalid = (diff > 0.42 && !isNegative(diff)) || justAFewDigits(diff) && diff != 0;

        boolean last = this.last;
        this.last = invalid;

        if(invalid && last) {
            flag();
        }
    }

    private boolean isNegative(double d) {
        return d < 0;
    }

    private boolean justAFewDigits(double d) {
        String s = d + "";
        return s.length() <= 4;
    }
}
