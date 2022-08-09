package com.sliceclient.anticheat.utils;

import com.sliceclient.anticheat.SliceAC;
import com.sliceclient.anticheat.user.User;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * The PlayerUtil class.
 *
 * @author Nick
 * */
@UtilityClass
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

    public boolean isOnWhitelistedBlock(Player player) {
        User user = SliceAC.INSTANCE.getUserManager().getUser(player);
        return user.getBlockUnder() == Material.SANDSTONE_STAIRS
                || user.getBlockUnder() == Material.COBBLESTONE_STAIRS
                || user.getBlockUnder() == Material.BRICK_STAIRS
                || user.getBlockUnder() == Material.NETHER_BRICK_STAIRS
                || user.getBlockUnder() == Material.SANDSTONE_STAIRS
                || user.getBlockUnder() == Material.QUARTZ_STAIRS
                || user.getBlockUnder() == Material.ACACIA_STAIRS
                || user.getBlockUnder() == Material.DARK_OAK_STAIRS
                || user.getBlockUnder() == Material.RED_SANDSTONE_STAIRS
                || user.getBlockUnder() == Material.SPRUCE_STAIRS
                || user.getBlockUnder() == Material.STONE_BRICK_STAIRS
                || user.getBlockUnder() == Material.BRICK_STAIRS
                || user.getBlockUnder() == Material.NETHER_BRICK_STAIRS;
    }
}
