package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.forge;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ForgeHooks;

import java.util.HashMap;
import java.util.Map;

public class FuelRegistryImpl {
    private static final Map<ItemLike, Integer> FUELS = new HashMap<>();

    public static void register(ItemLike item, int tick) {
        FUELS.put(item, tick);
    }

    public static int getBurnTick(ItemStack item) {
        return ForgeHooks.getBurnTime(item, null);
    }

    public static void unregister(ItemLike input) {
        FUELS.remove(input);
    }

    public static Map<ItemLike, Integer> getFuels() {
        return FUELS;
    }
}
