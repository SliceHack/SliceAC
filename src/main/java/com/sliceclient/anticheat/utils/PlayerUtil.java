package com.sliceclient.anticheat.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * The PlayerUtil class.
 *
 * @author Nick
 * */
public class PlayerUtil {

    /**
     * Checks server ground state.
     *
     * @param player The player.
     * */
    public boolean isOnGround(Player player) {
        double expand = 0.3;
        for(double x = -expand; x <= expand; x += expand) {
            for(double z = -expand; z <= expand; z += expand) {
                if(player.getLocation().clone().add(x, -0.5001, z).getBlock().getType() != Material.AIR) {
                    return true;
                }
            }
        }
        return false;
    }
}
