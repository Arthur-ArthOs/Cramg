package Commands;

import DB.Punishments;
import DB.Users;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AddPunishment {
	public static void execute(String args[], MessageReceivedEvent event) {
		String reason = event.getMessage().getContentDisplay().replaceAll("\\*punish", "");
		String reason2 = reason.replaceAll(args[1], "");
		String reason3 = reason2.replaceAll(args[2], "");
		System.out.println(reason3);
		Punishments.add(args[2], reason3, args[1]);
		Punishments.ser();
	}
}
