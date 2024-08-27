package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.villager.forge;

import net.minecraft.Util;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TradeRegistryImpl {
    private static final List<TradeRegistryImpl.Entry> VILLAGER_TRADES = new ArrayList<>();
    private static final List<VillagerTrades.ItemListing> WANDERING_TRADES = new ArrayList<>();
    private static final List<VillagerTrades.ItemListing> WANDERING_RARE_TRADES = new ArrayList<>();

    public static void register(VillagerProfession profession, int level, VillagerTrades.ItemListing... trades) {
        VILLAGER_TRADES.add(new TradeRegistryImpl.Entry(profession,
                level,
                Util.make(new ArrayList<>(), list -> Collections.addAll(list, trades))));
    }

    public static void register(boolean rare, VillagerTrades.ItemListing... trades) {
        if (rare) {
            Collections.addAll(WANDERING_RARE_TRADES, trades);
        } else {
            Collections.addAll(WANDERING_TRADES, trades);
        }
    }

    public static List<TradeRegistryImpl.Entry> getVillagerTrades() {
        return VILLAGER_TRADES;
    }

    public static List<VillagerTrades.ItemListing> getWanderingTrades() {
        return WANDERING_TRADES;
    }

    public static List<VillagerTrades.ItemListing> getWanderingRareTrades() {
        return WANDERING_RARE_TRADES;
    }

    public record Entry(VillagerProfession profession, int level, List<VillagerTrades.ItemListing> trades) {
        public Entry {}
    }
}
