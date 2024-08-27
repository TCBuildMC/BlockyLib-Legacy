package xyz.tcbuildmc.minecraft.mod.blockylib;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.LoaderAbstract;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.RegistryManager;

import java.util.function.Supplier;

public final class BlockyLib {
    public static final String MOD_ID = "blockylib";
    public static final String MOD_NAME = "BlockyLib";
    public static final String MOD_VERSION = LoaderAbstract.getModVersion(MOD_ID);
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        RegistryManager registry = RegistryManager.create(MOD_ID);

        Supplier<Item> exampleItem = registry.register(BuiltInRegistries.ITEM, "example_item", new Item(new Item.Properties()));
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
    }
}
