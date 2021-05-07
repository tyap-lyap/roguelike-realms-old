package net.sfedunet.mixin.common;

import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sfedunet.world.dimension.DraconicShadow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity implements ScreenHandlerListener {
    private boolean addDraconBook;

    public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(world, pos, yaw, profile);
    }

    @Shadow
    public ServerWorld getServerWorld() {
        return (ServerWorld) this.world;
    }

    @Inject(at = @At("HEAD"), method = "writeCustomDataToTag")
    public void writeCustomDataToTag(CompoundTag tag, CallbackInfo ci) {
        tag.putBoolean("AddDraconBook", this.addDraconBook);
    }

    @Inject(at = @At("HEAD"), method = "readCustomDataFromTag")
    public void readCustomDataFromTag(CompoundTag tag, CallbackInfo ci) {
        this.addDraconBook = tag.getBoolean("AddDraconBook");
    }

    @Inject(method = "moveToWorld", at = @At("HEAD"), cancellable = true)
    public void moveToWorld(ServerWorld destination, CallbackInfoReturnable<Entity> cir) {

        if (destination.getRegistryKey() == DraconicShadow.DRACONIC_SHADOW && !this.addDraconBook) {

            ItemStack Draconbook = new ItemStack(Items.WRITTEN_BOOK);

            CompoundTag tagbook = Draconbook.getTag();

            try {
                tagbook = StringNbtReader.parse("{pages:['\u0418\u0442\u0430\u043a, \u044d\u0442\u043e \u0434\u0440\u0430\u043a\u043e\u043d\u0438\u0439 \u043c\u0438\u0440, \u0437\u0434\u0435\u0441\u044c \u0442\u0435\u0431\u0435 \u043f\u0440\u0435\u0434\u0441\u0442\u043e\u0438\u0442 \u043d\u0430\u0439\u0442\u0438 \u0417\u043e\u0440\u0430\u043b\u0430\u043a\u0430 \u0438 \u0443\u0431\u0438\u0442\u044c \u0435\u0433\u043e, \u043b\u0438\u0431\u043e \u0442\u044b \u043c\u043e\u0436\u0435\u0448\u044c \u043f\u043e\u043f\u044b\u0442\u0430\u0442\u044c\u0441\u044f \u043f\u043e\u043f\u0430\u0441\u0442\u044c \u0432 \u043d\u0435\u0441\u0442\u0430\u0431\u0438\u043b\u044c\u043d\u043e\u0435 \u0438\u0437\u043c\u0435\u0440\u0435\u043d\u0438\u0435 \u0438 \u0442\u0430\u043c \u0437\u0430\u0431\u0440\u0430\u0442\u044c \u043e\u0441\u043a\u043e\u043b\u043e\u043a \u00a7r\u00a70k \u0417\u0430\u0431\u044b\u0442\u043e\u0433\u043e \u0438 \u0441 \u043f\u043e\u043c\u043e\u0449\u044c\u044e \u043d\u0435\u0433\u043e \u0432 \u0434\u0430\u043b\u044c\u043d\u0435\u0439\u0448\u0435\u043c \u0441\u043e\u0431\u0440\u0430\u0442\u044c \u0437\u043e\u0432 \u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u043f\u043e\u0440\u0442\u0430\u043b...'],title:\"Записка 1\",author:Omniscient,display:{Lore:[\"Лор\"]}}");
            } catch (CommandSyntaxException e) {
                e.printStackTrace();
            }

            Draconbook.setTag(tagbook);

        this.inventory.offerOrDrop(world, Draconbook);

        }
          this.addDraconBook = true;
    }

        @Inject(at = @At("HEAD"), method = "copyFrom")
        public void copyFrom (ServerPlayerEntityMixin oldPlayer,boolean alive, CallbackInfo ci){

              this.addDraconBook = oldPlayer.addDraconBook;

        }
    }