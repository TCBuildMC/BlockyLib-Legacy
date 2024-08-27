package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.forge;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;

import java.util.HashMap;

public class StrippableBlockRegistryImpl {
    public static void register(Block input, Block output) {
        if (AxeItem.STRIPPABLES instanceof ImmutableMap<Block, Block>) {
            AxeItem.STRIPPABLES = new HashMap<>(AxeItem.STRIPPABLES);
        }

        if (!input.defaultBlockState().hasProperty(RotatedPillarBlock.AXIS) ||
                !output.defaultBlockState().hasProperty(RotatedPillarBlock.AXIS)) {
            BlockyLib.LOGGER.error("Failed to register strippable block: {} -> {} - miss(es) the AXIS property.", input, output);
            return;
        }

        AxeItem.STRIPPABLES.put(input, output);
    }
}
