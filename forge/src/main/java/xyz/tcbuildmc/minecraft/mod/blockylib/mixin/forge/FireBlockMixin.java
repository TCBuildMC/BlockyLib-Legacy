package xyz.tcbuildmc.minecraft.mod.blockylib.mixin.forge;

import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.forge.FlammableBlockRegistryImpl;

@Mixin(FireBlock.class)
public class FireBlockMixin {
    @Inject(
            method = "getIgniteOdds(Lnet/minecraft/world/level/block/state/BlockState;)I",
            at = @At("HEAD"),
            cancellable = true
    )
    private void blockylib$getBurnChance(BlockState state, CallbackInfoReturnable<Integer> cir) {
        if (this.blockylib$isWaterlogged(state)) {
            return;
        }

        if (FlammableBlockRegistryImpl.getFlammableRegistries().containsKey(state.getBlock())) {
            cir.setReturnValue(FlammableBlockRegistryImpl.getFlammableRegistries().get(state.getBlock()).burnChance());
            cir.cancel();
        }
    }

    @Inject(
            method = "getBurnOdds",
            at = @At("HEAD"),
            cancellable = true
    )
    private void blockylib$getSpreadChance(BlockState state, CallbackInfoReturnable<Integer> cir) {
        if (this.blockylib$isWaterlogged(state)) {
            return;
        }

        if (FlammableBlockRegistryImpl.getFlammableRegistries().containsKey(state.getBlock())) {
            cir.setReturnValue(FlammableBlockRegistryImpl.getFlammableRegistries().get(state.getBlock()).spreadSpeed());
            cir.cancel();
        }
    }

    @Unique
    private boolean blockylib$isWaterlogged(BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED);
    }
}
