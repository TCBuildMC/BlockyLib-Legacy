package xyz.tcbuildmc.minecraft.mod.blockylib.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class GUIBlockEntity extends InventoryBlockEntity implements MenuProvider, Nameable {
    @Nullable
    private Component customName;

    public GUIBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    @NotNull
    @Override
    public Component getName() {
        return this.customName == null ? this.getContainerName() : this.customName;
    }

    @NotNull
    @Override
    public Component getDisplayName() {
        return this.getName();
    }

    public abstract Component getContainerName();

    @Nullable
    @Override
    public Component getCustomName() {
        return this.customName;
    }

    public void setCustomName(@Nullable Component customName) {
        this.customName = customName;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        if (tag.contains("CustomName", 8)) {
            this.customName = Component.Serializer.fromJson(tag.getString("CustomName"));
        }
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        if (this.customName != null) {
            tag.putString("CustomName", Component.Serializer.toJson(this.customName));
        }
    }
}
