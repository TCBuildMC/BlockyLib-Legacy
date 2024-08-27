package xyz.tcbuildmc.minecraft.mod.blockylib.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class TickableBlockEntity extends BlockEntity implements BlockEntityTicker<TickableBlockEntity> {
    public TickableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    @Override
    public void tick(Level level, BlockPos blockPos, BlockState blockState, TickableBlockEntity blockEntity) {
    }
}
