package xyz.tcbuildmc.minecraft.mod.blockylib.registry;

record RegistryHolderImpl<T>(String id, T entry) implements RegistryHolder<T> {
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public T get() {
        return this.entry;
    }
}
