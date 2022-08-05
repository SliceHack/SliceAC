package me.nickrest.anticheat.user;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.anticheat.manager.CheckManager;
import org.bukkit.entity.Player;

/**
 * The user class.
 *
 * @author Nick
 * */
@Getter @Setter
public class User {
    private final Player player;
    private CheckManager checkManager;

    public User(Player player) {
        this.player = player;
    }
}