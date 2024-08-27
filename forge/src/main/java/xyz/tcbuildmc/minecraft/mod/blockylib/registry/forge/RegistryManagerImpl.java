package xyz.tcbuildmc.minecraft.mod.blockylib.registry.forge;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.registries.RegisterEvent;
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
        MinecraftForge.EVENT_BUS.addListener(e -> {
            if (e instanceof RegisterEvent registerEvent) {
                this.forgeRegister(registerEvent);
            }
        });
    }

    private void forgeRegister(RegisterEvent event) {
        for (Map.Entry<Registry<?>, List<RegistryHolder<?>>> entry : this.holders.entrySet()) {
            this.forgeRegister(event, entry.getKey(), entry.getValue());
        }
    }

    private <T> void forgeRegister(RegisterEvent event, Registry<? super T> registry, List<RegistryHolder<?>> holderList) {
        event.register(registry.key(), helper -> {
            for (RegistryHolder<?> holder : holderList) {
                ResourceLocation id = this.of(holder.getId());

                try {
                    helper.register(id, (T) holder.get());
                } catch (Exception e) {
                    BlockyLib.LOGGER.error("Failed to register {}.", id.toString(), e);
                }
            }
        });
    }
}
