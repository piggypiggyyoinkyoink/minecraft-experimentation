package com.piggypiggyyoinkyoink.experimental.datagen;

import com.piggypiggyyoinkyoink.experimental.Experimental;
import com.piggypiggyyoinkyoink.experimental.block.ModBlocks;
import com.piggypiggyyoinkyoink.experimental.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DINGUS_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.DINGUS.get())
                .unlockedBy("has_dingus", has(ModItems.DINGUS)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DINGUS.get(), 9)
                .requires(ModBlocks.DINGUS_BLOCK)
                .unlockedBy("has_dingus_block", has(ModBlocks.DINGUS_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DINGUS.get(), 18)
                .requires(ModBlocks.DINGUS_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK)).save(recipeOutput, "piggypiggyyoinkyoink:bismuth_from_magic_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get(), 1)
                .requires(ItemTags.PLANKS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(recipeOutput, "piggypiggyyoinkyoink:magic_block_from_planks");

        List<ItemLike> DINGUS_SMELTABLES = List.of(ModItems.RAW_DINGUS, ModBlocks.DINGUS_ORE, ModBlocks.DINGUS_DEEPSLATE_ORE);
        oreSmelting(recipeOutput, DINGUS_SMELTABLES, RecipeCategory.MISC, ModItems.DINGUS.get(), 0.25f, 200, "dingus");
        oreBlasting(recipeOutput, DINGUS_SMELTABLES, RecipeCategory.MISC, ModItems.DINGUS.get(), 0.25f, 100, "dingus");

        stairBuilder(ModBlocks.DINGUS_STAIRS.get(), Ingredient.of(ModItems.DINGUS.get())).group("dingus").unlockedBy("has_dingus", has(ModItems.DINGUS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DINGUS_SLAB.get(), ModItems.DINGUS.get());

        buttonBuilder(ModBlocks.DINGUS_BUTTON.get(), Ingredient.of(ModItems.DINGUS.get())).group("dingus").unlockedBy("has_dingus", has(ModItems.DINGUS)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.DINGUS_PRESSURE_PLATE.get(), ModItems.DINGUS.get());

        fenceBuilder(ModBlocks.DINGUS_FENCE.get(), Ingredient.of(ModItems.DINGUS.get())).group("dingus").unlockedBy("has_dingus", has(ModItems.DINGUS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.DINGUS_FENCE_GATE.get(), Ingredient.of(ModItems.DINGUS.get())).group("dingus").unlockedBy("has_dingus", has(ModItems.DINGUS)).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DINGUS_WALL.get(), ModItems.DINGUS.get());

        doorBuilder(ModBlocks.DINGUS_DOOR.get(), Ingredient.of(ModItems.DINGUS.get())).group("dingus").unlockedBy("has_dingus", has(ModItems.DINGUS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.DINGUS_TRAPDOOR.get(), Ingredient.of(ModItems.DINGUS.get())).group("dingus").unlockedBy("has_dingus", has(ModItems.DINGUS)).save(recipeOutput);

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup){
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }
    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup){
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }


    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Experimental.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
