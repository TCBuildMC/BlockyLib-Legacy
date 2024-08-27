package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.forge;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class FlammableBlockRegistryImpl {
    private static final Map<Block, FlammableBlockRegistryImpl.Entry> FLAMMABLE_REGISTRIES = new HashMap<>();

    public static void register(Block block, int burnChance, int spreadSpeed) {
        FLAMMABLE_REGISTRIES.put(block, new FlammableBlockRegistryImpl.Entry(burnChance, spreadSpeed));
    }

    public static void register(TagKey<Block> block, int burnChance, int spreadSpeed) {
        for (Holder<Block> holder : BuiltInRegistries.BLOCK.getTagOrEmpty(block)) {
            register(holder.get(), burnChance, spreadSpeed);
        }
    }

    public static void unregister(Block block) {
        FLAMMABLE_REGISTRIES.remove(block);
    }

    public static void unregister(TagKey<Block> block) {
        for (Holder<Block> holder : BuiltInRegistries.BLOCK.getTagOrEmpty(block)) {
            unregister(holder.get());
        }
    }

    public static Map<Block, FlammableBlockRegistryImpl.Entry> getFlammableRegistries() {
        return FLAMMABLE_REGISTRIES;
    }

    public record Entry(int burnChance, int spreadSpeed) {
        public Entry {}
    }
}
