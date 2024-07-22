package com.uraneptus.fishermens_trap.core.registry;

import com.uraneptus.fishermens_trap.FishermensTrap;
import com.uraneptus.fishermens_trap.common.blocks.container.FishtrapMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FTMenuType {
    public static final DeferredRegister<MenuType<?>> MENU = DeferredRegister.create(BuiltInRegistries.MENU, FishermensTrap.MOD_ID);

    public static final Supplier<MenuType<FishtrapMenu>> FISHTRAP_MENU = MENU.register("fishtrap_menu", () -> IMenuTypeExtension.create(FishtrapMenu::new));

}
