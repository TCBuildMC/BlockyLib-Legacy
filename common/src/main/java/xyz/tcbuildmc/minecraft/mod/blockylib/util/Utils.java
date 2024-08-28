package xyz.tcbuildmc.minecraft.mod.blockylib.util;

import java.util.function.Consumer;

public final class Utils {
    public static <T> T make(T value, Consumer<T> initializer) {
        initializer.accept(value);
        return value;
    }
}
