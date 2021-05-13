package net.sfedunet.roguelikerealms.world.structure;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.sfedunet.roguelikerealms.block.RoguelikeRealmsBlocks;

import java.util.List;
import java.util.Random;

public class DraconicWellGenerator {
    private static final Identifier WELL = new Identifier("anyitem:draconic_shadow/well");

    public static void addPieces(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces, Random random) {

        pieces.add(new Piece(manager, pos, WELL, rotation));
    }

    public static class Piece extends SimpleStructurePiece {
        private final BlockRotation rotation;
        private final Identifier template;

        public Piece(StructureManager structureManager, CompoundTag compoundTag) {
            super(RoguelikeRealmsStructures.WELL_PIECE, compoundTag);
            this.template = new Identifier(compoundTag.getString("Template"));
            this.rotation = BlockRotation.valueOf(compoundTag.getString("Rot"));
            this.initializeStructureData(structureManager);
        }

        public Piece(StructureManager structureManager, BlockPos pos, Identifier template, BlockRotation rotation) {
            super(RoguelikeRealmsStructures.WELL_PIECE, 0);
            this.pos = pos;
            this.rotation = rotation;
            this.template = template;

            this.initializeStructureData(structureManager);
        }

        public boolean generate(StructureWorldAccess structureWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
                StructurePlacementData structurePlacementData = (new StructurePlacementData()).setRotation(this.rotation).setMirror(BlockMirror.NONE).addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);;
                boolean bl = super.generate(structureWorldAccess, structureAccessor, chunkGenerator, random, boundingBox, chunkPos, blockPos);

                    structureWorldAccess.setBlockState(this.pos.add(Structure.transform(structurePlacementData, new BlockPos(2, -1, 1))), RoguelikeRealmsBlocks.DRAGON_STONE_TILES.getDefaultState(), 0);
                    structureWorldAccess.setBlockState(this.pos.add(Structure.transform(structurePlacementData, new BlockPos(1, -1, 2))), RoguelikeRealmsBlocks.DRAGON_STONE_TILES.getDefaultState(), 0);
                    structureWorldAccess.setBlockState(this.pos.add(Structure.transform(structurePlacementData, new BlockPos(1, -1, 1))), RoguelikeRealmsBlocks.DRAGON_STONE_TILES.getDefaultState(), 0);
                    structureWorldAccess.setBlockState(this.pos.add(Structure.transform(structurePlacementData, new BlockPos(2, -1, 2))), RoguelikeRealmsBlocks.DRAGON_STONE_TILES.getDefaultState(), 0);

                return bl;
            }

        private void initializeStructureData(StructureManager structureManager) {
            Structure structure = structureManager.getStructureOrBlank(this.template);
            StructurePlacementData placementData = (new StructurePlacementData())
                    .setRotation(this.rotation)
                    .setMirror(BlockMirror.NONE)
                    .addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
            this.setStructureData(structure, this.pos, placementData);
        }

        protected void toNbt(CompoundTag tag) {
            super.toNbt(tag);
            tag.putString("Template", this.template.toString());
            tag.putString("Rot", this.rotation.name());
        }

        @Override
        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess serverWorldAccess, Random random,
                                      BlockBox boundingBox) {
        }
    }
}