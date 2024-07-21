package net.zorme.tutorial_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zorme.tutorial_mod.Item.ModCreativeModeTabs;
import net.zorme.tutorial_mod.Item.Moditems;
import net.zorme.tutorial_mod.blocks.ModBlocks;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(tutorial_mod.MOD_ID)
public class tutorial_mod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tutorial_mod";
    // Directly reference a slf4j logger owo
    private static final Logger LOGGER = LogUtils.getLogger();

    public tutorial_mod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Register the creative mode tab
        ModCreativeModeTabs.register(modEventBus);
        //Register the Items
        Moditems.register(modEventBus);
        //register the Blocks
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);// this is a listener and it makes sure the tab is in the game?


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(Moditems.SAPPHIRE); // adds to creative tab Ingerdients
            event.accept(Moditems.RAW_SAPPHIRE); // adds to creative tab Ingerdients

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)   {

        }
    }
}
