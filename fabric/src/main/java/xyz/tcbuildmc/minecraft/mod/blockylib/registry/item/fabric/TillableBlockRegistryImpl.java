package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.fabric;

import net.fabricmc.fabric.api.registry.TillableBlockRegistry;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class TillableBlockRegistryImpl {
    public static void register(Block input, Predicate<UseOnContext> usagePredicate, Consumer<UseOnContext> tillingAction) {
        TillableBlockRegistry.register(input, usagePredicate, tillingAction);
    }
}
