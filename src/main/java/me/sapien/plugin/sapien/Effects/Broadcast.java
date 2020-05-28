package me.sapien.plugin.sapien.Effects;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class Broadcast implements JavaVoidCallback {

    public void invoke(final V8Object receiver, final V8Array parameters) {
        if (parameters.length() > 0) {
            Object arg1 = parameters.get(0);
            System.out.println(arg1);
            if (arg1 instanceof Releasable) {
                ((Releasable) arg1).release();
            }
        }
    }

}
