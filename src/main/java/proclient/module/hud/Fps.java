package proclient.module.hud;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.client.Minecraft;
import proclient.module.Category;
import proclient.module.RenderModule;

public class Fps extends RenderModule {
    public Fps() {
        super("FPS Indicator", KeyboardConstants.KEY_NONE, Category.HUD, 10, 10, 60, 9);
    }

    public void draw() {
        Minecraft.getMinecraft().fontRendererObj.drawString("[FPS: " + Minecraft.getDebugFPS() + "]", this.x, this.y, -1);
    }
}
