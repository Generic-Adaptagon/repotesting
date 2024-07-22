package net.zorme.tutorial_mod.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import net.zorme.tutorial_mod.Item.custom.MetalDetectorItem;
import net.zorme.tutorial_mod.tutorial_mod;

public class Moditems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, tutorial_mod.MOD_ID);
    //log listof items. when added it loads items?

    //add item
    public static final RegistryObject <Item> SAPPHIRE =  ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject <Item>  RAW_SAPPHIRE = ITEMS.register("raw_sapphire", () -> new  Item(new Item.Properties()));
    public static final RegistryObject <Item>  BEAPER = ITEMS.register("beaper", () -> new  Item(new Item.Properties()));
    public static final RegistryObject <Item>  BLUE_BEAN = ITEMS.register("blue_bean", () -> new  Item(new Item.Properties()));
    public static final RegistryObject <Item>  DEBIT_CARD = ITEMS.register("debit_card", () -> new  Item(new Item.Properties()));
    public static final RegistryObject <Item>  METAL_DETECTOR = ITEMS.register("metal_detector", () -> new MetalDetectorItem(new Item.Properties().durability(100)));


    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
