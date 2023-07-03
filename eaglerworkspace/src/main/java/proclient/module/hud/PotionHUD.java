package proclient.module.hud;

import java.util.Collection;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.lax1dude.eaglercraft.v1_8.opengl.WorldRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import proclient.module.Category;
import proclient.module.RenderModule;

public class PotionHUD extends RenderModule {
    public PotionHUD() {
        super("PotionHUD", KeyboardConstants.KEY_NONE, Category.HUD, 4, 74, 100, i2 + 10);
    }

    static int i2 = 16;

    public void draw() {
        int i = 80;
        int i2 = 16;
        Collection<PotionEffect> collection = mc.thePlayer.getActivePotionEffects();
        if (!collection.isEmpty()) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableLighting();
            GlStateManager.enableAlpha();
            int l = 33;
            if (collection.size() > 5) l = 132 / (collection.size() - 1);
            for (PotionEffect potioneffect : mc.thePlayer.getActivePotionEffects()) {
                Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                if (potion.hasStatusIcon()) {
                    Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
                    int i3 = potion.getStatusIconIndex();
                    GuiIngame guiIngame = new GuiIngame(mc);
                    guiIngame.drawTexturedModalRect(getX() + 21 - 20, getY() + i2 - 14, 0 + i3 % 8 * 18, 198 + i3 / 8 * 18, 18, 18);
                }
                String s1 = I18n.format(potion.getName(), new Object[0]);
                if (potioneffect.getAmplifier() == 1) {
                    s1 = String.valueOf(String.valueOf(s1)) + " " + I18n.format("enchantment.level.2", new Object[0]);
                } else if (potioneffect.getAmplifier() == 2) {
                    s1 = String.valueOf(String.valueOf(s1)) + " " + I18n.format("enchantment.level.3", new Object[0]);
                } else if (potioneffect.getAmplifier() == 3) {
                    s1 = String.valueOf(String.valueOf(s1)) + " " + I18n.format("enchantment.level.4", new Object[0]);
                }
                Minecraft.getMinecraft().fontRendererObj.drawString(s1, (getX() + 21), (getY() + i2 - 14), -1);
                String s2 = Potion.getDurationString(potioneffect);
                Minecraft.getMinecraft().fontRendererObj.drawString(s2, (getX() + 21), (getY() + i2 + 10 - 14), -1);
                i2 += l;
            }
        }
        super.draw();
    }
}