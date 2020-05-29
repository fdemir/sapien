package me.sapien.plugin.sapien.Core;

import me.sapien.plugin.sapien.Events.Command;
import me.sapien.plugin.sapien.Functions.Ban;
import me.sapien.plugin.sapien.Functions.Broadcast;
import me.sapien.plugin.sapien.Functions.Delay;
import me.sapien.plugin.sapien.Sapien;

public class Function {

    public void loadAll() {
        // @refactor

        Sapien.getInstance().runtime.getRuntime().registerJavaMethod(new Broadcast(), "broadcast");
        Sapien.getInstance().runtime.getRuntime().registerJavaMethod(new Ban(), "ban");
        Sapien.getInstance().runtime.getRuntime().registerJavaMethod(new Delay(), "delay");

        // Listener
        Sapien.getInstance().runtime.getRuntime().registerJavaMethod(new Command(), "command");

    }

}
