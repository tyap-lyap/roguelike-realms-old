package net.sfedunet.mixin;

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
                tagbook = StringNbtReader.parse("{pages:['{\"text\":\"\u0417\u0434\u0440\u0430\u0432\u0441\u0442\u0432\u0443\u0439, \u0447\u0435\u043b\u043e\u0432\u0435\u043a. \u0422\u044b \u0441\u043c\u043e\u0433 \u043f\u043e\u0431\u0435\u0434\u0438\u0442\u044c \u044d\u043d\u0434\u0435\u0440 \u0434\u0440\u0430\u043a\u043e\u043d\u0430, \u044d\u0442\u043e \u043f\u043e\u0445\u0432\u0430\u043b\u044c\u043d\u043e, \u043d\u043e \u044d\u0442\u043e \u0435\u0449\u0435 \u043d\u0435 \u043a\u043e\u043d\u0435\u0446. \u0414\u0443\u0448\u0438 \u043f\u043e\u0433\u0438\u0431\u0448\u0438\u0445 \u044d\u043d\u0434\u0435\u0440\u043c\u0435\u043d\u043e\u0432 \u043e\u0442\u043f\u0440\u0430\u0432\u0438\u043b\u0438\u0441\u044c \u0432 \u0438\u0441\u0442\u043e\u0447\u043d\u0438\u043a \u0434\u0443\u0448 \u0438 \u0425\u0440\u0430\u043d\u0438\u0442\u0435\u043b\u044c \u043d\u0435 \u0445\u043e\u0447\u0435\u0442 \u043f\u043e\u0437\u0432\u043e\u043b\u0438\u0442\u044c \u044d\u0442\u0438\u043c \u0434\u0443\u0448\u0430\u043c \u043f\u0435\u0440\u0435\u0440\u043e\u0434\u0438\u0442\u044c\u0441\u044f \u043b\u044e\u0434\u044c\u043c\u0438.\"}','{\"text\":\"\u0415\u0441\u043b\u0438 \u0442\u044b \u0438 \u043f\u0440\u0430\u0432\u0434\u0430 \u0445\u043e\u0447\u0435\u0448\u044c \u043f\u043e\u043c\u043e\u0447\u044c \u044d\u043d\u0434\u0435\u0440\u043c\u0435\u043d\u0430\u043c, \u0442\u0435\u0431\u0435 \u0441\u043b\u0435\u0434\u0443\u0435\u0442 \u043e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c\u0441\u044f \u043a \u0425\u0440\u0430\u043d\u0438\u0442\u0435\u043b\u044e \u0414\u0443\u0448 \u0438 \u043f\u043e\u0431\u0435\u0434\u0438\u0442\u044c \u0435\u0433\u043e, \u0442\u043e\u0433\u0434\u0430 \u0434\u0443\u0448\u0438 \u0441\u043c\u043e\u0433\u0443\u0442 \u043f\u0435\u0440\u0435\u0440\u043e\u0434\u0438\u0442\u044c\u0441\u044f, \u043d\u043e \u0434\u043b\u044f \u044d\u0442\u043e\u0433\u043e \u0442\u0435\u0431\u0435 \u043d\u0430\u0434\u043e \u043f\u0435\u0440\u0435\u0441\u0435\u0447\u044c 8 \u0438\u0437\u043c\u0435\u0440\u0435\u043d\u0438\u0439 \u0438 \u0432 9 \u0442\u044b \u0432\u0441\u0442\u0440\u0435\u0442\u0438\u0448\u044c \u0435\u0433\u043e.\"}'],title:\"Записка 1\",author:Omniscient,display:{Lore:[\"Лор\"]}}");
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