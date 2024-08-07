package com.uraneptus.fishermens_trap;

import com.uraneptus.fishermens_trap.client.screen.FishtrapScreen;
import com.uraneptus.fishermens_trap.core.registry.FTItems;
import com.uraneptus.fishermens_trap.core.registry.FTMenuType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(value = FishermensTrap.MOD_ID, dist = Dist.CLIENT)
public class FishermensTrapClient {

    public FishermensTrapClient(IEventBus bus, ModContainer modContainer) {
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        bus.addListener(this::buildTabContents);
        bus.addListener(this::registerScreens);
    }

    public void buildTabContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (tabKey == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(FTItems.FISHTRAP);
        }
    }

    public void registerScreens(RegisterMenuScreensEvent event) {
        event.register(FTMenuType.FISHTRAP_MENU.get(), FishtrapScreen::new);
    }
}
