package xyz.tcbuildmc.minecraft.mod.blockylib.registry.fabric;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import xyz.tcbuildmc.minecraft.mod.blockylib.BlockyLib;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.RegistryHolder;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.RegistryManager;

import java.util.List;
import java.util.Map;

public class RegistryManagerImpl extends RegistryManager {
    private RegistryManagerImpl(String modId) {
        super(modId);
    }

    public static RegistryManager create(String modId) {
        return new RegistryManagerImpl(modId);
    }

    @Override
    public void register() {
        for (Map.Entry<Registry<?>, List<RegistryHolder<?>>> entry : this.holders.entrySet()) {
            this.fabricRegister(entry.getKey(), entry.getValue());
        }
    }

    private <T> void fabricRegister(Registry<? super T> registry, List<RegistryHolder<?>> holderList) {
        for (RegistryHolder<?> holder : holderList) {
            ResourceLocation id = this.of(holder.getId());

            try {
                Registry.register(registry, id, (T) holder.get());
            } catch (Exception e) {
                BlockyLib.LOGGER.error("Failed to register {}.", id.toString(), e);
            }
        }
    }
}
