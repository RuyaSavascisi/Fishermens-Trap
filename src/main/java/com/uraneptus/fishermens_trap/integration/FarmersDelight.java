package com.uraneptus.fishermens_trap.integration;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
//import vectorwing.farmersdelight.common.registry.ModItems;

public class FarmersDelight {
    public static final String FD_MODID = "farmersdelight";

    //TODO change when FD updated
    public static Item getCanvas() {
        //return ModItems.CANVAS.get();
        return Items.WHEAT;
    }
}
