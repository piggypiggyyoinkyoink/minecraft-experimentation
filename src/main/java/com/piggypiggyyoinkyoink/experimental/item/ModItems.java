package com.piggypiggyyoinkyoink.experimental.item;

import com.piggypiggyyoinkyoink.experimental.Experimental;
import com.piggypiggyyoinkyoink.experimental.item.custom.ChiselItem;
import com.piggypiggyyoinkyoink.experimental.item.custom.EnchantedAppleItem;
import com.piggypiggyyoinkyoink.experimental.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Experimental.MODID);

    public static final DeferredItem<Item> DINGUS = ITEMS.register("dingus",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_DINGUS = ITEMS.register("raw_dingus",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));
    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)));
    public static final DeferredItem<Item> DIAMOND_APPLE = ITEMS.register("diamond_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DIAMOND_APPLE)));
    public static final DeferredItem<Item> ENCHANTED_DIAMOND_APPLE = ITEMS.register("enchanted_diamond_apple",
            () -> new EnchantedAppleItem(new Item.Properties().food(ModFoodProperties.ENCHANTED_DIAMOND_APPLE)));

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties())); //uses /data/neoforge/data_maps/itemfurnace_fuels.json
    //^ 2 different ways of adding fuels. To get vanilla burntimes, shift twice and go to AbstractFurnaceBlockEntity class buildFuels method


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
