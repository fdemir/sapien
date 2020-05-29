package me.sapien.plugin.sapien.Functions;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8Thread;
import me.sapien.plugin.sapien.IFunction;

public class Delay implements IFunction {

    @Override
    public void invoke(final V8Object receiver, final V8Array parameters) {
        if (parameters.length() == 1) {
            Object arg1 = parameters.get(0);

            try {
                V8Thread.sleep(Long.parseLong(arg1.toString()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (arg1 instanceof Releasable) {
                ((Releasable) arg1).release();
            }
        }

    }

    @Override
    public String getName() {
        return "setInterval";
    }

}
