package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.minecart.forge;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.minecart.MinecartComparatorOutputRegistry;

import java.util.HashMap;
import java.util.Map;

public class MinecartComparatorOutputRegistryImpl {
    private static final Map<EntityType<?>, MinecartComparatorOutputRegistry.OutputCalculator<?>> CALCULATORS = new HashMap<>();

    public static <T extends AbstractMinecart> void register(EntityType<T> entityType,
                                                             MinecartComparatorOutputRegistry.OutputCalculator<? super T> calculator) {
        CALCULATORS.put(entityType, calculator);
    }

    public static <T extends AbstractMinecart> void unregister(EntityType<T> entityType) {
        CALCULATORS.remove(entityType);
    }

    public static <T extends AbstractMinecart> MinecartComparatorOutputRegistry.OutputCalculator<? super T> getCalculator(EntityType<?> entityType) {
        return (MinecartComparatorOutputRegistry.OutputCalculator<? super T>) CALCULATORS.get(entityType);
    }
}
