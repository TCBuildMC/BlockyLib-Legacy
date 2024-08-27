package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public final class FuelRegistry {
    @ExpectPlatform
    public static void register(int tick, ItemLike... items) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static int getBurnTick(ItemStack item) {
        throw new AssertionError();
    }
}
