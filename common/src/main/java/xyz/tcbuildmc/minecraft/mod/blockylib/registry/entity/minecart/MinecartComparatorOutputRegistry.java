package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.minecart;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public final class MinecartComparatorOutputRegistry {
    @ExpectPlatform
    public static <T extends AbstractMinecart> void register(EntityType<T> entityType,
                                                             MinecartComparatorOutputRegistry.OutputCalculator<? super T> calculator) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends AbstractMinecart> void unregister(EntityType<T> entityType) {
        throw new AssertionError();
    }

    @Nullable
    @ExpectPlatform
    public static <T extends AbstractMinecart> MinecartComparatorOutputRegistry.OutputCalculator<? super T> getCalculator(EntityType<?> entityType) {
        throw new AssertionError();
    }

    @FunctionalInterface
    public interface OutputCalculator<T extends AbstractMinecart> {
        int calculate(T minecart, BlockState state, BlockPos pos);
    }
}
