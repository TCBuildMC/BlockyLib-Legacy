package xyz.tcbuildmc.minecraft.mod.blockylib.mixin.fabric.access;

import net.fabricmc.fabric.api.object.builder.v1.entity.MinecartComparatorLogic;
import net.fabricmc.fabric.api.object.builder.v1.entity.MinecartComparatorLogicRegistry;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(value = MinecartComparatorLogicRegistry.class, remap = false)
public interface MinecartComparatorLogicRegistryMixin {
    @Accessor(value = "LOGICS", remap = false)
    static Map<EntityType<?>, MinecartComparatorLogic<?>> getLogics() {
        throw new AssertionError();
    }
}
