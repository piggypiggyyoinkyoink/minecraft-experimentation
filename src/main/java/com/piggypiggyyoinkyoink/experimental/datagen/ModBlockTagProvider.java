package com.piggypiggyyoinkyoink.experimental.datagen;

import com.piggypiggyyoinkyoink.experimental.Experimental;
import com.piggypiggyyoinkyoink.experimental.block.ModBlocks;
import com.piggypiggyyoinkyoink.experimental.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Experimental.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DINGUS_BLOCK.get())
                .add(ModBlocks.DINGUS_ORE.get())
                .add(ModBlocks.DINGUS_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DINGUS_ORE.get())
                .add(ModBlocks.DINGUS_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DINGUS_LAMP.get());

        tag(BlockTags.FENCES).add(ModBlocks.DINGUS_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.DINGUS_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.DINGUS_WALL.get());

        tag(ModTags.Blocks.NEEDS_DINGUS_TOOL)
                .add(ModBlocks.DINGUS_LAMP.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_DINGUS_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_DINGUS_TOOL);
    }
}
