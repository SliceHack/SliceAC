package com.sliceclient.anticheat.user;

import com.sliceclient.anticheat.SliceAC;
import lombok.Getter;
import lombok.Setter;
import com.sliceclient.anticheat.manager.CheckManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * The user class.
 *
 * @author Nick
 * */
@Getter @Setter
public class User {
    private final Player player;
    private String brand;
    private CheckManager checkManager;
    private boolean exempted;

    public User(Player player) {
        this.player = player;
    }

    public void setExempted(boolean exempted) {
        this.exempted = exempted;

        if(exempted) checkManager.getChecks().forEach(check -> SliceAC.INSTANCE.getEventManager().unregister(check));
        else checkManager.getChecks().forEach(check -> SliceAC.INSTANCE.getEventManager().register(check, player));
    }

    public Material getBlockUnder() {
        double expand = 0.3;
        for(double x = -expand; x <= expand; x += expand) {
            for(double z = -expand; z <= expand; z += expand) {
                return player.getLocation().clone().add(x, -0.0001, z).getBlock().getType();
            }
        }
        return null;
    }
}