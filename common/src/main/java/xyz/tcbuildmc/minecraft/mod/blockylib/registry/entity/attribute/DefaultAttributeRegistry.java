package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.attribute;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;

import java.util.Optional;

public final class DefaultAttributeRegistry {
    public static void register(EntityType<? extends LivingEntity> type, AttributeSupplier container) {
        DefaultAttributes.SUPPLIERS.put(type, container);
    }

    public static void unregister(EntityType<? extends LivingEntity> type) {
        DefaultAttributes.SUPPLIERS.remove(type);
    }

    public static Optional<AttributeSupplier> getSupplier(EntityType<? extends LivingEntity> type) {
        return Optional.ofNullable(DefaultAttributes.SUPPLIERS.get(type));
    }
}
