package com.piggypiggyyoinkyoink.experimental.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RADISH = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 400), 0.35f)
            .build(); //other methods than .effect() exist too, e.g. alwaysEdible() (for gapples etc), usingConvertsTo() (e.g. to get the bowl back after eating stew)
    //doubletap shift and search foods in classes for info on how to balance stats etc
    // to make into a drink make a custom item class for the food and override the use animation


    public static final FoodProperties DIAMOND_APPLE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 3), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 4), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 250, 2), 1.0f)
            .alwaysEdible()
            .build();

}
