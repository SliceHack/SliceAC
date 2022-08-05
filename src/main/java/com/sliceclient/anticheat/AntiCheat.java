package com.sliceclient.anticheat;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class AntiCheat extends JavaPlugin {

    private SliceAC INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = SliceAC.INSTANCE;
    }

    public static AntiCheat instance() {
        return getPlugin(AntiCheat.class);
    }

}
