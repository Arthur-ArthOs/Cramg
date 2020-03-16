package Commands;

import DB.Punishments;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class RemovePunishment {
	public static void execute(String args[], MessageReceivedEvent event) {
		Punishments.remove(Integer.parseInt(args[1]));
		Punishments.ser();
	}
}
