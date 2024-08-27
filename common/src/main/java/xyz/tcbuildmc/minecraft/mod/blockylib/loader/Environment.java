package xyz.tcbuildmc.minecraft.mod.blockylib.loader;

public enum Environment {
    CLIENT,
    SERVER;

    public boolean isClient() {
        return this == Environment.CLIENT;
    }

    public boolean isServer() {
        return this == Environment.SERVER;
    }
}
