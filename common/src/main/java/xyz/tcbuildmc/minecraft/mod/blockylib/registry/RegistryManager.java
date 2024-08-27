package xyz.tcbuildmc.minecraft.mod.blockylib.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.jetbrains.annotations.ApiStatus;

import java.util.HashMap;
import java.util.Map;

public abstract class RegistryManager extends AbstractRegistryManager {
    private static final Map<String, RegistryManager> managers = new HashMap<>();

    protected RegistryManager(String modId) {
        super(modId);
    }

    public static RegistryManager getOrCreate(String modId) {
        return managers.computeIfAbsent(modId, RegistryManager::create);
    }

    @ApiStatus.Internal
    @ExpectPlatform
    public static RegistryManager create(String modId) {
        throw new AssertionError();
    }
}
