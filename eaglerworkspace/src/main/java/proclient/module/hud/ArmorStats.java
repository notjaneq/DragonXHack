package proclient.module.hud;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import proclient.module.Category;
import proclient.module.RenderModule;

public class ArmorStats extends RenderModule {
    public ArmorStats() {
        super("ArmorStats", KeyboardConstants.KEY_NONE, Category.HUD, 525, 10, 10, 10);
    }

    private void getArmorValues() {
        int number = 3;

        int iValue = 0;

        for(int i = 0; i < Minecraft.getMinecraft().thePlayer.inventory.armorInventory.length; i++) {
            ItemStack itemStack = Minecraft.getMinecraft().thePlayer.inventory.armorInventory[i];
            renderArmor(number - i, itemStack);
            ++iValue;
        }
    }

    private void renderArmor(int i, ItemStack is) {
        if(is != null) {
            GlStateManager.pushMatrix();
            int yValue = this.y + this.getHeight() * i * 2;
            int xValue = this.x;
            if(is.getItem().isDamageable()) {
                double damage = (double)(is.getMaxDamage() - is.getItemDamage()) / (double)is.getMaxDamage() * 100.0D;
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("%" + Math.round(damage), (float)(this.x + 20), (float)(this.y + this.getHeight() * i * 2 + 4), -1);
            } else {
                String number = String.valueOf(is.stackSize);
                if(!number.equals("1") && !number.equals("0")) {
                    Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(number, (float)(this.x + 20), (float)(this.y + this.getHeight() * i * 2 + 4), -1);
                }
            }
        RenderHelper.enableGUIStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(is, this.x, this.y * 2 * i);
        GlStateManager.popMatrix();
        }
    }

    public void draw() {
        this.getArmorValues();
    }
}
