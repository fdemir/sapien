package me.sapien.plugin.sapien.commandlib.commandexamples.subs;

import java.util.List;
import me.sapien.plugin.sapien.commandlib.SubCommand;
import org.bukkit.command.CommandSender;

public final class TestSubCommand extends SubCommand {

    public TestSubCommand() {
        super("testsub");
    }

    @Override
    public void run(final CommandSender sender, final List<String> args) {
        // /test testsub executed.
    }

}
