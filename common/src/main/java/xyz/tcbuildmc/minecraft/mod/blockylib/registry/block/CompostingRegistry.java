package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import xyz.tcbuildmc.minecraft.mod.blockylib.util.TagKeyUtils;

public final class CompostingRegistry {
    public static void register(ItemLike item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item, chance);
    }

    public static void register(TagKey<Item> tag, float chance) {
        TagKeyUtils.forEachEntry(BuiltInRegistries.ITEM, tag, item -> register(item, chance));
    }

    public static void unregister(ItemLike item) {
        ComposterBlock.COMPOSTABLES.removeFloat(item);
    }

    public static void unregister(TagKey<Item> tag) {
        TagKeyUtils.forEachEntry(BuiltInRegistries.ITEM, tag, CompostingRegistry::unregister);
    }

    public static float getChance(ItemLike item) {
        return ComposterBlock.COMPOSTABLES.getOrDefault(item, 0.0f);
    }
}
