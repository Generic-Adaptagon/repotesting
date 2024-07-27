package net.zorme.tutorial_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.zorme.tutorial_mod.Item.Moditems;
import net.zorme.tutorial_mod.Item.custom.util.ModTags;
import net.zorme.tutorial_mod.loot.AddItemModifier;
import net.zorme.tutorial_mod.tutorial_mod;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {


    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, tutorial_mod.MOD_ID);
    }

    @Override
    protected void start() {
        //adds json file w/ 35% chance to drop
        add("pine_cone_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, Moditems.PINE_CONE.get()));
        //adds 100% chance to drop pine-cone //add for anything in the data -> Minecraft -> Loot_tables -> entitiesd
        add("pine_cone_from_creeper", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation( "entities/creeper")).build()}, Moditems.PINE_CONE.get()));
        //add metal detector to jungle temples chest 100 %
        add("metal_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation( "chests/jungle_temple")).build()}, Moditems.METAL_DETECTOR.get()));

    }
}
