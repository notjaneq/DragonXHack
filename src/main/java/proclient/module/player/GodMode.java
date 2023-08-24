package proclient.module.player;

import proclient.module.Category;
import proclient.module.Module;
import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGameOver;

public class GodMode extends Module {
    public GodMode() {
        super("GodMode", KeyboardConstants.KEY_NONE, Category.PLAYER);
    }

    public void onUpdate() {
        if(this.isToggled()) {
            if(mc.thePlayer.getHealth() <= 0) {
                mc.thePlayer.setHealth(mc.thePlayer.getMaxHealth());
                if(mc.currentScreen instanceof GuiGameOver) {
                    mc.currentScreen = null;
                }
            }
    }
}

}