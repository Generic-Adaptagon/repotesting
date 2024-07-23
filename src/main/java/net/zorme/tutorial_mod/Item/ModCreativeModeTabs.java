package net.zorme.tutorial_mod.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zorme.tutorial_mod.blocks.ModBlocks;
import net.zorme.tutorial_mod.tutorial_mod;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create (Registries.CREATIVE_MODE_TAB, tutorial_mod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.SAPPHIRE.get()))
            .title(Component.translatable("creative.tutorial_tab")) // must translate
            .displayItems((itemDisplayParameters, output) -> {

            // ADD ITEMS HERE, Order Matters

                //materials
                output.accept((Moditems.SAPPHIRE.get()));
                output.accept((Moditems.RAW_SAPPHIRE.get()));
                output.accept((Items.DIAMOND));
                output.accept((Moditems.PINE_CONE.get()));

                //Items
                output.accept(Moditems.METAL_DETECTOR.get());
                output.accept(Moditems.SAPPHIRE_STAFF.get());
                output.accept(Moditems.SAPPHIRE_SWORD.get());
                output.accept(Moditems.SAPPHIRE_HOE.get());
                output.accept(Moditems.SAPPHIRE_AXE.get());
                output.accept(Moditems.SAPPHIRE_PICKAXE.get());
                output.accept(Moditems.SAPPHIRE_SHOVEL.get());



                //Blocks
                output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                output.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                output.accept(ModBlocks.REDISOLD.get());
                output.accept(ModBlocks.SAPPHIRE_ORE.get());
                output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                output.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                output.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());
                output.accept(ModBlocks.SOUND_BLOCK.get());

                //non-block blocks

                output.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                output.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
                output.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                output.accept(ModBlocks.SAPPHIRE_DOOR.get());
                output.accept(ModBlocks.SAPPHIRE_SLAB.get());
                output.accept(ModBlocks.SAPPHIRE_FENCE.get());
                output.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                output.accept(ModBlocks.SAPPHIRE_WALL.get());
                output.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());

            })
            .build());

    public static final RegistryObject<CreativeModeTab> TESTING_TAB = CREATIVE_MODE_TABS.register("testing_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.BLUE_BEAN.get()))
                    .title(Component.translatable("creative.testing_tab")) // must translate
                    .displayItems((itemDisplayParameters, output) -> {

                        // ADD ITEMS HERE, Order Matters

                        //food Items
                        output.accept(Moditems.BEAPER.get());
                        output.accept(Moditems.BLUE_BEAN.get());
                        output.accept(Moditems.STRAWBERRY.get());

                        //food blocks
                        output.accept(ModBlocks.BLUE_BEAN_BLOCK.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
