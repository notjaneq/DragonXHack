package proclient.module.combat;

import proclient.module.Module;
import proclient.module.Category;
import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.network.Packet;


public class AutoWtap extends Module
{
	
    public AutoWtap() {
		super("AutoWtap", KeyboardConstants.KEY_NONE, Category.COMBAT);
	}
	private Float coolDown = 0f;
    
    @Override
    public void onUpdate() {
        if(this.isToggled()) {
    	coolDown -= 1f;
    	mc.thePlayer.setSprinting(true);
        if (mc.thePlayer.isSwingInProgress)
        	if (coolDown < 0) {
        		mc.thePlayer.setSprinting(false);
        		coolDown = 3f;
        		
        	}
        }
    }
    
}

