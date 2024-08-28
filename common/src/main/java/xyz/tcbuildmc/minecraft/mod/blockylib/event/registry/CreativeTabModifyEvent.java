package xyz.tcbuildmc.minecraft.mod.blockylib.event.registry;

import net.minecraft.world.item.CreativeModeTab;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.Event;

public final class CreativeTabModifyEvent {
    public static final Event<CreativeTabModifyEvent.ModifyAll> MODIFY_ALL = Event.create();

    @FunctionalInterface
    public interface ModifyAll {
        void onModify(CreativeModeTab tab, CreativeModeTab.Output entries);
    }

    // TODO: Modify specified one
    @FunctionalInterface
    public interface Modify {
        void onModify(CreativeModeTab.Output entries);
    }
}
