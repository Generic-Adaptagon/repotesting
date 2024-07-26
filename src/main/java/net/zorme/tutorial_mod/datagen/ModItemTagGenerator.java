package net.zorme.tutorial_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zorme.tutorial_mod.Item.Moditems;
import net.zorme.tutorial_mod.tutorial_mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {


    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, tutorial_mod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //trimable armor
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(Moditems.SAPPHIRE_HELMET.get())
                .add(Moditems.SAPPHIRE_CHESTPLATE.get())
                .add(Moditems.SAPPHIRE_LEGGINGS.get())
                .add(Moditems.SAPPHIRE_BOOTS.get());


    }
}
