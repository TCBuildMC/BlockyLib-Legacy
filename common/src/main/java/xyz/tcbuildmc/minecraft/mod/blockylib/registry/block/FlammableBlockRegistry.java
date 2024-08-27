package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class FlammableBlockRegistry {
    @ExpectPlatform
    public static void register(Block block, int burnChance, int spreadSpeed) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void register(TagKey<Block> block, int burnChance, int spreadSpeed) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void unregister(Block block) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void unregister(TagKey<Block> block) {
        throw new AssertionError();
    }
}
