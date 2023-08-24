package proclient.module.player;


import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import proclient.event.Event;
import proclient.module.Category;
import proclient.module.Module;

public class FreeCam extends Module {
	  private EntityOtherPlayerMP fakePlayer = null;
	  private double oldX;
	  private double oldY;
	  private double oldZ;   
	public FreeCam() {
		super("FreeCam", KeyboardConstants.KEY_NONE, Category.PLAYER);
	}
	
	public void onEnable() {
		 if(mc.thePlayer == null)
	            return;
        oldX = mc.thePlayer.posX;
        oldY = mc.thePlayer.posY;
        oldZ = mc.thePlayer.posZ;
        fakePlayer = new EntityOtherPlayerMP(mc.theWorld, mc.thePlayer.getGameProfile());
        fakePlayer.clonePlayer(mc.thePlayer, true);
        fakePlayer.rotationYawHead = mc.thePlayer.rotationYawHead;
        fakePlayer.copyLocationAndAnglesFrom(mc.thePlayer);
        mc.theWorld.addEntityToWorld(-1000, fakePlayer);
            mc.thePlayer.capabilities.allowFlying = true;
            mc.thePlayer.noClip = true;
	}
	
	public void onDisable() {
		 if(mc.thePlayer == null || fakePlayer == null)
	            return;
        mc.thePlayer.setPositionAndRotation(oldX, oldY, oldZ, mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
        mc.theWorld.removeEntityFromWorld(fakePlayer.getEntityId());
        fakePlayer = null;
        mc.thePlayer.motionX = 0;
        mc.thePlayer.motionY = 0;
        mc.thePlayer.motionZ = 0;
        mc.thePlayer.capabilities.allowFlying = false;
	}
	
	 
	 public void onUpdate(Event event) {
             mc.thePlayer.noClip = true;
             mc.thePlayer.fallDistance = 0;

             final float value = (float) 3;

             mc.thePlayer.motionY = 0;
             mc.thePlayer.motionX = 0;
             mc.thePlayer.motionZ = 0;
             if(mc.gameSettings.keyBindJump.isPressed())
                mc.thePlayer.motionY += value;
             if(mc.gameSettings.keyBindSneak.isPressed())
                mc.thePlayer.motionY -= value;
             //MovementUtils.strafe(value);
	  }

}