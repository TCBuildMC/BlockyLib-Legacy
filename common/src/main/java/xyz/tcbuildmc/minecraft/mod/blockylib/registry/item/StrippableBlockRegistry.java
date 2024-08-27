package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.Block;

public final class StrippableBlockRegistry {
    @ExpectPlatform
    public static void register(Block input, Block output) {
        throw new AssertionError();
    }
}
