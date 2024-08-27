package xyz.tcbuildmc.minecraft.mod.blockylib.event;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public interface Event<T> extends Iterable<T> {
    void register(T listener);

    default void registerAll(T... listeners) {
        registerAll(Arrays.asList(listeners));
    }

    default void registerAll(Collection<? extends T> listeners) {
        for (T listener : listeners) {
            register(listener);
        }
    }

    void unregister(T listener);

    default void unregisterAll(T... listeners) {
        unregisterAll(Arrays.asList(listeners));
    }

    default void unregisterAll(Collection<? extends T> listeners) {
        for (T listener : listeners) {
            unregister(listener);
        }
    }

    void clear();

    @NotNull
    @Override
    Iterator<T> iterator();

    static <T> Event<T> create() {
        return new ListBasedEvent<>();
    }

    static <T> CancellableEvent<T> createCancellable() {
        return new ListBasedCancellableEvent<>();
    }
}
