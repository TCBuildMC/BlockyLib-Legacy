package xyz.tcbuildmc.minecraft.mod.blockylib.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.fabric.FabricEventsImpl;

public class BlockyLibFabric implements ModInitializer, ClientModInitializer {
    @Override
    public void onInitialize() {
        BlockyLib.init();

        FabricEventsImpl.register();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        BlockyLib.initClient();
    }
}
