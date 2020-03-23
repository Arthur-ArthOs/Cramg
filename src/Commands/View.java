package Commands;

import java.awt.Color;

import DB.Punishments;
import DB.Users;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class View {
  public static void execute(String args[], MessageReceivedEvent event) {
	  for (Users user : Users.getArray()) {
		  for (Member member : event.getGuild().getMembers()) {
			  if(member.getUser().equals(event.getJDA().getUserById(user.getId()))) {
			  System.out.print("cool");
			  if(event.getJDA().getUserById(user.getId()).getAsMention().equals(args[1])) {
				  System.out.println("lol");
			  }
			  }
		  }
		  if(user.getId().equalsIgnoreCase(args[1])) {
			  EmbedBuilder builder = new EmbedBuilder();
			  StringBuilder strb = new StringBuilder();
			  builder.addField("Notes", "", false);
			  builder.addBlankField(false);
			  if(user.getBanned() == true) {
				  builder.addField("Banni ?", "Oui", true);
			  } else {
				  builder.addField("Banni ?", "Non", true);
			  }

			  for (Punishments punishment : Punishments.getArray()) {
				  if(punishment.getId().equalsIgnoreCase(user.getId())) {
					  
					  strb.append(Punishments.getArray().indexOf(punishment)+" - "+"Punition : "+punishment.getName()+" : "+punishment.getReason());
				  }
			  }
			  builder.addField("Punishment", strb.toString(), false);
			  builder.setColor(Color.GREEN);
			  builder.setTitle("Fiche utilisateur : "+event.getJDA().getUserById(user.getId()).getName());
			  builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
			  builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://cramg.net", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
			  builder.setThumbnail(event.getJDA().getUserById(user.getId()).getAvatarUrl());
			  //https://i.ibb.co/wW5xnwW/Sans-titre.png
			  //builder.setDescription(strb.toString());
			  event.getChannel().sendMessage(builder.build()).queue();
		  }
	  }
  }
}
