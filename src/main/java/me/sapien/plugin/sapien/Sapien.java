package me.sapien.plugin.sapien;

import org.bukkit.plugin.java.JavaPlugin;

public final class Sapien extends JavaPlugin {

    public static Sapien plugin;

    public static Sapien getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
