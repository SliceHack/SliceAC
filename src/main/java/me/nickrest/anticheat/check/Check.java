package me.nickrest.anticheat.check;

import lombok.Getter;
import lombok.Setter;
import me.nickrest.anticheat.check.data.CheckInfo;
import me.nickrest.anticheat.user.User;

/***
 * The check class.
 *
 * @author Nick
 * */
@Getter @Setter
public class Check {

    /** The check info */
    private final CheckInfo info = getClass().getAnnotation(CheckInfo.class);

    /** Info */
    private final String name, type, description;
    public User user;

    /**
     * Constructor.
     * */
    public Check() {
        if(info == null) throw new IllegalStateException("CheckInfo is null!");

        name = info.name();
        type = info.type();
        description = info.description();
    }
}
