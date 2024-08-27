package xyz.tcbuildmc.minecraft.mod.blockylib.event;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
public abstract class CancellableEvent<T> implements Event<T>, Cancellable {
    private boolean cancelled = false;

    CancellableEvent() {
        super();
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
