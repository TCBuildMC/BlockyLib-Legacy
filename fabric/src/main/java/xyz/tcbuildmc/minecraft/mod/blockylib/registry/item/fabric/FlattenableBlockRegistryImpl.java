package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.fabric;

import net.fabricmc.fabric.api.registry.FlattenableBlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class FlattenableBlockRegistryImpl {
    public static void register(Block input, BlockState output) {
        FlattenableBlockRegistry.register(input, output);
    }
}
