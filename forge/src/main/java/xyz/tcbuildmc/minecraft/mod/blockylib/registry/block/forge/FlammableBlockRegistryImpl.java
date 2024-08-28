package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.forge;

import net.minecraft.world.level.block.Block;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.FlammableBlockRegistry;

import java.util.HashMap;
import java.util.Map;

public class FlammableBlockRegistryImpl {
    private static final Map<Block, FlammableBlockRegistry.Entry> FLAMMABLE_REGISTRIES = new HashMap<>();

    public static void register(Block block, int burnChance, int spreadSpeed) {
        FLAMMABLE_REGISTRIES.put(block, new FlammableBlockRegistry.Entry(burnChance, spreadSpeed));
    }

    public static void unregister(Block block) {
        FLAMMABLE_REGISTRIES.remove(block);
    }

    public static FlammableBlockRegistry.Entry getEntry(Block block) {
        return FLAMMABLE_REGISTRIES.get(block);
    }

    public static Map<Block, FlammableBlockRegistry.Entry> getFlammableRegistries() {
        return FLAMMABLE_REGISTRIES;
    }
}
