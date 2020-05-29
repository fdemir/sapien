package me.sapien.plugin.sapien.commandlib;

import com.google.common.base.Preconditions;
import java.util.*;
import java.util.stream.Collectors;
import org.bukkit.command.CommandSender;

/**
 * Class for all sub-commands
 */
public abstract class SubCommand {

    private static final String NOT_IMPLEMENTED = "This method has not been implemented yet. Sub-Command name: %name%";

    private final String name;

    private final List<SubCommand> subCommands;

    /**
     * Creates a new sub-command with the provided name.
     * <br>
     * The name will be converted to lowercase if he isn't already
     * <br>
     * The name of the sub-command is what you would enter after the primary command, for example:
     * <br>
     * <ul>
     *     <li><code>/command name</code></li>
     *     <li><code>/command sub-command name</code></li>
     * </ul>
     *
     * @param name The name of the command to use
     * @throws NullPointerException If the name is null
     */
    public SubCommand(final String name) {
        this.name = Preconditions.checkNotNull(name, "Th name for the command cannot be null!").toLowerCase();
        this.subCommands = new ArrayList<>();
    }

    /**
     * A guard that is run to check if a CommandSender is allowed to access this command
     *
     * @param sender The sender who issued the command or tab completion
     * @param args The arguments that have been entered so far
     * @param isTabCompletion <code>true</code> if this was caused by an tab completion or not
     * @return <code>true</code> if the command sender is allowed to access this command
     */
    public boolean guard(final CommandSender sender, final List<String> args, final boolean isTabCompletion) {
        return true;
    }

    /**
     * Adds a new sub command to this command
     *
     * @param command The command to add
     * @return <code>this</code> for chained calls
     */
    public SubCommand addSubCommand(final SubCommand command) {
        this.subCommands.add(command);
        return this;
    }

    /**
     * @return The name of this command
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Optionally you can override this method to also make this sub-command accessible via aliases.
     * <br><br>
     * Aliases will not show up in tab-completion
     *
     * @return A list of aliases for this commands name
     */
    public List<String> getAliases() {
        return Collections.emptyList();
    }

    /**
     * This is the method that is run if no further arguments are provided to this sub command
     *
     * @param sender The issuer of the command
     */
    public void run(final CommandSender sender) {
        sender.sendMessage(SubCommand.NOT_IMPLEMENTED.replace("%name%", this.getName()));
    }

    /**
     * This is the method that is run, if further arguments are provided, but are not matching any sub-command name
     *
     * @param sender The issuer of the command
     * @param args Any additional arguments
     */
    public void run(final CommandSender sender, final List<String> args) {
        sender.sendMessage(SubCommand.NOT_IMPLEMENTED.replace("%name%", this.getName()));
    }

    /**
     * This is the method that is run if this sub-command is trying to retrieve tab-completions.
     * <br>
     * The results of this method are merged with the names of further sub-commands of this sub-command.
     *
     * @param sender the issuer of the tab-completion
     * @param args The arguments that have been provided so far, can be empty
     * @return What the issuer should get recommended for tab-completions
     */
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
