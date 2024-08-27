package xyz.tcbuildmc.minecraft.mod.blockylib.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.command.CommandRegistrationEvent;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.registry.CreativeTabModifyEvent;

public class BlockyLibFabric implements ModInitializer, ClientModInitializer {
    @Override
    public void onInitialize() {
        BlockyLib.init();

        ItemGroupEvents.MODIFY_ENTRIES_ALL.register((group, entries) -> {
            for (CreativeTabModifyEvent event : CreativeTabModifyEvent.EVENT) {
                event.onModify(group, entries);
            }
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            for (CommandRegistrationEvent event : CommandRegistrationEvent.EVENT) {
                event.register(dispatcher, registryAccess, environment);
            }
        });
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        BlockyLib.initClient();
    }
}
