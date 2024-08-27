package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.fabric;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class FuelRegistryImpl {
    public static void register(int tick, ItemLike... items) {
        for (ItemLike item : items) {
            FuelRegistry.INSTANCE.add(item, tick);
        }
    }

    public static int getBurnTick(ItemStack item) {
        return FuelRegistry.INSTANCE.get(item.getItem());
    }
}
