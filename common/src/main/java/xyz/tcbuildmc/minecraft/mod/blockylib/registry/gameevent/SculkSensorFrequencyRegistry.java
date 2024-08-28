package xyz.tcbuildmc.minecraft.mod.blockylib.registry.gameevent;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;

public final class SculkSensorFrequencyRegistry {
    public static void register(GameEvent event, int frequency) {
        ((Object2IntOpenHashMap<GameEvent>) VibrationSystem.VIBRATION_FREQUENCY_FOR_EVENT).put(event, frequency);
    }

    public static void unregister(GameEvent event) {
        ((Object2IntOpenHashMap<GameEvent>) VibrationSystem.VIBRATION_FREQUENCY_FOR_EVENT).removeInt(event);
    }

    public static int getFrequency(GameEvent event) {
        return ((Object2IntOpenHashMap<GameEvent>) VibrationSystem.VIBRATION_FREQUENCY_FOR_EVENT).getInt(event);
    }
}
