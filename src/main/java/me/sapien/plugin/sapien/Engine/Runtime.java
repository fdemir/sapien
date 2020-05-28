package me.sapien.plugin.sapien.Engine;
import com.eclipsesource.v8.V8;

public class Runtime {

    public static V8 engine;

    public static V8 getRuntime() {
        return engine;
    }

    public static void init() {
        String tmpPath = Temp.createOnExit();
        engine = V8.createV8Runtime(null, tmpPath);
    }

    public static void terminate() {
        Temp.clear();
    }

}
