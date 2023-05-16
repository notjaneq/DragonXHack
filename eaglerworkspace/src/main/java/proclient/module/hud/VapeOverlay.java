package proclient.module.hud;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import proclient.module.Category;
import proclient.module.RenderModule;

public class VapeOverlay extends RenderModule {
    public VapeOverlay() {
        super("Vape", KeyboardConstants.KEY_NONE, Category.HUD, 5, 5, 70, 70);
    }

    public void draw() {
        this.mc.getTextureManager().bindTexture(new ResourceLocation("dragon/vape-overlay.png"));
        Gui.drawModalRectWithCustomSizedTexture(this.x, this.y, 1.0F, 0.0F, 70, 55, 70.0F, 55.0F);
        super.draw();
    }
}