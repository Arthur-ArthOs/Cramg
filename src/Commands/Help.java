package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Help {
	public static void execute(String args[], MessageReceivedEvent event) {
	  EmbedBuilder builder = new EmbedBuilder();
	  StringBuilder strb = new StringBuilder();
      builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
      builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
      builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
      builder.setTitle("Aide", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
      strb.append("*ban utilisateurid : Banni l'utilisateur de votre serveur et envoie un input aux autres");
      strb.append("*view utilisateurid : Montre la carte d'identité d'un utilisateur");
      strb.append("*punish utilisateurid : Ajoute une punition à la carte d'identité de l'utilisateur");
      strb.append("*depunish punitionid : Enleve la punition qui correspond avec l'id");
      builder.setDescription(strb.toString());
      event.getChannel().sendMessage(builder.build()).queue();
	}
}
