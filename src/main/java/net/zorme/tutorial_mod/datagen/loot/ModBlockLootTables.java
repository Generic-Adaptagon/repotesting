package net.zorme.tutorial_mod.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.zorme.tutorial_mod.Item.Moditems;
import net.zorme.tutorial_mod.Item.custom.BeaperCropBlock;
import net.zorme.tutorial_mod.Item.custom.StrawberryCropBlock;
import net.zorme.tutorial_mod.blocks.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.REDISOLD.get());
        this.dropSelf(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.BLUE_BEAN_BLOCK.get());
    //ADD NEW ORES HERE
        this.add(ModBlocks.SAPPHIRE_ORE.get(), block -> createBasicCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), Moditems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), block -> createDeepslateInfusedCopperLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), Moditems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.NETHER_SAPPHIRE_ORE.get(), block -> createNetherInfusedCopperLikeOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE.get(), Moditems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.END_STONE_SAPPHIRE_ORE.get(), block -> createEndInfusedCopperLikeOreDrops(ModBlocks.END_STONE_SAPPHIRE_ORE.get(), Moditems.RAW_SAPPHIRE.get()));

    //non_block blocks
        this.dropSelf(ModBlocks.SAPPHIRE_STAIRS.get());
        this.dropSelf(ModBlocks.SAPPHIRE_BUTTON.get());
        this.dropSelf(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_WALL.get());
        this.dropSelf(ModBlocks.SAPPHIRE_FENCE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_TRAPDOOR.get());


        this.add(ModBlocks.SAPPHIRE_SLAB.get(),
            block -> createSlabItemTable(ModBlocks.SAPPHIRE_SLAB.get()));

        this.add(ModBlocks.SAPPHIRE_DOOR.get(),
            block -> createDoorTable(ModBlocks.SAPPHIRE_DOOR.get()));


        //crop//Look at vanillaBlockLoot class
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition //for age 5 plants
                .hasBlockStateProperties(ModBlocks.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));//if full age
        this.add(ModBlocks.STRAWBERRY_CROP.get(), createCropDrops(ModBlocks.STRAWBERRY_CROP.get(), Moditems.STRAWBERRY.get(),
                Moditems.STRAWBERRY_SEEDS.get(), lootitemcondition$builder));

        LootItemCondition.Builder loot7itemcondition$builder = LootItemBlockStatePropertyCondition //for age 7 plants
                .hasBlockStateProperties(ModBlocks.BEAPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeaperCropBlock.AGE, 7));//if full age
        this.add(ModBlocks.BEAPER_CROP.get(), createCropDrops(ModBlocks.BEAPER_CROP.get(), Moditems.BEAPER.get(),
                Moditems.BEAPER_SEED.get(), loot7itemcondition$builder));

    }

/*Ores increase in Value the more endgame the dimension is*/
    protected LootTable.Builder createBasicCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    protected LootTable.Builder createDeepslateInfusedCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createNetherInfusedCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    protected LootTable.Builder createEndInfusedCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(8.0F, 18.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    //known blocks added via ModBlockLootTables  in MobBlocks, that dont have .noLoottable will have a loot table generated
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;

    }
}
