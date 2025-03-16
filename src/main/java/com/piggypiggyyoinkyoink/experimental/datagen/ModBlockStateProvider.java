package com.piggypiggyyoinkyoink.experimental.datagen;

import com.piggypiggyyoinkyoink.experimental.Experimental;
import com.piggypiggyyoinkyoink.experimental.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, Experimental.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DINGUS_BLOCK);
        blockWithItem(ModBlocks.DINGUS_ORE);
        blockWithItem(ModBlocks.DINGUS_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
