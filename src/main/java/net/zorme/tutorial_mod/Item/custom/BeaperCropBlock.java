package net.zorme.tutorial_mod.Item.custom;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.zorme.tutorial_mod.Item.Moditems;

public class BeaperCropBlock extends CropBlock {
    public static  final int MAX_AGE = 7; //can change the ages // if go above 7 need to changed the VoxelShape
    public static  final IntegerProperty AGE = BlockStateProperties.AGE_7; // Inetger Property allows different blocks to have different age

    public BeaperCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return Moditems.BEAPER_SEED.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
         pBuilder.add(AGE);
    }
}
