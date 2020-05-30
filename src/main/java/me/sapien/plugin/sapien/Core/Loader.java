package me.sapien.plugin.sapien.Core;

import me.sapien.plugin.sapien.Sapien;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Loader {

    // @refactor
    public void loadAllScripts() {
        final File scripts = new File(Sapien.getInstance().getDataFolder() + "/scripts");
        if(scripts.exists() && scripts.listFiles().length > 0) {
            for(File f : scripts.listFiles()) {
                if(FilenameUtils.getExtension(f.getName()).equals("js")) {
                    // try {
                    //    String script = Files.readString(Paths.get(f.getPath()), StandardCharsets.UTF_8);
                    //    Sapien.getInstance().runtime.getRuntime().executeScript(script);
                    // } catch (IOException e) {
                    //    e.printStackTrace();
                    // }
                }
            }
        }
    }

}
