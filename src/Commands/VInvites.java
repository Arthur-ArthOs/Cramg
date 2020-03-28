package Commands;

import DB.Invites;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class VInvites {
	public static void execute(String args[], MessageReceivedEvent event) {
		EmbedBuilder builder = new EmbedBuilder();
	    builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
		builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	    StringBuilder strb = new StringBuilder();
		for(Invites invite : Invites.getArray()) {
			if(event.getGuild().getId().equalsIgnoreCase(invite.getGuild())) {
				if(args[1].equalsIgnoreCase(invite.getId())) {
				   builder.setTitle("Invites de :"+event.getJDA().getUserById(invite.getId()), "https://i.ibb.co/wW5xnwW/Sans-titre.png");
				   strb.append("Lien : "+invite.getLink()+" utilisé"+invite.getUtilisations());
				}
			}
		}
		builder.setDescription(strb.toString());
		event.getChannel().sendMessage(builder.build()).queue();
	}
}
