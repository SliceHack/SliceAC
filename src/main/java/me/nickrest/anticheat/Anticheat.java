package me.nickrest.anticheat;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Anticheat extends JavaPlugin {

    private SliceAC INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = SliceAC.INSTANCE;
    }

}
