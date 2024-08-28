package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public final class FlattenableBlockRegistry {
    public static void register(Block input, BlockState output) {
        ShovelItem.FLATTENABLES.put(input, output);
    }

    public static void unregister(Block input) {
        ShovelItem.FLATTENABLES.remove(input);
    }

    public static Optional<BlockState> getOutput(Block input) {
        return Optional.ofNullable(ShovelItem.FLATTENABLES.get(input));
    }
}
