package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import xyz.tcbuildmc.minecraft.mod.blockylib.util.TagKeyUtils;

public final class FlammableBlockRegistry {
    @ExpectPlatform
    public static void register(Block block, int burnChance, int spreadSpeed) {
        throw new AssertionError();
    }

    public static void register(TagKey<Block> tag, int burnChance, int spreadSpeed) {
        TagKeyUtils.forEachEntry(BuiltInRegistries.BLOCK, tag, block -> register(block, burnChance, spreadSpeed));
    }

    @ExpectPlatform
    public static void unregister(Block block) {
        throw new AssertionError();
    }

    public static void unregister(TagKey<Block> tag) {
        TagKeyUtils.forEachEntry(BuiltInRegistries.BLOCK, tag, FlammableBlockRegistry::unregister);
    }

    @ExpectPlatform
    public static Entry getEntry(Block block) {
        throw new AssertionError();
    }

    public record Entry(int burnChance, int spreadSpeed) {
        public Entry {}
    }
}
