package xyz.tcbuildmc.minecraft.mod.blockylib.util;

import java.util.*;

public final class CollectionUtils {
    @SafeVarargs
    public static <T> List<T> newArrayList(T... initializeValue) {
        return new ArrayList<>(Arrays.asList(initializeValue));
    }

    @SafeVarargs
    public static <K, V> Map<K, V> newHashMap(Pair<K, V>... initializeValue) {
        return Utils.make(new HashMap<>(), map -> {
            for (Pair<K, V> entry : initializeValue) {
                map.put(entry.a, entry.b);
            }
        });
    }

    public static <K, V> CollectionUtils.MapBuilder<K, V> hashMapBuilder() {
        return new CollectionUtils.MapBuilder<>(new HashMap<>());
    }

    private CollectionUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public record Pair<A, B>(A a, B b) {
        public Pair {}
    }

    public static final class MapBuilder<K, V> {
        private final Map<K, V> map;

        private MapBuilder(Map<K, V> map) {
            this.map = map;
        }

        public MapBuilder<K, V> entry(K key, V value) {
            this.map.put(key, value);
            return this;
        }

        public Map<K, V> build() {
            return this.map;
        }
    }
}
