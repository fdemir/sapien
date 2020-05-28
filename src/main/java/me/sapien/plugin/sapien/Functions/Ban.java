package me.sapien.plugin.sapien.Functions;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import me.sapien.plugin.sapien.IFunction;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Ban implements IFunction {

    @Override
    public void invoke(final V8Object receiver, final V8Array parameters) {
        if (parameters.length() > 0) {
            Object arg1 = parameters.get(0);

            if (arg1 instanceof Releasable) {
                ((Releasable) arg1).release();
            }
        }
    }

    @Override
    public String getName() {
        return "broadcast";
    }


}
