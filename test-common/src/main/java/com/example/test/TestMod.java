package com.example.test;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.RegistryManager;

import java.util.function.Supplier;

public final class TestMod {
    public static void init() {
        RegistryManager manager = RegistryManager.getOrCreate("test-mod");

        Supplier<Item> example = manager.item("example", new Item.Properties());

        Supplier<CreativeModeTab> test = manager.tab("test", example.get(), entries -> entries.accept(example.get()));

        manager.register();
    }
}
