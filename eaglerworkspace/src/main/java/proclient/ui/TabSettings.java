package proclient.ui;

import net.lax1dude.eaglercraft.v1_8.internal.PlatformRuntime;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class TabSettings extends GuiScreen {
    private GuiScreen parentGuiScreen;


    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 - 60, "TabName"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 2 + 0, "Favicon"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 100, this.height / 2 + 30, "Done"));
        super.initGui();
    }



    @Override
    protected void actionPerformed(GuiButton button) {
        if(button.id == 0) {
			PlatformRuntime.changeTitle();
        }
        if(button.id == 1) {
			PlatformRuntime.changeFavicon();
        } 
        if(button.id == 3) {
		this.mc.displayGuiScreen(this.parentGuiScreen);
        }
        super.actionPerformed(button);
    }

    public void drawScreen(int i, int j, float f) {
		this.drawDefaultBackground();
    	this.drawCenteredString(this.fontRendererObj, I18n.format("TabSettings", new Object[0]), this.width / 2, 16, 16777215);
        super.drawScreen(i, j, f);
	}
    
}
