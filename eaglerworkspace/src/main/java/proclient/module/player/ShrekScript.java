package proclient.module.player;

import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.client.Minecraft;
import proclient.module.Category;
import proclient.module.Module;

public class ShrekScript extends Module {
    public ShrekScript() {
        super("ShrekScript", KeyboardConstants.KEY_NONE, Category.PLAYER);
    }

    public void onEnable() {
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("");

    }
}
