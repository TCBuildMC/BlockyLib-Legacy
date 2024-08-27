package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.villager;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

public final class TradeRegistry {
    @ExpectPlatform
    public static void register(VillagerProfession profession, int level, VillagerTrades.ItemListing... trades) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void register(boolean rare, VillagerTrades.ItemListing... trades) {
        throw new AssertionError();
    }
}
