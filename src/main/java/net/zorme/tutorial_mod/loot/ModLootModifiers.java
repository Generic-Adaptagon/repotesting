package net.zorme.tutorial_mod.loot;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zorme.tutorial_mod.tutorial_mod;

public class ModLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALZIERS =
                    DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, tutorial_mod.MOD_ID);


    public static RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
            LOOT_MODIFIER_SERIALZIERS.register("add_item", AddItemModifier.CODEC); //modified registered //new file provider in datagen called: ModGlobalLootModifiersProvider

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALZIERS.register(eventBus);

    }

}
