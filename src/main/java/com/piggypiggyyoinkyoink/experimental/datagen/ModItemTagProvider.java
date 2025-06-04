package com.piggypiggyyoinkyoink.experimental.datagen;

import com.piggypiggyyoinkyoink.experimental.Experimental;
import com.piggypiggyyoinkyoink.experimental.item.ModItems;
import com.piggypiggyyoinkyoink.experimental.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Experimental.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.DINGUS.get())
                .add(ModItems.RAW_DINGUS.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);
        tag(ItemTags.SWORDS)
                .add(ModItems.DINGUS_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.DINGUS_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.DINGUS_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.DINGUS_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.DINGUS_HOE.get());
    }
}
