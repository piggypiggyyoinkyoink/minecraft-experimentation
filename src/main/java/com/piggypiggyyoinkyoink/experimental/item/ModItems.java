package com.piggypiggyyoinkyoink.experimental.item;

import com.piggypiggyyoinkyoink.experimental.Experimental;
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
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
