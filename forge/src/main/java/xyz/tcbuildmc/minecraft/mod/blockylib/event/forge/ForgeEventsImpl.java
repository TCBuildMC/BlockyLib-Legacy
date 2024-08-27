package xyz.tcbuildmc.minecraft.mod.blockylib.event.forge;

import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.command.CommandRegistrationEvent;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.registry.CreativeTabModifyEvent;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.villager.forge.TradeRegistryImpl;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.forge.FuelRegistryImpl;

import java.util.ArrayList;

public class ForgeEventsImpl {
    public static void creativeTabModify(BuildCreativeModeTabContentsEvent event) {
        for (CreativeTabModifyEvent ctmEvent : CreativeTabModifyEvent.EVENT) {
            ctmEvent.onModify(event.getTab(), event);
        }
    }

    public static void commandRegister(RegisterCommandsEvent event) {
        for (CommandRegistrationEvent crEvent : CommandRegistrationEvent.EVENT) {
            crEvent.register(event.getDispatcher(), event.getBuildContext(), event.getCommandSelection());
        }
    }

    public static void fuelRegister(FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().isEmpty()) {
            return;
        }

        int tick = FuelRegistryImpl.getFuels().getOrDefault(event.getItemStack().getItem(), -1);

        if (tick <= 0) {
            BlockyLib.LOGGER.error("Failed to register fuel item - burn tick must not be negative or 0.");
            return;
        }

        event.setBurnTime(tick);
    }

    public static void tradeRegister(VillagerTradesEvent event) {
        for (TradeRegistryImpl.Entry entry : TradeRegistryImpl.getVillagerTrades()) {
            if (event.getType() == entry.profession()) {
                event.getTrades().computeIfAbsent(entry.level(), __ -> new ArrayList<>()).addAll(entry.trades());
            }
        }
    }

    public static void wanderingTradeRegister(WandererTradesEvent event) {
        event.getGenericTrades().addAll(TradeRegistryImpl.getWanderingTrades());
        event.getRareTrades().addAll(TradeRegistryImpl.getWanderingRareTrades());
    }
}
