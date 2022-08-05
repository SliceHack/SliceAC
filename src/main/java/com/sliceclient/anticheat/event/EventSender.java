package com.sliceclient.anticheat.event;

import com.sliceclient.anticheat.event.data.EventInfo;
import lombok.Getter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * The class used to send all events.
 *
 * @author Nick
 * */
@Getter
public class EventSender {

    /** The event to send */
    private final org.bukkit.event.Event event;

    /** The method to send */
    private final Method method;

    /** The object to send */
    private final Object object;

    /**
     * To Avoid one class running to many events at the same time.
     *
     * @param event The event to run.
     * @param method The method to run.
     * @param parent The object to run the method on.
     * */
    public EventSender(org.bukkit.event.Event event, Method method, Object parent) {
        this.event = event;
        this.method = method;
        this.object = parent;

        runEvent();
    }

    /**
     * To run the event.
     * */
    public synchronized void runEvent() {
        try {
            if(!method.isAccessible()) method.setAccessible(true);
            if(!hasAnnotation(method, EventInfo.class)) return;
            if(!getMethodParameterType(method, 0).equals(event.getClass())) return;

            method.invoke(object, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if a method has an annotation.
     *
     * @param method The method to check.
     * @param annotation The annotation to check for.
     * @return If the method has the annotation.
     * */
    public boolean hasAnnotation(Method method, Class<? extends Annotation> annotation) {
        return method.isAnnotationPresent(annotation);
    }


    /**
     * Gets parameters from a method.
     *
     * @param method The method to get the parameters from.
     * @parma index The index of the parameter.
     * @return The parameter.
     * */
    public Class<?> getMethodParameterType(Method method, int index) {
        return method.getParameterTypes()[index];
    }
}
