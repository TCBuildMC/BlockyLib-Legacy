package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.minecart.fabric;

import net.fabricmc.fabric.api.object.builder.v1.entity.MinecartComparatorLogic;
import net.fabricmc.fabric.api.object.builder.v1.entity.MinecartComparatorLogicRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import xyz.tcbuildmc.minecraft.mod.blockylib.mixin.fabric.access.MinecartComparatorLogicRegistryMixin;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.minecart.MinecartComparatorOutputRegistry;

public class MinecartComparatorOutputRegistryImpl {
    public static <T extends AbstractMinecart> void register(EntityType<T> entityType,
                                                             MinecartComparatorOutputRegistry.OutputCalculator<? super T> calculator) {
        MinecartComparatorLogicRegistry.register(entityType, calculator::calculate);
    }

    public static <T extends AbstractMinecart> void unregister(EntityType<T> entityType) {
        MinecartComparatorLogicRegistryMixin.getLogics().remove(entityType);
    }

    public static <T extends AbstractMinecart> MinecartComparatorOutputRegistry.OutputCalculator<? super T> getCalculator(EntityType<?> entityType) {
        MinecartComparatorLogic<AbstractMinecart> logic = MinecartComparatorLogicRegistry.getCustomComparatorLogic(entityType);

        if (logic == null) {
            return null;
        }

        return logic::getComparatorValue;
    }
}
