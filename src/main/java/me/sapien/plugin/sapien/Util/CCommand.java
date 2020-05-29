package me.sapien.plugin.sapien.Util;
import java.util.Arrays;

import me.sapien.plugin.sapien.Sapien;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;

public abstract class CCommand extends Command implements PluginIdentifiableCommand{

    CommandSender sender;

    protected CCommand(String name) {
        super(name);
    }

    @Override
    public Plugin getPlugin() {
        return Sapien.getInstance();
    }

    public abstract void run(CommandSender sender, String commandLabel, String[] arguments);//Just simpler and allows 'return;' instead of 'return true/false;'

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] arguments) {
        this.sender = sender;
        run(sender, commandLabel, arguments);
        return true;
    }

}
