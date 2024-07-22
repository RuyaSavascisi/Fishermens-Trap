package com.uraneptus.fishermens_trap.common.blocks.container;

import com.uraneptus.fishermens_trap.FTConfig;
import com.uraneptus.fishermens_trap.core.other.FTItemTags;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class FTItemStackHandler extends ItemStackHandler {

    public FTItemStackHandler() {
        super(10);
    }

    public void handleItemsInsertion(List<ItemStack> list, ItemStack baitItem, RandomSource random) {
        for (ItemStack itemStack : list) {
            if (!itemStack.isEmpty()) {
                for (int i = 0; i < getSlots(); i++) {
                    ItemStack stackInSlot = getStackInSlot(i);
                    if (stackInSlot.isEmpty()) {

                        itemStack = insertItem(i, itemStack, false);
                        baitItem.shrink(1);
                        if (itemStack.isEmpty()) {
                            break;
                        }
                    }
                    if (random.nextFloat() < FTConfig.FISH_BUCKET_CHANCE.get()) {
                        if (stackInSlot.is(Items.WATER_BUCKET)) {
                            ResourceLocation regName =  BuiltInRegistries.ITEM.getKey(itemStack.getItem());
                            ResourceLocation bucketFishLocation = ResourceLocation.fromNamespaceAndPath(Objects.requireNonNull(regName).getNamespace(), regName.getPath() + "_bucket");
                            if (BuiltInRegistries.ITEM.containsKey(bucketFishLocation)) {
                                stackInSlot.shrink(1);
                                itemStack = insertItem(i, Objects.requireNonNull(BuiltInRegistries.ITEM.get(bucketFishLocation)).getDefaultInstance(), false);
                                baitItem.shrink(1);
                                if (itemStack.isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected int getStackLimit(int slot, ItemStack stack) {
        return slot != 0 ? 1 : stack.getMaxStackSize();
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        if (slot == 0) {
            return stack.is(FTItemTags.FISH_BAITS);
        }
        return true;
    }

    public NonNullList<ItemStack> getItems() {
        return this.stacks;
    }
}
