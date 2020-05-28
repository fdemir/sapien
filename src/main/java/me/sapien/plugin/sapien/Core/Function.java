package me.sapien.plugin.sapien.Core;

import me.sapien.plugin.sapien.Functions.Broadcast;
import me.sapien.plugin.sapien.Sapien;

public class Function {

    public void loadAll() {
        // @refactor
        Sapien.getInstance().runtime.getRuntime().registerJavaMethod(new Broadcast(), "broadcast");
    }

}
