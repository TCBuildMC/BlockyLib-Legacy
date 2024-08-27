package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.villager.fabric;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.Collections;

public class TradeRegistryImpl {
    public static void register(VillagerProfession profession, int level, VillagerTrades.ItemListing... trades) {
        TradeOfferHelper.registerVillagerOffers(profession, level, factories -> Collections.addAll(factories, trades));
    }

    public static void register(boolean rare, VillagerTrades.ItemListing... trades) {
        TradeOfferHelper.registerWanderingTraderOffers(rare ? 2 : 1, factory -> Collections.addAll(factory, trades));
    }
}
