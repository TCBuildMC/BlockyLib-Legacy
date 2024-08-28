package xyz.tcbuildmc.minecraft.mod.blockylib.util;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;

import java.util.function.Consumer;

public final class TagKeyUtils {
    public static <T> void forEachEntry(Registry<T> key, TagKey<T> tag, Consumer<T> action) {
        for (Holder<T> holder : key.getTagOrEmpty(tag)) {
            action.accept(holder.value());
        }
    }
}
