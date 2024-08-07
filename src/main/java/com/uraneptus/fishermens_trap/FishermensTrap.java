package com.uraneptus.fishermens_trap;

import com.mojang.logging.LogUtils;
import com.uraneptus.fishermens_trap.core.data.client.FTBlockStateProvider;
import com.uraneptus.fishermens_trap.core.data.client.FTItemModelProvider;
import com.uraneptus.fishermens_trap.core.data.client.FTLangProvider;
import com.uraneptus.fishermens_trap.core.data.client.FTSpriteSourceProvider;
import com.uraneptus.fishermens_trap.core.data.server.FTRecipeProvider;
import com.uraneptus.fishermens_trap.core.data.server.loot.FTLootTablesProvider;
import com.uraneptus.fishermens_trap.core.data.server.tags.FTBiomeTagsProvider;
import com.uraneptus.fishermens_trap.core.data.server.tags.FTBlockTagsProvider;
import com.uraneptus.fishermens_trap.core.data.server.tags.FTItemTagsProvider;
import com.uraneptus.fishermens_trap.core.registry.FTBlockEntityType;
import com.uraneptus.fishermens_trap.core.registry.FTBlocks;
import com.uraneptus.fishermens_trap.core.registry.FTItems;
import com.uraneptus.fishermens_trap.core.registry.FTMenuType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(FishermensTrap.MOD_ID)
public class FishermensTrap {
    public static final String MOD_ID = "fishermens_trap";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation modPrefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(FishermensTrap.MOD_ID, path);
    }

    public FishermensTrap(IEventBus bus, ModContainer modContainer) {
        bus.addListener(this::gatherData);

        FTBlocks.BLOCKS.register(bus);
        FTItems.ITEMS.register(bus);
        FTBlockEntityType.BLOCK_ENTITIES.register(bus);
        FTMenuType.MENU.register(bus);

        modContainer.registerConfig(ModConfig.Type.COMMON, FTConfig.COMMON);
    }

    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(includeClient, new FTBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new FTItemModelProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new FTLangProvider(packOutput));
        generator.addProvider(includeClient, new FTSpriteSourceProvider(packOutput, lookupProvider, fileHelper));

        FTBlockTagsProvider blockTagProvider = new FTBlockTagsProvider(packOutput, lookupProvider, fileHelper);
        generator.addProvider(includeServer, blockTagProvider);
        generator.addProvider(includeServer, new FTItemTagsProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), fileHelper));
        generator.addProvider(includeServer, new FTBiomeTagsProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(includeServer, new FTLootTablesProvider(packOutput, lookupProvider));
        generator.addProvider(includeServer, new FTRecipeProvider(packOutput, lookupProvider));
    }
}