package me.sapien.plugin.sapien.Functions;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import me.sapien.plugin.sapien.IFunction;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Ban implements IFunction {

    /**
     * Adds a ban to the this list. If a previous ban exists, this will
     * update the previous entry.
     * @param receiver
     * @param parameters
     */
    @Override
    public void invoke(final V8Object receiver, final V8Array parameters) {
        if (parameters.length() > 0) {
            Object arg1 = parameters.get(0);

            Bukkit.getBanList(BanList.Type.NAME).addBan(arg1.toString(),"Reason xd", null, null);
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
