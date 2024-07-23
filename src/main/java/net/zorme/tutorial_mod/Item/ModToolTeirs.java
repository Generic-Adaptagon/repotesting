package net.zorme.tutorial_mod.Item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.zorme.tutorial_mod.Item.custom.util.ModTags;
import net.zorme.tutorial_mod.datagen.ModItemTagGenerator;
import net.zorme.tutorial_mod.tutorial_mod;

import java.util.List;

public class ModToolTeirs {

    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEED_SAPPHIRE_TOOL, () -> Ingredient.of(Moditems.SAPPHIRE.get())),
            new ResourceLocation(tutorial_mod.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());

}
