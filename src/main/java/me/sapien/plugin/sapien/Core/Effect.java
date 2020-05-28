package me.sapien.plugin.sapien.Core;

import me.sapien.plugin.sapien.Effects.Broadcast;
import me.sapien.plugin.sapien.Engine.Runtime;

public class Effect {

    public static void loadAll() {
        // @test
        Runtime.getRuntime().registerJavaMethod(new Broadcast(), "broadcast");
        Runtime.getRuntime().executeScript("broadcast('hello, world');");
    }

}
