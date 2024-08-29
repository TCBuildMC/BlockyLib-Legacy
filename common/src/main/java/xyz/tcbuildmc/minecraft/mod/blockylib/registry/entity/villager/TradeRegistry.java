package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.villager;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.List;

public final class TradeRegistry {
    @ExpectPlatform
    public static void register(VillagerProfession profession, int level, VillagerTrades.ItemListing... trades) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void register(boolean rare, VillagerTrades.ItemListing... trades) {
        throw new AssertionError();
    }

    public static void unregister(VillagerProfession profession, int level, VillagerTrades.ItemListing... trades) {
        throw new AssertionError();
    }

    public static void unregister(boolean rare, VillagerTrades.ItemListing... trades) {
        throw new AssertionError();
    }

    public static List<VillagerTrades.ItemListing> getTrades(VillagerProfession profession, int level) {
        throw new AssertionError();
    }

    public static List<VillagerTrades.ItemListing> getTrades(boolean rare) {
        throw new AssertionError();
    }
}
