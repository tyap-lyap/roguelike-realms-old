package net.sfedunet.roguelikerealms.data;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.sfedunet.roguelikerealms.RoguelikeRealmsMod;

public class RRResources {

    public static final RuntimeResourcePack RESOURCES = RuntimeResourcePack.create(RoguelikeRealmsMod.MODID + ":resources");

    public static void init(){

        RRBlockResources.init(RESOURCES);

        RRPCallback.EVENT.register(resources -> resources.add(RESOURCES));

    }
}
