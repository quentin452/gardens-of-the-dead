package gardensofthedead.data;

import gardensofthedead.GardensOfTheDead;
import gardensofthedead.common.init.ModBlocks;
import gardensofthedead.common.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockTags extends BlockTagsProvider {

    public BlockTags(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, GardensOfTheDead.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).addTag(
                ModTags.Blocks.SOULBLIGHT_STEMS
        ).add(
                ModBlocks.SOULBLIGHT_PLANKS.get(),
                ModBlocks.SOULBLIGHT_SLAB.get(),
                ModBlocks.SOULBLIGHT_PRESSURE_PLATE.get(),
                ModBlocks.SOULBLIGHT_FENCE.get(),
                ModBlocks.SOULBLIGHT_TRAPDOOR.get(),
                ModBlocks.SOULBLIGHT_FENCE_GATE.get(),
                ModBlocks.SOULBLIGHT_STAIRS.get(),
                ModBlocks.SOULBLIGHT_BUTTON.get(),
                ModBlocks.SOULBLIGHT_DOOR.get(),
                ModBlocks.SOULBLIGHT_SIGN.get(),
                ModBlocks.SOULBLIGHT_WALL_SIGN.get()
        );

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_HOE).add(
                ModBlocks.BLIGHTWART_BLOCK.get()
        );

        // noinspection ConstantConditions
        tag(net.minecraft.tags.BlockTags.FLOWER_POTS).add(
                ForgeRegistries.BLOCKS.getValues()
                        .stream()
                        .filter(block -> ForgeRegistries.BLOCKS.getKey(block).getPath().equals(GardensOfTheDead.MODID))
                        .filter(block -> block instanceof FlowerPotBlock)
                        .toArray(Block[]::new)
        );

        tag(net.minecraft.tags.BlockTags.ENDERMAN_HOLDABLE).add(
                ModBlocks.SOULBLIGHT_FUNGUS.get(),
                ModBlocks.SOULBLIGHT_SPROUTS.get()
        );

        tag(ModTags.Blocks.SOULBLIGHT_STEMS).add(
                ModBlocks.SOULBLIGHT_STEM.get(),
                ModBlocks.STRIPPED_SOULBLIGHT_STEM.get(),
                ModBlocks.SOULBLIGHT_HYPHAE.get(),
                ModBlocks.STRIPPED_SOULBLIGHT_HYPHAE.get()
        );

        tag(net.minecraft.tags.BlockTags.NON_FLAMMABLE_WOOD).addTag(
                ModTags.Blocks.SOULBLIGHT_STEMS
        ).add(
                ModBlocks.SOULBLIGHT_PLANKS.get(),
                ModBlocks.SOULBLIGHT_SLAB.get(),
                ModBlocks.SOULBLIGHT_PRESSURE_PLATE.get(),
                ModBlocks.SOULBLIGHT_FENCE.get(),
                ModBlocks.SOULBLIGHT_TRAPDOOR.get(),
                ModBlocks.SOULBLIGHT_FENCE_GATE.get(),
                ModBlocks.SOULBLIGHT_STAIRS.get(),
                ModBlocks.SOULBLIGHT_BUTTON.get(),
                ModBlocks.SOULBLIGHT_DOOR.get(),
                ModBlocks.SOULBLIGHT_SIGN.get(),
                ModBlocks.SOULBLIGHT_WALL_SIGN.get()
        );

        tag(net.minecraft.tags.BlockTags.LOGS).addTag(
                ModTags.Blocks.SOULBLIGHT_STEMS
        );

        tag(net.minecraft.tags.BlockTags.WART_BLOCKS).add(
                ModBlocks.BLIGHTWART_BLOCK.get()
        );

        tag(net.minecraft.tags.BlockTags.WOODEN_FENCES).add(
                ModBlocks.SOULBLIGHT_FENCE.get()
        );

        tag(Tags.Blocks.FENCES_WOODEN).add(
                ModBlocks.SOULBLIGHT_FENCE.get()
        );

        tag(net.minecraft.tags.BlockTags.FENCE_GATES).add(
                ModBlocks.SOULBLIGHT_FENCE_GATE.get()
        );

        tag(Tags.Blocks.FENCE_GATES_WOODEN).add(
                ModBlocks.SOULBLIGHT_FENCE_GATE.get()
        );

        tag(net.minecraft.tags.BlockTags.WOODEN_BUTTONS).add(
                ModBlocks.SOULBLIGHT_BUTTON.get()
        );

        tag(net.minecraft.tags.BlockTags.PLANKS).add(
                ModBlocks.SOULBLIGHT_PLANKS.get()
        );

        tag(net.minecraft.tags.BlockTags.WOODEN_PRESSURE_PLATES).add(
                ModBlocks.SOULBLIGHT_PRESSURE_PLATE.get()
        );

        tag(net.minecraft.tags.BlockTags.STANDING_SIGNS).add(
                ModBlocks.SOULBLIGHT_SIGN.get()
        );

        tag(net.minecraft.tags.BlockTags.WALL_SIGNS).add(
                ModBlocks.SOULBLIGHT_WALL_SIGN.get()
        );

        tag(net.minecraft.tags.BlockTags.WOODEN_SLABS).add(
                ModBlocks.SOULBLIGHT_SLAB.get()
        );

        tag(net.minecraft.tags.BlockTags.WOODEN_DOORS).add(
                ModBlocks.SOULBLIGHT_DOOR.get()
        );

        tag(net.minecraft.tags.BlockTags.WOODEN_TRAPDOORS).add(
                ModBlocks.SOULBLIGHT_TRAPDOOR.get()
        );

        tag(net.minecraft.tags.BlockTags.WOODEN_STAIRS).add(
                ModBlocks.SOULBLIGHT_STAIRS.get()
        );
    }
}
