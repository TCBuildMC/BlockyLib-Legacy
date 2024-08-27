package xyz.tcbuildmc.minecraft.mod.blockylib.loader.forge;

import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.forgespi.language.IModInfo;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.Environment;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.Loader;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.Mod;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LoaderAbstractImpl {
    private static final Map<String, Mod> mods = new HashMap<>();

    public static Loader getPlatform() {
        return Loader.FORGE;
    }

    public static Environment getEnvironment() {
        return switch (FMLEnvironment.dist) {
            case CLIENT -> Environment.CLIENT;
            case DEDICATED_SERVER -> Environment.SERVER;
        };
    }

    public static boolean isDevelopmentEnvironment() {
        return !FMLEnvironment.production;
    }

    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    public static Path getGameDir() {
        return FMLPaths.GAMEDIR.get();
    }

    public static Mod getMod(String modId) {
        return mods.computeIfAbsent(modId, ForgeModImpl::new);
    }

    private record ForgeModImpl(String modId, IModInfo modInfo) implements Mod {
        private ForgeModImpl(String modId, ModContainer modContainer) {
            this(modId, modContainer.getModInfo());
        }

        private ForgeModImpl(String modId) {
            this(modId, ModList.get().getModContainerById(modId).orElseThrow());
        }

        @Override
        public String getId() {
            return this.modId;
        }

        @Override
        public String getName() {
            return this.modInfo.getDisplayName();
        }

        @Override
        public String getVersion() {
            return this.modInfo.getVersion().toString();
        }
    }
}
