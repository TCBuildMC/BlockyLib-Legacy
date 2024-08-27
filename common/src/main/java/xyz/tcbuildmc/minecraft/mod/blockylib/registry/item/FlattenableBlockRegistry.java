package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public final class FlattenableBlockRegistry {
    @ExpectPlatform
    public static void register(Block input, BlockState output) {
        throw new AssertionError();
    }
}
