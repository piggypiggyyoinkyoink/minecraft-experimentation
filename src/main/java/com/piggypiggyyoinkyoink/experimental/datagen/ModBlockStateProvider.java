package com.piggypiggyyoinkyoink.experimental.datagen;

import com.piggypiggyyoinkyoink.experimental.Experimental;
import com.piggypiggyyoinkyoink.experimental.block.ModBlocks;
import com.piggypiggyyoinkyoink.experimental.block.custom.DingusLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import javax.swing.plaf.synth.SynthLookAndFeel;

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

        stairsBlock(ModBlocks.DINGUS_STAIRS.get(), blockTexture(ModBlocks.DINGUS_BLOCK.get()));
        blockItem(ModBlocks.DINGUS_STAIRS);

        slabBlock(ModBlocks.DINGUS_SLAB.get(), blockTexture(ModBlocks.DINGUS_BLOCK.get()), blockTexture(ModBlocks.DINGUS_BLOCK.get()));
        blockItem(ModBlocks.DINGUS_SLAB);

        buttonBlock(ModBlocks.DINGUS_BUTTON.get(), blockTexture(ModBlocks.DINGUS_BLOCK.get()));
        pressurePlateBlock(ModBlocks.DINGUS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DINGUS_BLOCK.get()));
        blockItem(ModBlocks.DINGUS_PRESSURE_PLATE);

        fenceBlock(ModBlocks.DINGUS_FENCE.get(), blockTexture(ModBlocks.DINGUS_BLOCK.get()));

        fenceGateBlock(ModBlocks.DINGUS_FENCE_GATE.get(), blockTexture(ModBlocks.DINGUS_BLOCK.get()));
        blockItem(ModBlocks.DINGUS_FENCE_GATE);

        wallBlock(ModBlocks.DINGUS_WALL.get(), blockTexture(ModBlocks.DINGUS_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.DINGUS_DOOR.get(), modLoc("block/dingus_door_bottom"), modLoc("block/dingus_door_top"), "cutout");

        trapdoorBlockWithRenderType(ModBlocks.DINGUS_TRAPDOOR.get(), modLoc("block/dingus_trapdoor"), true, "cutout");
        blockItem(ModBlocks.DINGUS_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.DINGUS_LAMP.get()).forAllStates(state -> {
            if(state.getValue(DingusLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("dingus_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(Experimental.MODID, "block/" + "dingus_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("dingus_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(Experimental.MODID, "block/" + "dingus_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.DINGUS_LAMP.get(), models().cubeAll("dingus_lamp_on",
                ResourceLocation.fromNamespaceAndPath(Experimental.MODID, "block/" + "dingus_lamp_on")));
    }


    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("piggypiggyyoinkyoink:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("piggypiggyyoinkyoink:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
