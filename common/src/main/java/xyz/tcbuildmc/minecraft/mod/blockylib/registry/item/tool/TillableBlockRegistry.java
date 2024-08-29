package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.tool;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class TillableBlockRegistry {
    public static void register(Block input, Predicate<UseOnContext> usagePredicate, Consumer<UseOnContext> tillingAction) {
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> output = Pair.of(usagePredicate, tillingAction);
        HoeItem.TILLABLES.put(input, output);
    }

    public static void register(Block input, Predicate<UseOnContext> usagePredicate, BlockState tilled) {
        register(input, usagePredicate, HoeItem.changeIntoState(tilled));
    }

    public static void register(Block input, Predicate<UseOnContext> usagePredicate, BlockState tilled, ItemLike droppedItem) {
        register(input, usagePredicate, HoeItem.changeIntoStateAndDropItem(tilled, droppedItem));
    }

    public static void unregister(Block input) {
        HoeItem.TILLABLES.remove(input);
    }

    public static Optional<Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> getTillingAction(Block input) {
        return Optional.ofNullable(HoeItem.TILLABLES.get(input));
    }
}
