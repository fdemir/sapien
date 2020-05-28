package me.sapien.plugin.sapien.Engine;

import com.eclipsesource.v8.V8;

public class Runtime {

    public V8 engine;

    private final Temp tmp;

    public Runtime(Temp tmp) {
        this.tmp = tmp;
    }

    public V8 getRuntime() {
        return engine;
    }

    public void init() {
        String tmpPath = tmp.createOnExit();
        engine = V8.createV8Runtime(null, tmpPath);
    }

    public void terminate() {
        tmp.clear();
    }

}
