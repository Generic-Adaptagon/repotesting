package net.zorme.tutorial_mod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.zorme.tutorial_mod.Item.Moditems;
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

    }

    //creates json files
    private ItemModelBuilder simpleItem(RegistryObject <Item> item) {
        return withExistingParent(item.getId().getPath(), //parent json
                new ResourceLocation("Item/generated")).texture("layero", //normal item
                new ResourceLocation(tutorial_mod.MOD_ID, "item/" + item.getId().getPath())); //texture
    }
}
