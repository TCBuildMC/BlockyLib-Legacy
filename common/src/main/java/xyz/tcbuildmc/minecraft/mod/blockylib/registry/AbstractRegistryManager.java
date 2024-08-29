package xyz.tcbuildmc.minecraft.mod.blockylib.registry;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.ApiStatus;
import xyz.tcbuildmc.minecraft.mod.blockylib.util.CollectionUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AbstractRegistryManager {
    protected final Map<Registry<?>, List<RegistryHolder<?>>> holders = new HashMap<>();

    private final String modId;

    protected AbstractRegistryManager(String modId) {
        this.modId = modId;
    }

    public abstract void register();

    public <T> Supplier<T> register(Registry<? super T> registry, String id, T entry) {
        RegistryHolder<T> holder = new RegistryHolderImpl<>(id, entry);
        this.holders.computeIfAbsent(registry, __ -> new ArrayList<>()).add(holder);
        return holder;
    }

    public Supplier<Item> item(String id, Item item) {
        return this.register(BuiltInRegistries.ITEM, id, item);
    }

    public Supplier<Item> item(String id, Item.Properties properties) {
        return this.item(id, new Item(properties));
    }

    public Supplier<Block> block(String id, Block block) {
        return this.register(BuiltInRegistries.BLOCK, id, block);
    }

    public Supplier<Block> block(String id, BlockBehaviour.Properties properties) {
        return this.block(id, new Block(properties));
    }

    public Supplier<Item> blockItem(String id, Block block, Item.Properties properties) {
        Supplier<Block> registeredBlock = this.block(id, block);
        return this.item(id, new BlockItem(registeredBlock.get(), properties));
    }

    public Supplier<CreativeModeTab> tab(String id, ItemLike icon, Consumer<CreativeModeTab.Output> itemCollector) {
        return this.register(BuiltInRegistries.CREATIVE_MODE_TAB, id, CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .title(Component.translatable("itemGroup." + this.modId + "." + id))
                .icon(() -> new ItemStack(icon))
                .displayItems((param, collector) -> itemCollector.accept(collector))
                .build());
    }

    public <T extends BlockEntity> Supplier<BlockEntityType<T>> blockEntityType(String id, BlockEntityType.BlockEntitySupplier<T> factory, Block... linked) {
        return this.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, BlockEntityType.Builder.of(factory, linked)
                .build(Util.fetchChoiceType(References.BLOCK_ENTITY, id)));
    }

    public Supplier<SoundEvent> soundEvent(String id, float range) {
        return this.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createFixedRangeEvent(this.of(id), range));
    }

    public Supplier<SoundEvent> soundEvent(String id) {
        return this.soundEvent(id, 16.0f);
    }

    public Supplier<GameEvent> gameEvent(String id, int notificationRadius) {
        return this.register(BuiltInRegistries.GAME_EVENT, id, new GameEvent(id, notificationRadius));
    }

    public Supplier<GameEvent> gameEvent(String id) {
        return this.gameEvent(id, 16);
    }

    public Supplier<ResourceLocation> stat(String id, StatFormatter formatter) {
        Supplier<ResourceLocation> stat = this.register(BuiltInRegistries.CUSTOM_STAT, id, this.of(id));
        Stats.CUSTOM.get(stat.get(), formatter);

        return stat;
    }

    public Supplier<ResourceLocation> stat(String id) {
        return this.stat(id, StatFormatter.DEFAULT);
    }

    @ApiStatus.Experimental
    public Supplier<PoiType> poiType(String id, int ticketCount, int searchDistance, Block... poiBlocks) {
        CollectionUtils.SetBuilder<BlockState> builder = CollectionUtils.hashSetBuilder();

        for (Block poiBlock : poiBlocks) {
            builder.entry(poiBlock.getStateDefinition().getPossibleStates());
        }

        Set<BlockState> blockStates = builder.build();

        Supplier<PoiType> poiType = this.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE, id, new PoiType(blockStates, ticketCount, searchDistance));
        ResourceKey<PoiType> key = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, this.of(id));
        PoiTypes.registerBlockStates(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolderOrThrow(key), blockStates);
        return poiType;
    }

    public Supplier<VillagerType> villagerType(String id) {
        return this.register(BuiltInRegistries.VILLAGER_TYPE, id, new VillagerType(this.of(id).toString()));
    }

    public <T> TagKey<T> tag(Registry<T> registry, String id) {
        return this.tag(registry.key(), id);
    }

    public <T> TagKey<T> tag(ResourceKey<? extends Registry<T>> key, String id) {
        return TagKey.create(key, this.of(id));
    }

    public ResourceLocation of(String id) {
        return new ResourceLocation(this.modId, id);
    }
}
