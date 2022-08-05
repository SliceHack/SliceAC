package me.nickrest.anticheat.manager;

import lombok.Getter;
import me.nickrest.anticheat.user.User;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The UserManager
 *
 * @author Nick
 * **/
@Getter
public class UserManager {

    private final List<User> users = new ArrayList<>();

    /***
     * Gets a user by the player object.
     *
     * @param player The player object.
     * */
    public User getUser(Player player) {
        return users.stream().filter(user -> user.getPlayer().equals(player)).findFirst().orElse(null);
    }

    /***
     * Registers a user.
     *
     * @param user The user to register.
     * */
    public void addUser(User user) {
        if(getUser(user.getPlayer()) != null)
            return;

        users.add(user);
    }

    /***
     * Unregisters a user.
     *
     * @param user The user to unregister.
     * */
    public void removeUser(User user) {
        if(getUser(user.getPlayer()) == null)
            return;

        users.remove(user);
    }

}
