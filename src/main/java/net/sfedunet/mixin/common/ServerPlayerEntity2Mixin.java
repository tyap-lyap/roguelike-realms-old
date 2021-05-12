package net.sfedunet.mixin.common;

import net.minecraft.server.network.ServerPlayerEntity;
import net.sfedunet.interfaces.Reincarnation;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntity2Mixin implements Reincarnation {

    private boolean canReincarnate;

    @Override
    public boolean canReincarnate() {
        return canReincarnate;
    }

    @Override
    public void setCanReincarnate(boolean canReincarnate) {

        this.canReincarnate = canReincarnate;
    }
}
