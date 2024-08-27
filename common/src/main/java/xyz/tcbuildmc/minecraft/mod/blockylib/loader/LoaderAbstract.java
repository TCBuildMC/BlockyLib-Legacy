package xyz.tcbuildmc.minecraft.mod.blockylib.loader;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public final class LoaderAbstract {
    @ExpectPlatform
    public static Loader getPlatform() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Environment getEnvironment() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isDevelopmentEnvironment() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isModLoaded(String modId) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Path getGameDir() {
        throw new AssertionError();
    }

    public static Path getConfigDir() {
        return getGameDir().resolve("config");
    }

    public static Path getModsFir() {
        return getGameDir().resolve("mods");
    }

    @ExpectPlatform
    public static Mod getMod(String modId) {
        throw new AssertionError();
    }

    public static String getModVersion(String modId) {
        return getMod(modId).getVersion();
    }
}
