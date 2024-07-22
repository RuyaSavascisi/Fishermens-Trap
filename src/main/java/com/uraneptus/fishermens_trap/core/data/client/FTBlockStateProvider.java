package com.uraneptus.fishermens_trap.core.data.client;

import com.uraneptus.fishermens_trap.FishermensTrap;
import com.uraneptus.fishermens_trap.common.blocks.FishtrapBlock;
import com.uraneptus.fishermens_trap.core.registry.FTBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.uraneptus.fishermens_trap.core.data.FTDatagenUtil.name;

@SuppressWarnings("SameParameterValue")
public class FTBlockStateProvider extends BlockStateProvider {
    public FTBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FishermensTrap.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        fishtrap(FTBlocks.FISHTRAP);
    }

    private void fishtrap(Supplier<? extends Block> block) {

        ModelFile fishtrap = models().getBuilder(name(block.get()))
                .texture("front", "fishermens_trap:block/fishtrap_front")
                .texture("side", "fishermens_trap:block/fishtrap_side")
                .texture("bottom", "fishermens_trap:block/fishtrap_bottom")
                .texture("top", "fishermens_trap:block/fishtrap_top")
                .texture("handles", "fishermens_trap:block/fishtrap_handles")
                .texture("particle", "fishermens_trap:block/fishtrap_front")
                .element().from(0, 0, 3).to(16, 10, 13)
                .face(Direction.NORTH).uvs(0, 3, 16, 13).texture("#front").end()
                .face(Direction.EAST).uvs(3, 3, 13, 13).texture("#side").end()
                .face(Direction.SOUTH).uvs(0, 3, 16, 13).texture("#front").end()
                .face(Direction.WEST).uvs(3, 3, 13, 13).texture("#side").end()
                .face(Direction.UP).uvs(16, 13, 0, 3).texture("#top").end()
                .face(Direction.DOWN).uvs(16, 3, 0, 13).texture("#bottom").end()
                .end().element().from(2, 10, 8).to(14, 16, 8)
                .face(Direction.NORTH).uvs(2, 7, 14, 13).texture("#handles").end()
                .face(Direction.EAST).uvs(2, 7, 14, 13).texture("#handles").end()
                .face(Direction.SOUTH).uvs(2, 7, 14, 13).texture("#handles").end()
                .face(Direction.WEST).uvs(14, 7, 2, 13).texture("#handles").end()
                .face(Direction.UP).uvs(14, 13, 2, 7).texture("#handles").end()
                .face(Direction.DOWN).uvs(14, 7, 2, 13).texture("#handles").end()
                .end().transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75, -77, 2).translation(0, -2.5F, -0.75F).scale(0.64F, 0.64F, 0.64F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(75, -77, 2).translation(0, -2.5F, -0.75F).scale(0.64F, 0.64F, 0.64F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(-5, 86, 0).translation(1, -1.25F, 0).scale(0.88F, 0.88F, 0.88F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(-5, 86, 0).translation(1, -1.25F, 0).scale(0.88F, 0.88F, 0.88F).end()
                .transform(ItemDisplayContext.GROUND).translation(0, 2, 0).scale(0.5F, 0.5F, 0.5F).end()
                .transform(ItemDisplayContext.GUI).rotation(30, 225, 0).translation(0.25F, 2.25F, 0).scale(0.79F, 0.79F, 0.79F).end()
                .transform(ItemDisplayContext.FIXED).scale(0.5F, 0.5F, 0.5F).end()
                .end().renderType("cutout");

        ModelFile hangingFishtrap = models().getBuilder(name(block.get()) + "_hanging")
                .texture("front", "fishermens_trap:block/fishtrap_front")
                .texture("side", "fishermens_trap:block/fishtrap_side")
                .texture("bottom", "fishermens_trap:block/fishtrap_bottom")
                .texture("top", "fishermens_trap:block/fishtrap_top")
                .texture("handles", "fishermens_trap:block/fishtrap_handles")
                .texture("particle", "fishermens_trap:block/fishtrap_front")
                .element().from(0, 0, 3).to(16, 10, 13)
                .face(Direction.NORTH).uvs(0, 3, 16, 13).texture("#front").end()
                .face(Direction.EAST).uvs(3, 3, 13, 13).texture("#side").end()
                .face(Direction.SOUTH).uvs(0, 3, 16, 13).texture("#front").end()
                .face(Direction.WEST).uvs(3, 3, 13, 13).texture("#side").end()
                .face(Direction.UP).uvs(16, 13, 0, 3).texture("#top").end()
                .face(Direction.DOWN).uvs(16, 3, 0, 13).texture("#bottom").end()
                .end().element().from(2, 10, 8).to(14, 16, 8)
                .face(Direction.NORTH).uvs(2, 1, 14, 7).texture("#handles").end()
                .face(Direction.EAST).uvs(2, 1, 14, 7).texture("#handles").end()
                .face(Direction.SOUTH).uvs(2, 1, 14, 7).texture("#handles").end()
                .face(Direction.WEST).uvs(14, 1, 2, 7).texture("#handles").end()
                .face(Direction.UP).uvs(14, 7, 2, 1).texture("#handles").end()
                .face(Direction.DOWN).uvs(14, 1, 2, 7).texture("#handles").end()
                .end().renderType("cutout");

        getVariantBuilder(block.get()).forAllStates(blockState -> {

            if (blockState.getValue(FishtrapBlock.HANGING)) {
                return ConfiguredModel.builder().modelFile(hangingFishtrap).rotationY(((int) blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360).build();
            }

            return ConfiguredModel.builder().modelFile(fishtrap).rotationY(((int) blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360).build();
        });

    }
}
