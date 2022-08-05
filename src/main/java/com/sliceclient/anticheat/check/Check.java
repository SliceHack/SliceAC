package com.sliceclient.anticheat.check;

import lombok.Getter;
import lombok.Setter;
import com.sliceclient.anticheat.check.data.CheckInfo;
import com.sliceclient.anticheat.user.User;

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
