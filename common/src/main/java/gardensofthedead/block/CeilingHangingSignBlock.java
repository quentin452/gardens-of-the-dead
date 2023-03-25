package gardensofthedead.block;

import gardensofthedead.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class CeilingHangingSignBlock extends net.minecraft.world.level.block.CeilingHangingSignBlock {

    public CeilingHangingSignBlock(Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState blockState) {
        return ModBlockEntityTypes.HANGING_SIGN.get().create(pos, blockState);
    }
}
