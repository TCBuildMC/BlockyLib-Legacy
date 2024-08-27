package xyz.tcbuildmc.minecraft.mod.blockylib.block.entity;

import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface SimpleSidedContainer extends WorldlyContainer {
    NonNullList<ItemStack> getInventory();

    static SimpleSidedContainer of(NonNullList<ItemStack> inventory) {
        return () -> inventory;
    }

    static SimpleSidedContainer ofEmpty(int size) {
        return () -> NonNullList.withSize(size, ItemStack.EMPTY);
    }

    @Override
    default int @NotNull [] getSlotsForFace(Direction side) {
        int[] result = new int[getContainerSize()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    default boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
        return true;
    }

    @Override
    default boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return direction == Direction.DOWN;
    }

    @Override
    default int getContainerSize() {
        return getInventory().size();
    }

    @Override
    default boolean isEmpty() {
        for (int i = 0; i < getContainerSize(); i++) {
            ItemStack stack = getItem(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    @Override
    default ItemStack getItem(int slot) {
        return getInventory().get(slot);
    }

    @NotNull
    @Override
    default ItemStack removeItem(int slot, int amount) {
        ItemStack stack = ContainerHelper.removeItem(getInventory(), slot, amount);

        if (!stack.isEmpty()) {
            setChanged();
        }

        return stack;
    }

    @NotNull
    @Override
    default ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(getInventory(), slot);
    }

    @Override
    default void setItem(int slot, ItemStack stack) {
        getInventory().set(slot, stack);

        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }
    }

    @Override
    default void setChanged() {
    }

    @Override
    default boolean stillValid(Player player) {
        return true;
    }

    @Override
    default void clearContent() {
        getInventory().clear();
    }

    @Override
    default int getMaxStackSize() {
        return 64;
    }
}
