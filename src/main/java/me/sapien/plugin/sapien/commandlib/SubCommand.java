package me.sapien.plugin.sapien.commandlib;

import com.google.common.base.Preconditions;
import java.util.*;
import java.util.stream.Collectors;
import org.bukkit.command.CommandSender;

public abstract class SubCommand {

    private static final String NOT_IMPLEMENTED = "This method has not been implemented yet. Sub-Command name: %name%";

    private final String name;

    private final List<SubCommand> subCommands;

    public SubCommand(final String name) {
        this.name = Preconditions.checkNotNull(name, "Th name for the command cannot be null!").toLowerCase();
        this.subCommands = new ArrayList<>();
    }

    public boolean guard(final CommandSender sender, final List<String> args, final boolean isTabCompletion) {
        return true;
    }

    public SubCommand addSubCommand(final SubCommand command) {
        this.subCommands.add(command);
        return this;
    }

    public final String getName() {
        return this.name;
    }

    public List<String> getAliases() {
        return Collections.emptyList();
    }

    public void run(final CommandSender sender) {
        sender.sendMessage(SubCommand.NOT_IMPLEMENTED.replace("%name%", this.getName()));
    }

    public void run(final CommandSender sender, final List<String> args) {
        sender.sendMessage(SubCommand.NOT_IMPLEMENTED.replace("%name%", this.getName()));
    }

    public List<String> tabComplete(final CommandSender sender, final List<String> args) {
        return Collections.emptyList();
    }

    void onCommand(final CommandSender sender, final LinkedList<String> args) {
        if (!this.guard(sender, args, false)) {
            return;
        }
        if (args.isEmpty()) {
            this.run(sender);
            return;
        }
        final String subCommandName = args.getFirst().toLowerCase(Locale.ENGLISH);
        for (final SubCommand subCommand : this.subCommands) {
            if (subCommand.getName().equals(subCommandName) || subCommand.getAliases().contains(subCommandName)) {
                subCommand.onCommand(sender, args);
                return;
            }
        }
        this.run(sender, args);
    }

    final List<String> onTabComplete(final CommandSender sender, final LinkedList<String> args) {
        if (!this.guard(sender, args, true)) {
            return Collections.emptyList();
        }
        final String subCommandName = args.getFirst().toLowerCase(Locale.ENGLISH);
        for (final SubCommand subCommand : this.subCommands) {
            if (subCommand.getName().equals(subCommandName) || subCommand.getAliases().contains(subCommandName)) {
                return subCommand.onTabComplete(sender, args);
            }
        }
        // TODO check for subcommand guard
        final List<String> completions = this.subCommands.stream().map(SubCommand::getName).collect(Collectors.toList());
        completions.addAll(this.tabComplete(sender, args));
        return completions;
    }

}
