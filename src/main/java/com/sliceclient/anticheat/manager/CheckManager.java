package com.sliceclient.anticheat.manager;

import com.sliceclient.anticheat.SliceAC;
import com.sliceclient.anticheat.check.Check;
import com.sliceclient.anticheat.check.checks.movement.ground.GroundSpoof;
import com.sliceclient.anticheat.check.checks.movement.motion.MotionA;
import com.sliceclient.anticheat.user.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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
    public CheckManager(User user) {
        register(new GroundSpoof());
        register(new MotionA());
//        register(new Fabricated());

        checks.forEach((check -> { SliceAC.INSTANCE.getEventManager().register(check, user.getPlayer()); check.setUser(user); }));

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
