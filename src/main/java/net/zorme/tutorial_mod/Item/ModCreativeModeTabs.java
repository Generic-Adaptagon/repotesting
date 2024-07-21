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
                output.accept((Moditems.DEBIT_CARD.get()));



                //Blocks
                output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                output.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                output.accept(ModBlocks.REDISOLD.get());
                output.accept(ModBlocks.SAPPHIRE_ORE.get());
                output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                output.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                output.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());


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

                        //food blocks
                        output.accept(ModBlocks.BLUE_BEAN_BLOCK.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
