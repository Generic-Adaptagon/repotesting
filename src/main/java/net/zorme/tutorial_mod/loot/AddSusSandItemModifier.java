package net.zorme.tutorial_mod.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

//addes one Item
public class AddSusSandItemModifier extends LootModifier {

    public static final Supplier<Codec<AddSusSandItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec()
            .fieldOf("item").forGetter(m -> m.item)).apply(inst, AddSusSandItemModifier::new)));
    private final Item item;



    public AddSusSandItemModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        //when specific loot table generated the generatedloot return same loot table changes

        for (LootItemCondition condition : this.conditions) // this adds conditions to what loot it needed
            if (!condition.test(lootContext)) {
                return generatedLoot;
            }

        if (lootContext.getRandom().nextFloat() < 0.05) {//FIXME its too low %
            generatedLoot.clear();//clears loot REQUIRED
            generatedLoot.add(new ItemStack(this.item)); // adds the loot plus the custom loot
        }

        generatedLoot.add(new ItemStack(this.item)); // adds the loot in AddItem Modifier
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
