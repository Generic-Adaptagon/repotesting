package net.zorme.tutorial_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.zorme.tutorial_mod.blocks.ModBlocks;
import net.zorme.tutorial_mod.tutorial_mod;

public class ModBlocksStateProvider extends BlockStateProvider {

    public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, tutorial_mod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.SOUND_BLOCK);
        blockWithItem(ModBlocks.BLUE_BEAN_BLOCK);
        blockWithItem(ModBlocks.REDISOLD);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.END_STONE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);


    }

    //makes block and Item
    private void blockWithItem (RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
