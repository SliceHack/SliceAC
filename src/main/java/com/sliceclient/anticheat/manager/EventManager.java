package com.sliceclient.anticheat.manager;

import lombok.Getter;
import com.sliceclient.anticheat.event.EventSender;
import com.sliceclient.anticheat.event.data.EventInfo;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerEvent;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * The EventManager
 *
 * @author Nick
 * **/
@Getter
public class EventManager {

    /** The registered objects */
    private final Map<Object, Player> registeredObjects = new HashMap<>();

    /**
     * Runs all events.
     *
     * @param event The event to run.
     * */
    public void runEvent(Event event) {
        if(!(event instanceof PlayerEvent)) return;
        PlayerEvent e = (PlayerEvent) event;
        Player player = e.getPlayer();

        Map<Object, Player> registeredObjects = new HashMap<>(this.registeredObjects);

        registeredObjects.forEach((object, player1) -> {
            for (Method method : getMethods(object.getClass())) {
                if(method.getParameterTypes().length == 1 && method.isAnnotationPresent(EventInfo.class) && method.getParameterTypes()[0].equals(event.getClass()) && player1.equals(player)) {
                    new EventSender(e, method, object);
                }
            }
        });
    }

    /**
     * Checks if an object is registered.
     *
     * @param object The object to check.
     * */
    public boolean isRegistered(Object object) {
        return registeredObjects.get(object) != null;
    }

    /**
     * Gets all methods from a class.
     *
     * @param clazz The class to get the methods from.
     * @return The methods.
     * */
    public Method[] getMethods(Class<?> clazz) {
        return clazz.getMethods();
    }

    /**
     * Register an object to the event manager.
     *
     * @param object The object to register.
     * */
    public void register(Object object, Player player) {
        if(isRegistered(object))
            return;

        registeredObjects.put(object, player);
    }

    /**
     * unregister an object from the event manager.
     *
     * @param object The object to unregister.
     * */
    public void unregister(Object object) {
        if(!isRegistered(object))
            return;

        registeredObjects.remove(object);
    }
}
