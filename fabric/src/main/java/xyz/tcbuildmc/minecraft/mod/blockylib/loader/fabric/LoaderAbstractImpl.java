package xyz.tcbuildmc.minecraft.mod.blockylib.loader.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.Environment;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.Loader;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.Mod;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LoaderAbstractImpl {
    private static final Map<String, Mod> mods = new HashMap<>();

    public static Loader getPlatform() {
        return Loader.FABRIC;
    }

    public static Environment getEnvironment() {
        return switch (FabricLoader.getInstance().getEnvironmentType()) {
            case CLIENT -> Environment.CLIENT;
            case SERVER -> Environment.SERVER;
        };
    }

    public static boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    public static Path getGameDir() {
        return FabricLoader.getInstance().getGameDir();
    }

    public static Mod getMod(String modId) {
        return mods.computeIfAbsent(modId, FabricModImpl::new);
    }

    private record FabricModImpl(String modId, ModMetadata metadata) implements Mod {
        private FabricModImpl(String modId, ModContainer modContainer) {
            this(modId, modContainer.getMetadata());
        }

        private FabricModImpl(String modId) {
            this(modId, FabricLoader.getInstance().getModContainer(modId).orElseThrow());
        }

        @Override
        public String getId() {
            return this.modId;
        }

        @Override
        public String getName() {
            return this.metadata.getName();
        }

        @Override
        public String getVersion() {
            return this.metadata.getVersion().getFriendlyString();
        }
    }
}
