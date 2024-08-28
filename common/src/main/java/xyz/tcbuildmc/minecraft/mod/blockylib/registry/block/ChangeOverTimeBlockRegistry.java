package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;

import java.util.Optional;

public final class ChangeOverTimeBlockRegistry {
    public static void register(Block input, Block output) {
        WeatheringCopper.NEXT_BY_BLOCK.get().put(input, output);
    }

    public static void unregister(Block input) {
        WeatheringCopper.NEXT_BY_BLOCK.get().remove(input);
    }

    public static Optional<Block> getNext(Block input) {
        return Optional.ofNullable(WeatheringCopper.NEXT_BY_BLOCK.get().get(input));
    }
}
