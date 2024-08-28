package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.villager;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.behavior.WorkAtComposter;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class VillagerInteractionRegistry {
    public static void registerItemWanted(Item item) {
        if (Villager.WANTED_ITEMS instanceof ImmutableSet<Item>) {
            Villager.WANTED_ITEMS = new HashSet<>(Villager.WANTED_ITEMS);
        }

        Villager.WANTED_ITEMS.add(item);
    }

    public static void unregisterItemWanted(Item item) {
        if (Villager.WANTED_ITEMS instanceof ImmutableSet<Item>) {
            Villager.WANTED_ITEMS = new HashSet<>(Villager.WANTED_ITEMS);
        }

        Villager.WANTED_ITEMS.remove(item);
    }

    public static void registerFood(Item item, int value) {
        if (Villager.FOOD_POINTS instanceof ImmutableMap<Item, Integer>) {
            Villager.FOOD_POINTS = new HashMap<>(Villager.FOOD_POINTS);
        }

        Villager.FOOD_POINTS.put(item, value);
    }

    public static void unregisterFood(Item item) {
        if (Villager.FOOD_POINTS instanceof ImmutableMap<Item, Integer>) {
            Villager.FOOD_POINTS = new HashMap<>(Villager.FOOD_POINTS);
        }

        Villager.FOOD_POINTS.remove(item);
    }

    public static void registerSeed(Item item) { // That Farmer Use At Composter
        if (WorkAtComposter.COMPOSTABLE_ITEMS instanceof ImmutableList<Item>) {
            WorkAtComposter.COMPOSTABLE_ITEMS = new ArrayList<>(WorkAtComposter.COMPOSTABLE_ITEMS);
        }

        WorkAtComposter.COMPOSTABLE_ITEMS.add(item);
    }

    public static void unregisterSeed(Item item) {
        if (WorkAtComposter.COMPOSTABLE_ITEMS instanceof ImmutableList<Item>) {
            WorkAtComposter.COMPOSTABLE_ITEMS = new ArrayList<>(WorkAtComposter.COMPOSTABLE_ITEMS);
        }

        WorkAtComposter.COMPOSTABLE_ITEMS.remove(item);
    }
}
