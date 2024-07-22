package com.uraneptus.fishermens_trap.core.registry;

import com.uraneptus.fishermens_trap.FishermensTrap;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FTItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FishermensTrap.MOD_ID);

    public static final DeferredItem<BlockItem> FISHTRAP = ITEMS.registerSimpleBlockItem("fishtrap", FTBlocks.FISHTRAP);

}
