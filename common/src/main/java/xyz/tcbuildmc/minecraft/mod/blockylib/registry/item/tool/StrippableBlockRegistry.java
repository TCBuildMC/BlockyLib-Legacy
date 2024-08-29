package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.tool;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Optional;

public final class StrippableBlockRegistry {
    public static void register(Block input, Block output) {
        if (AxeItem.STRIPPABLES instanceof ImmutableMap<Block, Block>) {
            AxeItem.STRIPPABLES = new HashMap<>(AxeItem.STRIPPABLES);
        }

        AxeItem.STRIPPABLES.put(input, output);
    }

    public static void unregister(Block input) {
        if (AxeItem.STRIPPABLES instanceof ImmutableMap<Block, Block>) {
            AxeItem.STRIPPABLES = new HashMap<>(AxeItem.STRIPPABLES);
        }

        AxeItem.STRIPPABLES.remove(input);
    }

    public static Optional<Block> getOutput(Block input) {
        return Optional.ofNullable(AxeItem.STRIPPABLES.get(input));
    }
}
