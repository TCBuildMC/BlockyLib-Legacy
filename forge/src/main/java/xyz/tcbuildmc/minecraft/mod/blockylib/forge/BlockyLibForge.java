package xyz.tcbuildmc.minecraft.mod.blockylib.forge;

import net.minecraftforge.common.MinecraftForge;
import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.forge.ForgeEventsImpl;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.LoaderAbstract;

public class BlockyLibForge {
    public BlockyLibForge() {
        BlockyLib.init();
        MinecraftForge.EVENT_BUS.addListener(ForgeEventsImpl::creativeTabModify);
        MinecraftForge.EVENT_BUS.addListener(ForgeEventsImpl::commandRegister);
        MinecraftForge.EVENT_BUS.addListener(ForgeEventsImpl::fuelRegister);
        MinecraftForge.EVENT_BUS.addListener(ForgeEventsImpl::tradeRegister);
        MinecraftForge.EVENT_BUS.addListener(ForgeEventsImpl::wanderingTradeRegister);

        if (LoaderAbstract.getEnvironment().isClient()) {
            BlockyLib.initClient();
        }
    }
}
