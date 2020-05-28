package me.sapien.plugin.sapien.Config;

import me.sapien.plugin.sapien.Sapien;

public class Config {

    public void init() {
        Sapien.getInstance().getConfig().options().copyDefaults(true);
        Sapien.getInstance().saveConfig();
    }
}
