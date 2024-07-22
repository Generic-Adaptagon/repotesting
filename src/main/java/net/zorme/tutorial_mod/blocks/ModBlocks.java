package net.zorme.tutorial_mod.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zorme.tutorial_mod.Item.Moditems;
import net.zorme.tutorial_mod.blocks.custom.SoundBlock;
import net.zorme.tutorial_mod.tutorial_mod;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, tutorial_mod.MOD_ID);

    //Actual blocks
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> REDISOLD = registerBlock("redisold", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANVIL)));
    public static final RegistryObject<Block> BLUE_BEAN_BLOCK = registerBlock("blue_bean_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block", () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    //ore
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 28)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f).requiresCorrectToolForDrops(), UniformInt.of(46, 56)));
    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(63, 64)));
    public static final RegistryObject<Block> END_STONE_SAPPHIRE_ORE = registerBlock("end_stone_sapphire_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(87, 20462)));

    //regestiers blocks
    private  static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        //registers block
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        // registers block Item
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    //block to item method
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static  void  register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}


