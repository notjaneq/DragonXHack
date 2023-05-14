package proclient.command.commands;

import proclient.Dragon;
import proclient.command.Command;
import net.minecraft.client.Minecraft;

public class Vclip extends Command {
    public Vclip() {
        super("Vclip", "Virtual clips you through shit", "Vclip <distance>", "vclip");
    }

	@Override
	public void onCommand(String[] args, String command) {
		if (args.length == 0) {
			Dragon.moduleManager.addChatMessage(".vclip <value> ");
			return;
		}
		final double distance = Double.parseDouble(args[0]);
		Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().offsetAndUpdate(0, distance, 0);
		Dragon.moduleManager.addChatMessage("Vcliped " + args[0] + "!");
	}

    
    
}
