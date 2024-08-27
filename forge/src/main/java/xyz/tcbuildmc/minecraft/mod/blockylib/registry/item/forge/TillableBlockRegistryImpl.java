package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.forge;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class TillableBlockRegistryImpl {
    public static void register(Block input, Predicate<UseOnContext> usagePredicate, Consumer<UseOnContext> tillingAction) {
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> output = Pair.of(usagePredicate, tillingAction);

        if (HoeItem.TILLABLES.containsKey(input) ||
                HoeItem.TILLABLES.containsValue(output)) {
            BlockyLib.LOGGER.error("Failed to register tillable block: {} -> {} - duplicate with another registry pair.", input, output);
            return;
        }

        HoeItem.TILLABLES.put(input, output);
    }
}
