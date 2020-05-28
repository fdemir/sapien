package me.sapien.plugin.sapien;

import me.sapien.plugin.sapien.Command.Test;
import me.sapien.plugin.sapien.Config.Config;
import me.sapien.plugin.sapien.Core.Effect;
import me.sapien.plugin.sapien.Engine.Runtime;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sapien extends JavaPlugin {

    private static Sapien instance;
    public static Sapien getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        //getCommand("test").setExecutor(new Test());

        Config.init();
        Runtime.init();


        Effect.loadAll();
        getLogger().info("Sapien has been enabled.");
    }

    @Override
    public void onDisable() {
        Runtime.terminate();
        getLogger().info("Sapien has been disabled.");
    }
}
