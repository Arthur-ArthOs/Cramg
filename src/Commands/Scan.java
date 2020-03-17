package Commands;

import DB.Users;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Scan {
	  public static void execute(String args[], MessageReceivedEvent event) {
		  EmbedBuilder builder = new EmbedBuilder();
		  StringBuilder strb = new StringBuilder();
	      builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	      builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
	      builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
	      builder.setTitle("Aide", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
		  for (Member member : event.getGuild().getMembers()) {
			  boolean exist = false;
			  for (Users user : Users.getArray()) {
				  if(member.getId().equalsIgnoreCase(user.getId())) {
					  exist = true;
				  }
			  }
			  if(exist == true) {
				  continue;
			  }else {
				  if(member.getUser().isBot()) {
					  return;
				  }
				  Users.add(false, member.getId());
				  Users.ser();
			      strb.append(member.getUser().getAsTag()+" possède une carte d'identité !");
			  }
		  }
		  event.getChannel().sendMessage(builder.build());
	  }
}
