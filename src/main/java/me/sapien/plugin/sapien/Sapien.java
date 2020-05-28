package me.sapien.plugin.sapien;

import me.sapien.plugin.sapien.Config.Config;
import me.sapien.plugin.sapien.Core.Function;
import me.sapien.plugin.sapien.Engine.Runtime;
import me.sapien.plugin.sapien.Engine.Temp;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sapien extends JavaPlugin {

    private static Sapien instance;
    public static Sapien getInstance() {
        return instance;
    }

    public Temp temp;
    public Runtime runtime;
    public Function function;
    private Config config;

    @Override
    public void onLoad() {
        instance = this;
        this.temp = new Temp();
        this.runtime = new Runtime(temp);
        this.config = new Config();
        this.function = new Function();
    }

    @Override
    public void onEnable() {
        config.init();
        runtime.init();

        function.loadAll();


        getLogger().info("Sapien has been enabled.");
    }

    @Override
    public void onDisable() {
        runtime.terminate();
        getLogger().info("Sapien has been disabled.");
    }
}
