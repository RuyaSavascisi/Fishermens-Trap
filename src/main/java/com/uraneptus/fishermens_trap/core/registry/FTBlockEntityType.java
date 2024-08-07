package com.uraneptus.fishermens_trap.core.registry;

import com.uraneptus.fishermens_trap.FishermensTrap;
import com.uraneptus.fishermens_trap.common.blocks.FishtrapBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FTBlockEntityType {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, FishermensTrap.MOD_ID);

    public static final Supplier<BlockEntityType<FishtrapBlockEntity>> FISHTRAP = BLOCK_ENTITIES.register("fishtrap", () -> BlockEntityType.Builder.of(FishtrapBlockEntity::new, new Block[]{FTBlocks.FISHTRAP.get()}).build(null));
}
