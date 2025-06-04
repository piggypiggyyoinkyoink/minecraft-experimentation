package com.piggypiggyyoinkyoink.experimental.block;

import com.piggypiggyyoinkyoink.experimental.Experimental;
import com.piggypiggyyoinkyoink.experimental.block.custom.MagicBlock;
import com.piggypiggyyoinkyoink.experimental.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Experimental.MODID);


    public static final DeferredBlock<Block> DINGUS_BLOCK = registerBlock("dingus_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> DINGUS_ORE = registerBlock("dingus_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DINGUS_DEEPSLATE_ORE = registerBlock("dingus_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<StairBlock> DINGUS_STAIRS = registerBlock("dingus_stairs",
            ()-> new StairBlock(ModBlocks.DINGUS_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> DINGUS_SLAB = registerBlock("dingus_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> DINGUS_PRESSURE_PLATE = registerBlock("dingus_pressure_plate",
            ()-> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> DINGUS_BUTTON = registerBlock("dingus_button",
            ()-> new ButtonBlock(BlockSetType.IRON, 20,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission())); //need noCollission for buttons

    public static final DeferredBlock<FenceBlock> DINGUS_FENCE = registerBlock("dingus_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> DINGUS_FENCE_GATE = registerBlock("dingus_fence_gate",
            ()-> new FenceGateBlock(WoodType.ACACIA,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> DINGUS_WALL = registerBlock("dingus_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> DINGUS_DOOR = registerBlock("dingus_door",
            ()-> new DoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion())); //need noOcclusion for doors
    public static final DeferredBlock<TrapDoorBlock> DINGUS_TRAPDOOR = registerBlock("dingus_trapdoor",
            ()-> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion())); //need noOcclusion for trapdoors



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //register item associated with the block
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
