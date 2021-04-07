package net.sfedunet.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.sfedunet.world.structure.DraconicBoneGenerator;

import java.util.Random;

public class DraconicBoneFeature extends StructureFeature<DefaultFeatureConfig> {
    public DraconicBoneFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return Start::new;
    }

    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long l, ChunkRandom chunkRandom, int i, int j, Biome biome, ChunkPos chunkPos, DefaultFeatureConfig defaultFeatureConfig) {
        return getGenerationHeight(i, j, chunkGenerator) >= 40;
    }

    private static int getGenerationHeight(int chunkX, int chunkZ, ChunkGenerator chunkGenerator) {
        Random random = new Random((long) (chunkX + chunkZ * 10387313));
        BlockRotation blockRotation = BlockRotation.random(random);
        int i = 5;
        int j = 5;
        if (blockRotation == BlockRotation.CLOCKWISE_90) {
            i = -5;
        } else if (blockRotation == BlockRotation.CLOCKWISE_180) {
            i = -5;
            j = -5;
        } else if (blockRotation == BlockRotation.COUNTERCLOCKWISE_90) {
            j = -5;
        }

        int k = (chunkX << 4) + 13;
        int l = (chunkZ << 4) + 7;
        int m = chunkGenerator.getHeightInGround(k, l, Heightmap.Type.WORLD_SURFACE_WG);
        int n = chunkGenerator.getHeightInGround(k, l + j, Heightmap.Type.WORLD_SURFACE_WG);
        int o = chunkGenerator.getHeightInGround(k + i, l, Heightmap.Type.WORLD_SURFACE_WG);
        int p = chunkGenerator.getHeightInGround(k + i, l + j, Heightmap.Type.WORLD_SURFACE_WG);
        return Math.min(Math.min(m, n), Math.min(o, p));
    }

    public static class Start extends StructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references,
                     long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, int chunkX,
                         int chunkZ, Biome biome, DefaultFeatureConfig config) {
            int x = chunkX;
            int z = chunkZ;
            int y = DraconicBoneFeature.getGenerationHeight(x,z,chunkGenerator);
            BlockRotation rotation = BlockRotation.random(this.random);
            if (y >= 40) {
                BlockPos pos = new BlockPos(x * 16 + 8, y, z * 16 + 8);
                DraconicBoneGenerator.addPieces(manager, pos, rotation, this.children, random);
                this.setBoundingBoxFromChildren();
            }
        }
    }
}
