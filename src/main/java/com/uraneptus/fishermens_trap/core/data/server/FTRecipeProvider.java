package com.uraneptus.fishermens_trap.core.data.server;

import com.uraneptus.fishermens_trap.FishermensTrap;
import com.uraneptus.fishermens_trap.core.registry.FTItems;
import com.uraneptus.fishermens_trap.integration.FarmersDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.crafting.ConditionalRecipeOutput;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("SameParameterValue")
public class FTRecipeProvider extends RecipeProvider {

    public FTRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(output, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        fishtrapRecipe(FarmersDelight.getCanvas(), Items.STRING, FTItems.FISHTRAP, consumer);
    }

    private static void fishtrapRecipe(ItemLike FDIngredient, ItemLike vanillaIngredient, Supplier<? extends ItemLike> result, RecipeOutput consumer) {
        fishtrapShapedBuilder(FDIngredient, result, consumer.withConditions(new ModLoadedCondition(FarmersDelight.FD_MODID)), "_" + FarmersDelight.FD_MODID);
        fishtrapShapedBuilder(vanillaIngredient, result, consumer.withConditions(new NotCondition(new ModLoadedCondition(FarmersDelight.FD_MODID))), "");
    }

    private static void fishtrapShapedBuilder(ItemLike exchangeableIngredient, Supplier<? extends ItemLike> result, RecipeOutput consumer, String optSuffix) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result.get(), 1).define('X', Items.STICK).define('#', exchangeableIngredient)
                .pattern("X#X")
                .pattern("###")
                .pattern("X#X")
                .unlockedBy(getHasName(exchangeableIngredient), has(exchangeableIngredient))
                .save(consumer, FishermensTrap.modPrefix(getItemName(result.get()) + optSuffix));
    }
}
