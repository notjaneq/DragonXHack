package proclient.module.combat;

import proclient.module.Category;
import proclient.module.Module;
import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;

public class AutoClicker extends Module {
    public AutoClicker() {
        super("AutoClicker", KeyboardConstants.KEY_NONE, Category.COMBAT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()) {
            try {
                mc.thePlayer.setSprinting(true);
                mc.clickMouse();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
