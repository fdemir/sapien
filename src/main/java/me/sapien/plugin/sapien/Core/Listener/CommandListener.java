package me.sapien.plugin.sapien.Core.Listener;

import com.eclipsesource.v8.V8Function;
import me.sapien.plugin.sapien.Sapien;
import me.sapien.plugin.sapien.Util.CCommand;
import org.bukkit.command.CommandSender;

public class CommandListener extends CCommand {

    private V8Function func;

    public CommandListener(String name, V8Function func) {
        super(name);
        this.func = func;
    }

    @Override
    public void run(CommandSender s, String cl, String[] args) {
        func.call(Sapien.getInstance().runtime.getRuntime(), null);
    }

}
