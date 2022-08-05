package me.nickrest.anticheat.check.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The CheckInfo class.
 *
 * @author Nick
 * */
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckInfo {
    String name();
    String type() default "A";
    String description() default "No description provided!";
    boolean kick() default false;
}
