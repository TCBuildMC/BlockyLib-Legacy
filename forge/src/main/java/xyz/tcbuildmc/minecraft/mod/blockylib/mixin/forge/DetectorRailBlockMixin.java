package xyz.tcbuildmc.minecraft.mod.blockylib.mixin.forge;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DetectorRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.minecart.forge.MinecartComparatorOutputRegistryImpl;

import java.util.List;
import java.util.function.Predicate;

@Mixin(DetectorRailBlock.class)
public abstract class DetectorRailBlockMixin {
    @Shadow
    @Final
    public static BooleanProperty POWERED;

    @Shadow
    protected abstract <T extends AbstractMinecart> List<T> getInteractingMinecartOfType(Level level,
                                                                                         BlockPos pos,
                                                                                         Class<T> cartType,
                                                                                         Predicate<Entity> filter);

    @Inject(
            method = "getAnalogOutputSignal",
            at = @At("HEAD"),
            cancellable = true
    )
    private void blockylib$getMinecartOutput(BlockState state, Level level, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
        if (state.getValue(POWERED)) {
            List<AbstractMinecart> minecarts = getInteractingMinecartOfType(level, pos, AbstractMinecart.class, entity ->
                    MinecartComparatorOutputRegistryImpl.getCalculator(entity.getType()) != null);

            for (AbstractMinecart minecart : minecarts) {
                int output = MinecartComparatorOutputRegistryImpl.getCalculator(minecart.getType()).calculate(minecart, state, pos);

                if (output >= 0) {
                    cir.setReturnValue(output);
                    break;
                }
            }
        }
    }
}
