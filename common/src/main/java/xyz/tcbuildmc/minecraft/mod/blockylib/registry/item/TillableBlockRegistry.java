package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;
import java.util.function.Predicate;

public final class TillableBlockRegistry {
    @ExpectPlatform
    public static void register(Block input, Predicate<UseOnContext> usagePredicate, Consumer<UseOnContext> tillingAction) {
        throw new AssertionError();
    }

    public static void register(Block input, Predicate<UseOnContext> usagePredicate, BlockState tilled) {
        register(input, usagePredicate, HoeItem.changeIntoState(tilled));
    }

    public static void register(Block input, Predicate<UseOnContext> usagePredicate, BlockState tilled, ItemLike droppedItem) {
        register(input, usagePredicate, HoeItem.changeIntoStateAndDropItem(tilled, droppedItem));
    }
}
