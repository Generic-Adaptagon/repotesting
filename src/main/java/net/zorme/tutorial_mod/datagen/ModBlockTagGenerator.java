package net.zorme.tutorial_mod.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zorme.tutorial_mod.Item.custom.util.ModTags;
import net.zorme.tutorial_mod.blocks.ModBlocks;
import net.zorme.tutorial_mod.tutorial_mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, tutorial_mod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) { //generates tag like the metal detector one

            this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                    .add(ModBlocks.SAPPHIRE_ORE.get(),
                         ModBlocks.SAPPHIRE_ORE.get())

                    .addTag(Tags.Blocks.ORES);



        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.SAPPHIRE_BLOCK.get(),
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                ModBlocks.REDISOLD.get(),
                ModBlocks.SAPPHIRE_ORE.get()
            );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.BLUE_BEAN_BLOCK.get()
                );


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.END_STONE_SAPPHIRE_ORE.get());


    }
}
