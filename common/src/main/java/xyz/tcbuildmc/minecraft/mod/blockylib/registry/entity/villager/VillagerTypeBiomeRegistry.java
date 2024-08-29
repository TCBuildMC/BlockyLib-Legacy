package xyz.tcbuildmc.minecraft.mod.blockylib.registry.entity.villager;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;

import java.util.Optional;

public final class VillagerTypeBiomeRegistry {
    public static void register(ResourceKey<Biome> biome, VillagerType type) {
        VillagerType.BY_BIOME.put(biome, type);
    }

    public static void unregister(ResourceKey<Biome> biome) {
        VillagerType.BY_BIOME.remove(biome);
    }

    public static Optional<VillagerType> getType(ResourceKey<Biome> biome) {
        return Optional.ofNullable(VillagerType.BY_BIOME.get(biome));
    }
}
