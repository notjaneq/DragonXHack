package proclient.module.player;

import proclient.module.Category;
import proclient.module.Module;
import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;


public class FastPlace extends Module{

	public FastPlace() {
		super("FastPlace", KeyboardConstants.KEY_B, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.rightClickDelayTimer = 0;
		}
	}

}