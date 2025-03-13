package com.piggypiggyyoinkyoink.experimental.item;

import com.piggypiggyyoinkyoink.experimental.Experimental;
import com.piggypiggyyoinkyoink.experimental.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Experimental.MODID);

    public static final Supplier<CreativeModeTab> DINGUS_ITEMS_TAB = CREATIVE_MODE_TAB.register("dingus_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.DINGUS.get()))
                    .title(Component.translatable("creativetab.piggypiggyyoinkyoink.dingus_items"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModItems.DINGUS);
                        output.accept(ModItems.RAW_DINGUS);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.RADISH);
                    })
                    .build());
    public static final Supplier<CreativeModeTab> DINGUS_BLOCK_TAB = CREATIVE_MODE_TAB.register("dingus_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.DINGUS_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Experimental.MODID, "dingus_items_tab")) //display items tab before blocks tab
                    .title(Component.translatable("creativetab.piggypiggyyoinkyoink.dingus_blocks"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModBlocks.DINGUS_BLOCK);
                        output.accept(ModBlocks.DINGUS_ORE);
                        output.accept(ModBlocks.DINGUS_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);

                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
