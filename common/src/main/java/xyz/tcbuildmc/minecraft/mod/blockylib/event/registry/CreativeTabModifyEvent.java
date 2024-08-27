package xyz.tcbuildmc.minecraft.mod.blockylib.event.registry;

import net.minecraft.world.item.CreativeModeTab;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.Event;

@FunctionalInterface
public interface CreativeTabModifyEvent {
    Event<CreativeTabModifyEvent> EVENT = Event.create();

    void onModify(CreativeModeTab tab, CreativeModeTab.Output entries);
}
