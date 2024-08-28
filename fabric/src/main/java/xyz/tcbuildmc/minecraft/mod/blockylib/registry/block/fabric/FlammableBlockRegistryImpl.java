package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.fabric;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.Block;

public class FlammableBlockRegistryImpl {
    public static void register(Block block, int burnChance, int spreadSpeed) {
        FlammableBlockRegistry.getDefaultInstance().add(block, burnChance, spreadSpeed);
    }

    public static void unregister(Block block) {
        FlammableBlockRegistry.getDefaultInstance().clear(block);
    }

    public static xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.FlammableBlockRegistry.Entry getEntry(Block block) {
        FlammableBlockRegistry.Entry entry = FlammableBlockRegistry.getDefaultInstance().get(block);
        return new xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.FlammableBlockRegistry.Entry(entry.getBurnChance(),
                entry.getSpreadChance());
    }
}
