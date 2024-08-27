package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.fabric;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.world.level.block.Block;

public class StrippableBlockRegistryImpl {
    public static void register(Block input, Block output) {
        StrippableBlockRegistry.register(input, output);
    }
}
