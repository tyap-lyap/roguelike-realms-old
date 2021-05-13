package net.sfedunet.roguelikerealms.data;

import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.minecraft.util.Identifier;
import net.sfedunet.roguelikerealms.block.RoguelikeRealmsBlocks;
import net.sfedunet.roguelikerealms.interfaces.IBlockModel;

public class RRBlockResources {
    
    public static void init(RuntimeResourcePack pack){

        RoguelikeRealmsBlocks.getBlocks().forEach((id, block) -> {

            if (block instanceof IBlockModel) {
                String parent = ((IBlockModel) block).getParent();

                switch (parent) {
                    case "cube_all":
                        cubeAllBlock(pack, id);
                        break;
                    case "cube_bottom_top":
                        cubeBottomTopBlock(pack, id);
                        break;
                    case "custom_model":
                        addItemAndBlockstate(pack, id);
                        break;
                    case "cross":
                        crossBlock(pack, id);
                        break;
                    case "cube_column":
                        cubeColumnBlock(pack, id);
                        break;
                }
            }

        });
        
    }

    static void cubeAllBlock(RuntimeResourcePack pack, Identifier id){

        pack.addModel(JModel.model().parent("minecraft:block/cube_all")
                        .textures(JModel.textures().var("all", "roguelikerealms:block/" + id.getPath())),
                new Identifier("roguelikerealms:block/" + id.getPath()));

        addItemAndBlockstate(pack, id);
    }

    static void cubeBottomTopBlock(RuntimeResourcePack pack, Identifier id){

        pack.addModel(JModel.model().parent("minecraft:block/cube_bottom_top")
                        .textures(JModel.textures()
                                .var("top", "roguelikerealms:block/" + id.getPath() + "_top")
                                .var("bottom", "roguelikerealms:block/" + id.getPath() + "_top")
                                .var("side", "roguelikerealms:block/" + id.getPath())),
                new Identifier("roguelikerealms:block/" + id.getPath()));

        addItemAndBlockstate(pack, id);
    }

    static void crossBlock(RuntimeResourcePack pack, Identifier id){

        pack.addModel(JModel.model().parent("minecraft:block/cross")
                        .textures(JModel.textures().var("cross", "roguelikerealms:block/" + id.getPath())),
                new Identifier("roguelikerealms:block/" + id.getPath()));

        pack.addModel(JModel.model().parent("minecraft:item/generated")
                        .textures(JModel.textures().var("layer0", "roguelikerealms:block/" + id.getPath())),
                new Identifier("roguelikerealms:item/" + id.getPath()));

        pack.addBlockState(JState
                        .state(JState.variant(JState.model("roguelikerealms:block/" + id.getPath()))),
                id);
    }

    static void cubeColumnBlock(RuntimeResourcePack pack, Identifier id){

        pack.addModel(JModel.model().parent("minecraft:block/cube_column")
                        .textures(JModel.textures()
                                .var("end", "roguelikerealms:block/" + id.getPath() + "_top")
                                .var("side", "roguelikerealms:block/" + id.getPath())),
                new Identifier("roguelikerealms:block/" + id.getPath()));

        addItemAndBlockstate(pack, id);

    }

    static void addItemAndBlockstate(RuntimeResourcePack pack, Identifier id){

        pack.addModel(JModel.model()
                        .parent("roguelikerealms:block/" + id.getPath()),
                new Identifier("roguelikerealms:item/" + id.getPath()));

        pack.addBlockState(JState
                        .state(JState.variant(JState.model("roguelikerealms:block/" + id.getPath()))),
                id);
    }
    
}
