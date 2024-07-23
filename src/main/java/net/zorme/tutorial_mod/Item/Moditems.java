package net.zorme.tutorial_mod.Item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zorme.tutorial_mod.Item.custom.FuelItem;
import net.zorme.tutorial_mod.Item.custom.MetalDetectorItem;
import net.zorme.tutorial_mod.tutorial_mod;

public class Moditems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, tutorial_mod.MOD_ID);
    //log listof items. when added it loads items?

    //add item
    public static final RegistryObject <Item> SAPPHIRE =  ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject <Item>  RAW_SAPPHIRE = ITEMS.register("raw_sapphire", () -> new  Item(new Item.Properties()));
    public static final RegistryObject <Item>  DEBIT_CARD = ITEMS.register("debit_card", () -> new  Item(new Item.Properties()));

    public static final RegistryObject <Item>  METAL_DETECTOR = ITEMS.register("metal_detector", () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject <Item>  STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject <Item>  SAPPHIRE_STAFF = ITEMS.register("sapphire_staff", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject <Item>  BEAPER = ITEMS.register("beaper", () -> new  Item(new Item.Properties().food(ModFoods.BEAPER).stacksTo(64)));
    public static final RegistryObject <Item>  BLUE_BEAN = ITEMS.register("blue_bean", () -> new  Item(new Item.Properties().food(ModFoods.BLUE_BEAN)));
    public static final RegistryObject <Item> PINE_CONE = ITEMS.register("pine_cone", () -> new FuelItem(new Item.Properties(), 400));
    public static final RegistryObject <Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SwordItem(ModToolTeirs.SAPPHIRE, 4, 2,new Item.Properties()));
    public static final RegistryObject <Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new PickaxeItem(ModToolTeirs.SAPPHIRE, 2, 1,new Item.Properties()));
    public static final RegistryObject <Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new ShovelItem(ModToolTeirs.SAPPHIRE, 1, 1,new Item.Properties()));
    public static final RegistryObject <Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new HoeItem(ModToolTeirs.SAPPHIRE, 2, 1,new Item.Properties()));
    public static final RegistryObject <Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new AxeItem(ModToolTeirs.SAPPHIRE, 5, 1,new Item.Properties()));



    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
