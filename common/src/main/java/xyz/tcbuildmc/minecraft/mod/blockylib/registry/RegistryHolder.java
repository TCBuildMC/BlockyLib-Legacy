package xyz.tcbuildmc.minecraft.mod.blockylib.registry;

import java.util.function.Supplier;

public interface RegistryHolder<T> extends Supplier<T> {
    String getId();

    @Override
    T get();
}
