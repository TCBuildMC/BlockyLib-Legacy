package xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.alchemy;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.crafting.Ingredient;

public final class PotionBrewingRecipeRegistry {
    public static void registerItem(Item input, Ingredient ingredient, Item output) {
        if (input instanceof PotionItem && output instanceof PotionItem) {
            PotionBrewing.CONTAINER_MIXES.add(new PotionBrewing.Mix<>(input, ingredient, output));
        }
    }

    public static void registerPotion(Potion input, Ingredient ingredient, Potion output) {
        PotionBrewing.POTION_MIXES.add(new PotionBrewing.Mix<>(input, ingredient, output));
    }

    public static void unregisterItem(Item input, Ingredient ingredient, Item output) {
        if (input instanceof PotionItem && output instanceof PotionItem) {
            PotionBrewing.CONTAINER_MIXES.remove(new PotionBrewing.Mix<>(input, ingredient, output));
        }
    }

    public static void unregisterPotion(Potion input, Ingredient ingredient, Potion output) {
        PotionBrewing.POTION_MIXES.remove(new PotionBrewing.Mix<>(input, ingredient, output));
    }
}
