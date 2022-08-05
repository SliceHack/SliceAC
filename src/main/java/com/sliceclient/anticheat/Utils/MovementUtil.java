package com.sliceclient.anticheat.Utils;

import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

public class MovementUtil {

    public static boolean isMoving(PlayerMoveEvent e) {
        return e.getFrom().getX() != Objects.requireNonNull(e.getTo()).getX() || e.getFrom().getY() != e.getTo().getY() || e.getFrom().getZ() != e.getTo().getZ();
    }

    public static double getDeltaX(PlayerMoveEvent e) {
        return Objects.requireNonNull(e.getTo()).getX() - e.getFrom().getX();
    }

    public static double getDeltaZ(PlayerMoveEvent e) {
        return Objects.requireNonNull(e.getTo()).getZ() - e.getFrom().getZ();
    }

    public static double getDeltaXZ(PlayerMoveEvent e) {
        return Math.sqrt(Math.pow(getDeltaX(e), 2) + Math.pow(getDeltaZ(e), 2));
    }

}
