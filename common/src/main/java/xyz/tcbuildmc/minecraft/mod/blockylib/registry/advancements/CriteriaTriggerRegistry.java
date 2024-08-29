package xyz.tcbuildmc.minecraft.mod.blockylib.registry.advancements;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public final class CriteriaTriggerRegistry {
    public static void register(ResourceLocation id, CriterionTrigger<?> trigger) {
        CriteriaTriggers.CRITERIA.put(id, trigger);
    }

    public static void unregister(ResourceLocation id) {
        CriteriaTriggers.CRITERIA.remove(id);
    }

    public static Optional<CriterionTrigger<?>> getTrigger(ResourceLocation id) {
        return Optional.ofNullable(CriteriaTriggers.CRITERIA.get(id));
    }
}
