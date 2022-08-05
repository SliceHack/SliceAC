package me.nickrest.anticheat.manager;

import lombok.Getter;
import me.nickrest.anticheat.check.Check;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

/***
 * CheckManager
 *
 * @author Nick
 * */
@Getter
public class CheckManager {

    /** The registered checks */
    private final List<Check> checks = new ArrayList<>();

    /*** Constructor */
    public CheckManager() {

    }

    /**
     * Register a check.
     *
     * @param check The check to register.
     * */
    public void register(Check check) {
        checks.add(check);
    }


    /***
     * Gets a check by the class.
     *
     * @param clazz The class.
     * */
    public Check getCheck(Class<? extends Check> clazz) {
        return checks.stream().filter(check -> check.getClass().equals(clazz)).findFirst().orElse(null);
    }

}
