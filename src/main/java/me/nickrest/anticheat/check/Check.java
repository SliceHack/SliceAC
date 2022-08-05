package me.nickrest.anticheat.check;

import lombok.Getter;
import me.nickrest.anticheat.check.data.CheckInfo;

/***
 * The check class.
 *
 * @author Nick
 * */
@Getter
public class Check {

    /** The check info */
    private final CheckInfo info = getClass().getAnnotation(CheckInfo.class);

    /** Info */
    private final String name, type, description;

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
