package Commands;

import DB.Autobans;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class OnOffAutoban {
	  public static void execute(String args[], MessageReceivedEvent event) {
		if(event.getMember().getId().equalsIgnoreCase("185073797345312770")) {
		  if(args[1].equalsIgnoreCase("on")) {
			  Autobans.add(event.getGuild().getId());
			  EmbedBuilder builder = new EmbedBuilder();
	          builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	          builder.setDescription("Autoban activé ! :white_check_mark_");
	          builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
	          builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	          builder.setTitle("Autoban", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
		  }else {
			  Autobans.remove(event.getGuild().getId());
			  EmbedBuilder builder = new EmbedBuilder();
	          builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	          builder.setDescription("Autoban désactivé ! :white_check_mark_");
	          builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
	          builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	          builder.setTitle("Autoban", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
		}
	  }
   }
}
