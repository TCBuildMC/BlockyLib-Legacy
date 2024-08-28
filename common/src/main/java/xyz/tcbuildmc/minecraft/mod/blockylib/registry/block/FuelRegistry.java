package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.ApiStatus;
import xyz.tcbuildmc.minecraft.mod.blockylib.util.TagKeyUtils;

public final class FuelRegistry {
    @ExpectPlatform
    public static void register(ItemLike item, int tick) {
        throw new AssertionError();
    }

    @ApiStatus.Experimental
    public static void register(TagKey<Item> tag, int tick) {
        TagKeyUtils.forEachEntry(BuiltInRegistries.ITEM, tag, item -> register(item, tick));
    }

    @ExpectPlatform
    public static int getBurnTick(ItemStack item) {
        throw new AssertionError();
    }

    @ApiStatus.Experimental
    @ExpectPlatform
    public static void unregister(ItemLike input) {
        throw new AssertionError();
    }

    @ApiStatus.Experimental
    public static void unregister(TagKey<Item> tag) {
        TagKeyUtils.forEachEntry(BuiltInRegistries.ITEM, tag, FuelRegistry::unregister);
    }
}
