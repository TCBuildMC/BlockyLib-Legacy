package xyz.tcbuildmc.minecraft.mod.blockylib.registry.block.render;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public final class RenderLayerMapRegistry {
    @ExpectPlatform
    public static void register(RenderType type, Block...  blocks) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void register(RenderType type, Fluid...  fluids) {
        throw new AssertionError();
    }
}
