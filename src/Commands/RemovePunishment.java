package Commands;

import DB.Punishments;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class RemovePunishment {
	public static void execute(String args[], MessageReceivedEvent event) {
		Punishments.remove(Integer.parseInt(args[1]));
	    EmbedBuilder builder = new EmbedBuilder();
	    builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    builder.setTitle("Dé-punition", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    builder.setDescription("L'utilisateur a bien été dé-puni ! :white_check_mark:");
	    event.getChannel().sendMessage(builder.build()).queue();
		Punishments.ser();
	}
}
