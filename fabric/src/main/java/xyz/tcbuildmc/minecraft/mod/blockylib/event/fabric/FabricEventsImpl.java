package xyz.tcbuildmc.minecraft.mod.blockylib.event.fabric;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.command.CommandRegistrationEvent;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.registry.CreativeTabModifyEvent;

public class FabricEventsImpl {
    public static void register() {
        ItemGroupEvents.MODIFY_ENTRIES_ALL.register((group, entries) -> {
            for (CreativeTabModifyEvent.ModifyAll event : CreativeTabModifyEvent.MODIFY_ALL) {
                event.onModify(group, entries);
            }
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            for (CommandRegistrationEvent event : CommandRegistrationEvent.EVENT) {
                event.register(dispatcher, registryAccess, environment);
            }
        });
    }
}
