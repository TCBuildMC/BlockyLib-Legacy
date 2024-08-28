package xyz.tcbuildmc.minecraft.mod.blockylib.forge;

import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.forge.ForgeEventsImpl;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.LoaderAbstract;

public class BlockyLibForge {
    public BlockyLibForge() {
        BlockyLib.init();
        ForgeEventsImpl.register();

        if (LoaderAbstract.getEnvironment().isClient()) {
            BlockyLib.initClient();
        }
    }
}
