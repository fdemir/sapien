package me.sapien.plugin.sapien.Engine;

import me.sapien.plugin.sapien.Sapien;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Temp {

    private String tmpPath = Sapien.getInstance().getDataFolder().getAbsolutePath() + "/tmp";;

    /**
     * @return The path of generated temp directory.
     */
    public String createOnExit() {
        File tmp = new File(tmpPath);

        if(!tmp.exists()) {
            tmp.mkdir();
        }

        String path = tmpPath + "/" + UUID.randomUUID();
        new File(path).mkdir();
        return path;
    }

    public void clear() {
        try {
            FileUtils.cleanDirectory(new File(tmpPath));
        } catch (IOException e) {
            System.out.println("Temp directory could not delete:" + e);
        }
    }

}
