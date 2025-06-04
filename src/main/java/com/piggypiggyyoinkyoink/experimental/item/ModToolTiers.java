package com.piggypiggyyoinkyoink.experimental.item;

import com.piggypiggyyoinkyoink.experimental.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier DINGUS = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DINGUS_TOOL, 1400, 4f, 3f, 28, ()-> Ingredient.of(ModItems.DINGUS));

}
