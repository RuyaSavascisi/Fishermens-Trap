package com.uraneptus.fishermens_trap.core.data.client;

import com.uraneptus.fishermens_trap.FishermensTrap;
import com.uraneptus.fishermens_trap.core.registry.FTBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class FTLangProvider extends LanguageProvider {

    public FTLangProvider(PackOutput output) {
        super(output, FishermensTrap.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(FishermensTrap.MOD_ID + ".container.fishtrap", "Fish Trap");
        addBlock(FTBlocks.FISHTRAP, "Fish Trap");
        add(FishermensTrap.MOD_ID + ".jei.fishtrap_fishing", "Fish Trap Fishing");
    }

}