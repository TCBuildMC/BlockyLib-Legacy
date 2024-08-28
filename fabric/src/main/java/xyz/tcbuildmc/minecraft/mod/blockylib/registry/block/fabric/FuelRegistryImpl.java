package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.fabric;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class FuelRegistryImpl {
    public static void register(ItemLike item, int tick) {
        FuelRegistry.INSTANCE.add(item, tick);
    }

    public static int getBurnTick(ItemStack item) {
        return FuelRegistry.INSTANCE.get(item.getItem());
    }

    public static void unregister(ItemLike input) {
        FuelRegistry.INSTANCE.remove(input);
    }
}
