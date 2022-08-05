package me.nickrest.anticheat.check.data;

/**
 * The CheckInfo class.
 *
 * @author Nick
 * */
public @interface CheckInfo {
    String name();
    String type() default "A";
    String description() default "No description provided!";
}
