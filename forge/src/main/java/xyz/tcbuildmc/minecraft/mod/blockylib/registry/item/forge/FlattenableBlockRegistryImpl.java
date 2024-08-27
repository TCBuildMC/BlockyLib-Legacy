package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.forge;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;

public class FlattenableBlockRegistryImpl {
    public static void register(Block input, BlockState output) {
        if (ShovelItem.FLATTENABLES.containsKey(input) ||
                ShovelItem.FLATTENABLES.containsValue(output)) {
            BlockyLib.LOGGER.error("Failed to register flattenable block: {} -> {} - duplicate with another registry pair.", input, output);
            return;
        }

        ShovelItem.FLATTENABLES.put(input, output);
    }
}
