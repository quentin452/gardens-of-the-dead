package gardensofthedead.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.eventbus.api.Event;

import java.util.function.Supplier;

public class SoulBlightFungusBlock extends BushBlock implements BonemealableBlock {

    protected static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 13, 12);
    private static final double BONEMEAL_SUCCESS_PROBABILITY = 0.4D;
    private final Supplier<Holder<ConfiguredFeature<HugeFungusConfiguration, ?>>> feature;

    public SoulBlightFungusBlock(BlockBehaviour.Properties properties, Supplier<Holder<ConfiguredFeature<HugeFungusConfiguration, ?>>> feature) {
        super(properties);
        this.feature = feature;
    }

    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.NYLIUM) || state.is(Blocks.MYCELIUM) || state.is(Blocks.SOUL_SOIL) || super.mayPlaceOn(state, level, pos);
    }

    public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean isClient) {
        Block block = (feature.get().value().config()).validBaseState.getBlock();
        BlockState blockstate = level.getBlockState(pos.below());
        return blockstate.is(block);
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState state) {
        return randomSource.nextFloat() < BONEMEAL_SUCCESS_PROBABILITY;
    }

    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos pos, BlockState state) {
        Event.Result result = ForgeEventFactory.blockGrowFeature(level, randomSource, pos, feature.get()).getResult();
        if (!result.equals(Event.Result.DENY)) {
            feature.get().value().place(level, level.getChunkSource().getGenerator(), randomSource, pos);
        }
    }
}
