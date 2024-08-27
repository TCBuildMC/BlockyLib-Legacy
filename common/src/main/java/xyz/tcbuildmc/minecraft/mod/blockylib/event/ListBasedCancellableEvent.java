package xyz.tcbuildmc.minecraft.mod.blockylib.event;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListBasedCancellableEvent<T> extends CancellableEvent<T> {
    // TODO: Add support for priority
    private final List<T> listeners = new ArrayList<>();

    ListBasedCancellableEvent() {
        super();
    }

    @Override
    public final void register(T listener) {
        this.listeners.add(listener);
    }

    @Override
    public final void unregister(T listener) {
        this.listeners.remove(listener);
    }

    public final void clear() {
        this.listeners.clear();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return this.listeners.iterator();
    }
}
