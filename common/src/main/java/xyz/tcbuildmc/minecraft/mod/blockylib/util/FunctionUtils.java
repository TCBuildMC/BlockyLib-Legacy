package xyz.tcbuildmc.minecraft.mod.blockylib.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public final class FunctionUtils {
    public static <T> Supplier<T> toSupplier(Class<T> clazz) {
        try {
            Constructor<T> c = clazz.getDeclaredConstructor();
            c.setAccessible(true);

            return () -> {
                try {
                    return c.newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T, P> Function<P, T> toFunction(Class<T> clazz, Class<P> param1) {
        try {
            Constructor<T> c = clazz.getDeclaredConstructor(param1);
            c.setAccessible(true);

            return p -> {
                try {
                    return c.newInstance(p);
                } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T, P1, P2> BiFunction<P1, P2, T> toFunction(Class<T> clazz, Class<P1> param1, Class<P2> param2) {
        try {
            Constructor<T> c = clazz.getDeclaredConstructor(param1, param2);
            c.setAccessible(true);

            return (p1, p2) -> {
                try {
                    return c.newInstance(p1, p2);
                } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
