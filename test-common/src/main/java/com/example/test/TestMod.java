package com.example.test;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.RegistryManager;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.CompostingRegistry;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.FlammableBlockRegistry;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.FuelRegistry;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.item.tool.FlattenableBlockRegistry;

import java.util.function.Supplier;

public final class TestMod {
    @SuppressWarnings("UnreachableCode")
    public static void init() {
        RegistryManager manager = RegistryManager.getOrCreate("test-mod");

        Supplier<Block> example_block = manager.block("example", BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK));
        Supplier<Item> example_item = manager.item("example", new BlockItem(example_block.get(), new Item.Properties()));
        Supplier<CreativeModeTab> test = manager.tab("test", example_item.get(), entries -> entries.accept(example_item.get()));

        manager.register();

        FuelRegistry.register(example_item.get(), 30);
        CompostingRegistry.register(example_item.get(), 0.3f);
        FlammableBlockRegistry.register(example_block.get(), 30, 60);
        FlattenableBlockRegistry.register(example_block.get(), Blocks.DIRT_PATH.defaultBlockState());
    }
}
