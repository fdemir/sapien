package me.sapien.plugin.sapien;

import me.sapien.plugin.sapien.Command.BaseCommand;
import me.sapien.plugin.sapien.Command.CommandList.SapienCommand;
import me.sapien.plugin.sapien.Config.Config;
import me.sapien.plugin.sapien.Core.Function;
import me.sapien.plugin.sapien.Core.Loader;
import me.sapien.plugin.sapien.Engine.Runtime;
import me.sapien.plugin.sapien.Engine.Temp;
import me.sapien.plugin.sapien.Util.CCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Arrays;


public final class Sapien extends JavaPlugin implements Listener {

    private static Sapien instance;
    private static SimpleCommandMap scm;
    private SimplePluginManager spm;

    public static Sapien getInstance() {
        return instance;
    }

    public static SimpleCommandMap getCommandMap() {
        return scm;
    }

    public Temp temp;
    public Runtime runtime;
    public Function function;
    private Config config;
    private Loader loader;

    @Override
    public void onLoad() {
        instance = this;
        this.temp = new Temp();
        this.runtime = new Runtime(temp);
        this.config = new Config();
        this.function = new Function();
        this.loader = new Loader();

        setupSimpleCommandMap();
    }

    @Override
    public void onEnable() {
        config.init();
        runtime.init();
        function.loadAll();
        loader.loadAllScripts();

        new SapienCommand(this);

        getLogger().info("Sapien has been enabled.");
    }

    public void registerCommands(CCommand... commands) {
        Arrays.stream(commands).forEach(command -> scm.register("Sapien", command));
    }

    public void setupSimpleCommandMap() {
        spm = (SimplePluginManager) this.getServer().getPluginManager();
        Field f = null;
        try {
            f = SimplePluginManager.class.getDeclaredField("commandMap");
        } catch (Exception e) {
            e.printStackTrace();
        }
        f.setAccessible(true);
        try {
            scm = (SimpleCommandMap) f.get(spm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        runtime.terminate();
        getLogger().info("Sapien has been disabled.");
    }

}
