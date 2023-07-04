package proclient.module.hud;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import proclient.module.Category;
import proclient.module.RenderModule;

public class ArmorStats extends RenderModule {
    public ArmorStats() {
        super("ArmorStats", KeyboardConstants.KEY_NONE, Category.HUD, 525, 10, 20, 96);
    }

    public ScaledResolution sr;

    @Override
    public void draw() {
        GlStateManager.enableLighting();
        ItemStack boots = mc.thePlayer.inventory.armorInventory[0];
        ItemStack legs = mc.thePlayer.inventory.armorInventory[1];
        ItemStack chest = mc.thePlayer.inventory.armorInventory[2];
        ItemStack helmet = mc.thePlayer.inventory.armorInventory[3];
        ItemStack hand = mc.thePlayer.inventory.getCurrentItem();
        if (helmet != null) {
            ItemStack displayhelmet = helmet.copy();
            displayhelmet.stackSize = 1;
            GuiIngame.itemRenderer.renderItemAndEffectIntoGUI(displayhelmet, this.x + 3, this.y + 2);

            GuiIngame.itemRenderer.renderItemOverlayIntoGUI(mc.fontRendererObj, displayhelmet, this.x + 3, this.y + 2, "");
            //16
        }
        if (chest != null) {
            ItemStack displaychest = chest.copy();
            displaychest.stackSize = 1;
            GuiIngame.itemRenderer.renderItemAndEffectIntoGUI(displaychest, this.x + 3, this.y + 18);

            GuiIngame.itemRenderer.renderItemOverlayIntoGUI(mc.fontRendererObj, displaychest, this.x + 3, this.y + 18, "");
        }
        if (legs != null) {
            ItemStack displaylegs = legs.copy();
            displaylegs.stackSize = 1;
            GuiIngame.itemRenderer.renderItemAndEffectIntoGUI(displaylegs, this.x + 3, this.y + 34);

            GuiIngame.itemRenderer.renderItemOverlayIntoGUI(mc.fontRendererObj, displaylegs, this.x + 3, this.y + 34, "");
        }
        if (boots != null) {
            ItemStack displayboots = boots.copy();
            displayboots.stackSize = 1;
            GuiIngame.itemRenderer.renderItemAndEffectIntoGUI(displayboots, this.x + 3, this.y + 50);

            GuiIngame.itemRenderer.renderItemOverlayIntoGUI(mc.fontRendererObj, displayboots, this.x + 3, this.y + 50, "");
        }
        if (hand != null) {
            ItemStack displayhand = hand.copy();
            displayhand.stackSize = 1;
            GuiIngame.itemRenderer.renderItemAndEffectIntoGUI(displayhand, this.x + 3, this.y + 66);
            GuiIngame.itemRenderer.renderItemOverlayIntoGUI(mc.fontRendererObj, displayhand, this.x + 3, this.y + 66, "");
        }

        GlStateManager.disableLighting();
    }
}
