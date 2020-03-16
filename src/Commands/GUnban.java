package Commands;

import DB.Users;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class GUnban {
	public static void execute(String args[], MessageReceivedEvent event) {
		for (Users user : Users.getArray()) {
			if(user.getId().equalsIgnoreCase(args[1])) {
				user.setBanned(false);
				Users.ser();
				EmbedBuilder builder = new EmbedBuilder();
	        	builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	        	builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
	        	builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	        	builder.setTitle("Banissement", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	        	StringBuilder strb = new StringBuilder();
	        	strb.append("Utilisateur débanni ! :white_check_mark:");
	        	builder.setDescription(strb.toString());
	        	event.getChannel().sendMessage(builder.build()).queue();
			}
		}
	}
}
