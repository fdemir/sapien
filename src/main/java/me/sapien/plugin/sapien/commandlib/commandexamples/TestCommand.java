package me.sapien.plugin.sapien.commandlib.commandexamples;

import me.sapien.plugin.sapien.commandlib.BaseCommand;
import me.sapien.plugin.sapien.commandlib.commandexamples.subs.TestSubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public final class TestCommand extends BaseCommand {

    public TestCommand(final Plugin plugin) {
        super("test");
        this.addSubCommand(new TestSubCommand());
        this.register(plugin);
    }

    @Override
    public void run(final CommandSender sender) {
        // /test executed.
    }

}
