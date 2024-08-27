package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.forge;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ForgeHooks;
import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;

import java.util.HashMap;
import java.util.Map;

public class FuelRegistryImpl {
    private static final Map<ItemLike, Integer> FUELS = new HashMap<>();

    public static void register(int tick, ItemLike... items) {
        if (tick <= 0) {
            BlockyLib.LOGGER.error("Failed to register fuel item - burn tick must not be negative or 0.");
            return;
        }

        for (ItemLike item : items) {
            if (FUELS.containsKey(item)) {
                BlockyLib.LOGGER.error("Failed to register fuel item - duplicate with another entry.");
                continue;
            }

            FUELS.put(item, tick);
        }
    }

    public static int getBurnTick(ItemStack item) {
        return ForgeHooks.getBurnTime(item, null);
    }

    public static Map<ItemLike, Integer> getFuels() {
        return FUELS;
    }
}
