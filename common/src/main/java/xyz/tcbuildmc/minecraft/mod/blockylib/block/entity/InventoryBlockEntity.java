package xyz.tcbuildmc.minecraft.mod.blockylib.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class InventoryBlockEntity extends TickableBlockEntity implements SimpleSidedContainer {
    public InventoryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        ContainerHelper.loadAllItems(tag, this.getInventory());
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        ContainerHelper.saveAllItems(tag, this.getInventory());
    }
}
