package net.zorme.tutorial_mod.Item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    //middlemouse on FoodProperties for all the possible things you can do for food
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
            //seperated for clearity //effects with 10%chance
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();
    public static final FoodProperties BEAPER = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200, 2), 1).build();
    public static final FoodProperties BLUE_BEAN = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).build();
}
