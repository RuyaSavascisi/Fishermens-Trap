package com.uraneptus.fishermens_trap.core.registry;

import com.uraneptus.fishermens_trap.FishermensTrap;
import com.uraneptus.fishermens_trap.common.blocks.FishtrapBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FTBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FishermensTrap.MOD_ID);

    public static final DeferredBlock<Block> FISHTRAP = BLOCKS.registerBlock("fishtrap", FishtrapBlock::new, BlockBehaviour.Properties.of().sound(SoundType.WOOL).mapColor(MapColor.COLOR_BROWN).noOcclusion());


}
