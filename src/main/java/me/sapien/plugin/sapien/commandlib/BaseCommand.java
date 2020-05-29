package me.sapien.plugin.sapien.commandlib;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.Plugin;

public abstract class BaseCommand extends SubCommand implements CommandExecutor, TabCompleter {

    public BaseCommand(final String name) {
        super(name);
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        this.onCommand(sender, new LinkedList<>(Arrays.asList(args)));
        return true;
    }

    @Override
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {
        return this.onTabComplete(sender, new LinkedList<>(Arrays.asList(args)));
    }

    public void register(final Plugin plugin) {
        // TODO Change this into reflection.
        // plugin.getCommand(this.getName()).setExecutor(this);
        // plugin.getCommand(this.getName()).setTabCompleter(this);
    }

}
