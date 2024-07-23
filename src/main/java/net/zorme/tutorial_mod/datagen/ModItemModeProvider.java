package net.zorme.tutorial_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zorme.tutorial_mod.Item.Moditems;
import net.zorme.tutorial_mod.blocks.ModBlocks;
import net.zorme.tutorial_mod.tutorial_mod;

public class ModItemModeProvider extends ItemModelProvider {
    public ModItemModeProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, tutorial_mod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

            simpleItem(Moditems.BEAPER);
            simpleItem(Moditems.BLUE_BEAN);
            simpleItem(Moditems.DEBIT_CARD);
            simpleItem(Moditems.METAL_DETECTOR);
            simpleItem(Moditems.PINE_CONE);
            simpleItem(Moditems.RAW_SAPPHIRE);
            simpleItem(Moditems.STRAWBERRY);
            simpleItem(Moditems.SAPPHIRE);

            simpleBlockItem(ModBlocks.SAPPHIRE_DOOR);

            fenceItem(ModBlocks.SAPPHIRE_FENCE, ModBlocks.SAPPHIRE_BLOCK);
            buttonItem(ModBlocks.SAPPHIRE_BUTTON, ModBlocks.SAPPHIRE_BLOCK);
            wallItem(ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE_BLOCK);

            evenSimplerBlockItem(ModBlocks.SAPPHIRE_STAIRS);
            evenSimplerBlockItem(ModBlocks.SAPPHIRE_SLAB);
            evenSimplerBlockItem(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
            evenSimplerBlockItem(ModBlocks.SAPPHIRE_FENCE_GATE);

            trapdoorItem(ModBlocks.SAPPHIRE_TRAPDOOR);





    }

    //creates json files
    private ItemModelBuilder simpleItem(RegistryObject <Item> item) {
        return withExistingParent(item.getId().getPath(), //parent json
                new ResourceLocation("item/generated")).texture("layer0", //normal item
                new ResourceLocation(tutorial_mod.MOD_ID, "item/" + item.getId().getPath())); //texture
    }


    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(tutorial_mod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(tutorial_mod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(tutorial_mod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(tutorial_mod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(tutorial_mod.MOD_ID,"item/" + item.getId().getPath()));
    }
}



