package proclient.module.hud;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import proclient.module.Category;
import proclient.module.RenderModule;

public class TargetHud extends RenderModule {
    private EntityLivingBase target;
    public TargetHud() {
        super("TargetHud", KeyboardConstants.KEY_NONE, Category.HUD, 50, 50, 70, 30);
    }

    public void draw() {
		target = (EntityLivingBase) mc.pointedEntity;
	    if(target != null) {
        Gui.drawRect(this.x, this.y - 1, this.x + ((int) target.getMaxHealth() * 6) + 10, this.y, 0xFF20FF20);
        Gui.drawRect(x, y, x + (int) target.getMaxHealth() * 6 + 10, y + height, 0x90000000);

        int color = 0xFF20FF20;

        if (target.getHealth() >= 13)
          color = 0xFF20FF20;
        else if (target.getHealth() < 13 && target.getHealth() > 7)
          color = 0xFFFFFF20;
        else if (target.getHealth() < 8)
          color = 0xFFFF2020;

        Gui.drawRect(this.x + 30, this.y + 16, this.x + 30 + (double) target.getHealth() * 4.7f, this.y + 30, color);
          mc.fontRendererObj.drawStringWithShadow(target.getName(), this.x + 30, this.y + 4, -1);
          mc.fontRendererObj.drawStringWithShadow("", target.getHealth() / 2, this.x + 30 + (target.getMaxHealth() * 4.7f) / 2 - mc.fontRendererObj.getStringWidth("%%%%%%"), -1);

        GuiInventory.drawEntityOnScreen(x + 14, y + 46, 22, target.rotationYaw, target.rotationPitch, target);
    }
  }
}
