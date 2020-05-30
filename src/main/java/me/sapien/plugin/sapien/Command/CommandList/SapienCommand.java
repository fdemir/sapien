package me.sapien.plugin.sapien.Command.CommandList;

import me.sapien.plugin.sapien.Command.BaseCommand;
import me.sapien.plugin.sapien.Command.CommandList.SubCommands.TestSubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SapienCommand extends BaseCommand {

    public SapienCommand(final JavaPlugin plugin) {
        super("sapien");
        // this.addSubCommand(new TestSubCommand());
        this.register(plugin);
    }

    @Override
    public void run(final CommandSender sender) {
       sender.sendMessage(ChatColor.BLUE + "Sapien v1.0.0");
    }

}
