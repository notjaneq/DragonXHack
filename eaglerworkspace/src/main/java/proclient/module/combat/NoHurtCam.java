package proclient.module.combat;

import proclient.module.Category;
import proclient.module.Module;
import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;

public class NoHurtCam extends Module {
    public NoHurtCam() {
        super("NoHurtCam", KeyboardConstants.KEY_NONE, Category.COMBAT);
    }

    public void onUpdate() {
        if(this.isToggled()) {
            mc.thePlayer.maxHurtTime = 0;
        }
    }
    
}
