package Commands;

import DB.Punishments;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AddPunishment {
	public static void execute(String args[], MessageReceivedEvent event) {
		for (User user : event.getMessage().getMentionedUsers()) {
			  args[1] = user.getId();
		}
		String reason = event.getMessage().getContentDisplay().replaceAll("\\*punish", "");
		String reason2 = reason.replaceAll(args[1], "");
		String reason3 = reason2.replaceAll(args[2], "");
		Punishments.add(args[2], reason3, args[1]);
	    EmbedBuilder builder = new EmbedBuilder();
	    builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    builder.setTitle("Punition", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    builder.setDescription("L'utilisateur a bien été puni ! :white_check_mark:");
	    event.getChannel().sendMessage(builder.build()).queue();
		Punishments.ser();
	}
}
