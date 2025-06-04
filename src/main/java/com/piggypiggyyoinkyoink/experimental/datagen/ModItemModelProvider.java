package com.piggypiggyyoinkyoink.experimental.datagen;

import com.piggypiggyyoinkyoink.experimental.Experimental;
import com.piggypiggyyoinkyoink.experimental.block.ModBlocks;
import com.piggypiggyyoinkyoink.experimental.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, Experimental.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.DINGUS.get());
        basicItem(ModItems.RAW_DINGUS.get());
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.DIAMOND_APPLE.get());
        basicItem(ModItems.ENCHANTED_DIAMOND_APPLE.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());

        buttonItem(ModBlocks.DINGUS_BUTTON, ModBlocks.DINGUS_BLOCK);
        fenceItem(ModBlocks.DINGUS_FENCE, ModBlocks.DINGUS_BLOCK);
        wallItem(ModBlocks.DINGUS_WALL, ModBlocks.DINGUS_BLOCK);
        basicItem(ModBlocks.DINGUS_DOOR.asItem());

        handheldItem(ModItems.DINGUS_SWORD);
        handheldItem(ModItems.DINGUS_PICKAXE);
        handheldItem(ModItems.DINGUS_AXE);
        handheldItem(ModItems.DINGUS_SHOVEL);
        handheldItem(ModItems.DINGUS_HOE);
    }
    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Experimental.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Experimental.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Experimental.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Experimental.MODID,"item/" + item.getId().getPath()));
    }
}
