package me.sapien.plugin.sapien.commandlib;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.Plugin;

/**
 * Class that is the root of all sub-commands and gets registered as the command executor and tab completer
 */
public abstract class BaseCommand extends SubCommand implements CommandExecutor, TabCompleter {

    /**
     * The name of this command, the same as in the plugin.yml. The name in the plugin.yml has to be lowercase
     *
     * @param name The name of this command
     */
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

    /**
     * Registers this command as the executor and tab completer for the given command name
     *
     * @param plugin The plugin to use to register this command
     */
    public void register(final Plugin plugin) {
        // TODO Change this into reflection.
        // plugin.getCommand(this.getName()).setExecutor(this);
        // plugin.getCommand(this.getName()).setTabCompleter(this);
    }

}
