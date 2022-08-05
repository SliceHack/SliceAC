package me.nickrest.anticheat.manager;

import lombok.Getter;
import me.nickrest.anticheat.event.Event;
import me.nickrest.anticheat.event.EventSender;
import me.nickrest.anticheat.event.data.EventInfo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * The EventManager
 *
 * @author Nick
 * **/
@Getter
public class EventManager {

    /** The registered objects */
    private final List<Object> registeredObjects = new ArrayList<>();

    /**
     * Runs all events.
     *
     * @param event The event to run.
     * */
    public void runEvent(Event event) {
        List<Object> registeredObjects = new ArrayList<>(this.registeredObjects);

        for (Object object : registeredObjects) {
            for (Method method : getMethods(object.getClass())) {

                if(method.getParameterTypes().length == 1
                        && method.isAnnotationPresent(EventInfo.class)
                        && method.getParameterTypes()[0].equals(event.getClass())) {
                    new EventSender(event, method, object);
                }
            }
        }
    }

    /**
     * Checks if an object is registered.
     *
     * @param object The object to check.
     * */
    public boolean isRegistered(Object object) {
        return registeredObjects.contains(object);
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
    public void register(Object object) {
        if(isRegistered(object))
            return;

        registeredObjects.add(object);
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