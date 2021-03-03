package net.sfedunet.world.features.trees.placers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.sfedunet.block.AnyItemsBlocks;
import net.sfedunet.world.features.trees.AnyTrees;

import java.util.Random;
import java.util.Set;

public class DragonGrapeFoliagePlacer extends FoliagePlacer {

    public static final Codec<DragonGrapeFoliagePlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillFoliagePlacerFields(instance).apply(instance, DragonGrapeFoliagePlacer::new));

    public DragonGrapeFoliagePlacer(UniformIntDistribution radius, UniformIntDistribution offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return AnyTrees.DRAGON_GRAPE_FOLIAGE;
    }

    @Override
    protected void generate(ModifiableTestableWorld world, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, Set<BlockPos> leaves, int offset, BlockBox box) {
        if(radius <= 3)
            radius = 3;
        radius -= treeNode.getFoliageRadius();
        BlockPos nodePos = treeNode.getCenter();
        BlockState leafBlock = config.leavesProvider.getBlockState(random, nodePos);
        BlockState hanger = AnyItemsBlocks.DRAGON_GRAPE_VINES.getDefaultState();
        BlockState grapedHanger = AnyItemsBlocks.GRAPED_DRAGON_GRAPE_VINES.getDefaultState();
        BlockState hangerTip = AnyItemsBlocks.DRAGON_GRAPE_VINES_TIP.getDefaultState();

        for(int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                for (int k = 0; k < radius; k++) {
                    BlockPos offPos = nodePos.add(i, k, j);
                    if((world.testBlockState(offPos, AbstractBlock.AbstractBlockState::isAir) || TreeFeature.canReplace(world, offPos)) && offPos.isWithinDistance(nodePos, radius)) {
                        world.setBlockState(offPos, leafBlock, 19);
                        leaves.add(offPos);
                    }
                }
            }
        }
        int flip = random.nextInt();
        for (int i = -radius; i < radius; i++) {
            for (int j = -radius; j < radius; j++) {
                BlockPos offPos = nodePos.add(i, 0, j);
                if(leaves.contains(offPos)) {
                    int cap = random.nextInt(Math.max(trunkHeight - (flip % 2 == 0 ? 2 : 0), 1));
                    flip++;
                    int lonke = 0;
                    if(cap > 1)
                        lonke = random.nextInt(cap + 1);
                    if(offPos.getManhattanDistance(nodePos) >= radius - 1)
                        cap++;
                    for (int k = 1; k < cap; k++) {
                        BlockPos hangPos = offPos.down(k);
                        if(!world.testBlockState(hangPos, state -> state.isFullCube((BlockView) world, hangPos))) {
                            if(world.testBlockState(hangPos.down(), AbstractBlock.AbstractBlockState::isAir) || TreeFeature.canReplace(world, hangPos)) {
                                world.breakBlock(hangPos, false);
                                if(k <= lonke)
                                    world.setBlockState(hangPos, leafBlock, 19);
                                else if(k == cap - 1)
                                    world.setBlockState(hangPos, hangerTip, 19);
                                else
                                    if(random.nextInt(2) == 0)
                                        world.setBlockState(hangPos, hanger, 19);
                                    else
                                        world.setBlockState(hangPos, grapedHanger, 19);
                            }
                            else
                                break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int baseHeight, int dx, int y, int dz, boolean giantTrunk) {
        return false;
    }
}