package proclient.module.player;

import java.util.ArrayList;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import proclient.event.events.EventSendPacket;
import proclient.module.Category;
import proclient.module.Module;
import proclient.util.TimeHelper;

public class Phase extends Module {
    private long deltaTime;
    private long startTime;
    TimeHelper timer;
    private EntityOtherPlayerMP player;
    private ArrayList<Packet> packets;
    
    public Phase() {
        super("Blink", 0, Category.MOVEMENT);
        this.packets = new ArrayList<Packet>();
    }
    
    @Override
    public void onEnable() {
        this.deltaTime = 0L;
        this.timer = new TimeHelper();
        (this.player = new EntityOtherPlayerMP(this.mc.theWorld, this.mc.thePlayer.getGameProfile())).clonePlayer(this.mc.thePlayer, true);
        this.player.setPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ);
        this.player.rotationYawHead = this.mc.thePlayer.rotationYaw;
        this.player.rotationPitch = this.mc.thePlayer.rotationPitch;
        this.player.setSneaking(this.mc.thePlayer.isSneaking());
        this.mc.theWorld.addEntityToWorld(-1337, this.player);
        this.startTime = this.timer.getCurrentMS();
    }
    
    public void onSendPacket(final EventSendPacket event) {
        if (event.packet instanceof C03PacketPlayer || event.packet instanceof C0BPacketEntityAction || event.packet instanceof C0APacketAnimation || event.packet instanceof C02PacketUseEntity || event.packet instanceof C09PacketHeldItemChange || event.packet instanceof C08PacketPlayerBlockPlacement || event.packet instanceof C07PacketPlayerDigging) {
            event.setCancelled(true);
            this.packets.add(event.packet);
            this.packets.trimToSize();
            this.deltaTime = this.timer.getCurrentMS() - this.startTime;
        }
    }
    
    @Override
    public void onDisable() {
        this.mc.theWorld.removeEntity(this.player);
        for (final Packet packet : this.packets) {
        }
    }
}