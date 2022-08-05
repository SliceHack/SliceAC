package me.nickrest.anticheat.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

/**
 * The user class.
 *
 * @author Nick
 * */
@Getter @Setter
@AllArgsConstructor
public class User {
    private final Player player;
}