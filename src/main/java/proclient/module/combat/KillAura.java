package proclient.module.combat;

import java.util.Iterator;

import proclient.Dragon;
import proclient.module.Category;
import proclient.module.Module;
import net.lax1dude.eaglercraft.v1_8.internal.KeyboardConstants;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class KillAura extends Module {

    public KillAura() {
        super("KillAura", KeyboardConstants.KEY_NONE, Category.COMBAT);
    }
    
    
    @Override
    public void onUpdate() {
        if(!this.isToggled())
            return;
        for(Iterator<Entity> entities = mc.theWorld.loadedEntityList.iterator(); entities.hasNext();) {
            Object theObject = entities.next();
            if(theObject instanceof EntityLivingBase) {
                EntityLivingBase entity = (EntityLivingBase) theObject;
                if(entity instanceof EntityPlayerSP) continue;
                if(mc.thePlayer.getDistanceToEntity(entity) <= 2.8F) {
                    if(entity.isEntityAlive()) {
                        mc.playerController.attackEntity(mc.thePlayer, entity);
                        mc.thePlayer.swingItem();
                        continue;
                    }
                }
            }
        }
        
        
       
        super.onUpdate();
    }
 

}