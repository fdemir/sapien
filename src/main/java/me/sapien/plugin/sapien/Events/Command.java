package me.sapien.plugin.sapien.Events;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import me.sapien.plugin.sapien.Core.Listener.CommandListener;
import me.sapien.plugin.sapien.Sapien;

public class Command implements JavaVoidCallback {

    @Override
    public void invoke(final V8Object receiver, final V8Array parameters) {
        if(parameters.length() == 2) {
            String commandName = (String) parameters.get(0);
            V8Function func = (V8Function) parameters.get(1);
            Sapien.getInstance().registerCommands(new CommandListener(commandName, func));
        }
    }

}
