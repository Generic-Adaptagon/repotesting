package net.zorme.tutorial_mod.Item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.zorme.tutorial_mod.tutorial_mod;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SAPPHIRE("sapphire", 26, new int[]{5,7,5,4}, 25, SoundEvents.ARMOR_EQUIP_GOLD, 1f, 0f, () -> Ingredient.of(Moditems.SAPPHIRE.get())); // ends with coma, last ends with ;
                     // ^                                  //^ helpment, chestplate, leggins, etc1
                      // ^name for texture in the modles folder ex(Sapphire_Layer_1)
    //seconds armor type in game //textures are are 2, one in normal, one in models
   //SAPPHIRE("sapphire", 26, new int[]{5,7,5,4}, 25, SoundEvents.ARMOR_EQUIP_GOLD, 1f, 0f, () -> Ingredient.of(Moditems.SAPPHIRE.get()));
        private final String name;
        private final int durabilityMutiplyer;
        private final int[] nameprotectionAmounts;
        private final int enchanementValue;
        private final SoundEvent equpipSound;
        private final float toughness;
        private final float knockbackResistance;
        private final Supplier<Ingredient> repairIngredient;

        private static final int[] BASE_DURABILITTY = {11, 16, 16 ,13};

    ModArmorMaterials(String name, int durabilityMutiplyer, int[] nameprotectionAmounts, int enchanementValue, SoundEvent equpipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMutiplyer = durabilityMutiplyer;
        this.nameprotectionAmounts = nameprotectionAmounts;
        this.enchanementValue = enchanementValue;
        this.equpipSound = equpipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    //different durabilities for different armor helmet, chest etc
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITTY[type.ordinal()] * this.durabilityMutiplyer;//passes in the array
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.nameprotectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchanementValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equpipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return tutorial_mod.MOD_ID + ":" + this.name; //this is important for the 3d texture // its important to have tutorial_mod because otherwise it wouldn't be under our mod
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
