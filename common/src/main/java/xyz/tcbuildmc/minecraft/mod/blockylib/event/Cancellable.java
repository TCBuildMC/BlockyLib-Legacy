package xyz.tcbuildmc.minecraft.mod.blockylib.event;

public interface Cancellable {
    boolean isCancelled();

    void setCancelled(boolean cancelled);

    default void cancel() {
        if (isCancelled()) {
            setCancelled(true);
        }
    }
}
