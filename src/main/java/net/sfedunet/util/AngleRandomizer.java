package net.sfedunet.util;

import net.minecraft.util.math.MathHelper;

public class AngleRandomizer {
    public double value;
   private double speed;
   private long lastUpdateTime;

   public AngleRandomizer() {
   }

    public boolean shouldUpdate(long time) {
       return this.lastUpdateTime != time;
   }

    public void update(long time, double d) {
       this.lastUpdateTime = time;
       double e = d - this.value;
       e = MathHelper.floorMod(e + 0.5D, 1.0D) - 0.5D;
       this.speed += e * 0.1D;
       this.speed *= 0.8D;
       this.value = MathHelper.floorMod(this.value + this.speed, 1.0D);
   }
}