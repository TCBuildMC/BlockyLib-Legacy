package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.fabric;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class FlammableBlockRegistryImpl {
    public static void register(Block block, int burnChance, int spreadSpeed) {
        FlammableBlockRegistry.getDefaultInstance().add(block, burnChance, spreadSpeed);
    }

    public static void register(TagKey<Block> block, int burnChance, int spreadSpeed) {
        FlammableBlockRegistry.getDefaultInstance().add(block, burnChance, spreadSpeed);
    }

    public static void unregister(Block block) {
        FlammableBlockRegistry.getDefaultInstance().clear(block);
    }

    public static void unregister(TagKey<Block> block) {
        FlammableBlockRegistry.getDefaultInstance().clear(block);
    }
}
