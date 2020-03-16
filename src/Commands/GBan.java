package Commands;

import java.awt.Color;

import DB.Autobans;
import DB.Users;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class GBan {
	public static void execute(String args[], MessageReceivedEvent event) {
		for (Guild guild : event.getJDA().getGuilds()) {
			if(guild.getId().equalsIgnoreCase("324527359321440260")) {
				EmbedBuilder builder = new EmbedBuilder();
				builder.setColor(Color.YELLOW);
			    builder.setTitle("Avertissement");
				builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
			    builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://cramg.net", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
				builder.setDescription("L'utilisateur "+event.getJDA().getUserById(args[1]).getAsTag()+" a bien été banni sur un des serveurs de l'alliance !");
				builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
				for (GuildChannel channel : guild.getChannels()) {
			    	if(channel.getName().equalsIgnoreCase("cramg-emits")) {
			    		event.getJDA().getTextChannelById(channel.getId()).sendMessage(builder.build()).queue();
			    	}
			    }
				continue;
			}
			if(guild.getId().equalsIgnoreCase(event.getGuild().getId())) {
				guild.ban(event.getJDA().getUserById(args[1]), 7).queue();
				continue;
			}
			if(Autobans.usesAutoban(guild.getId()) == true) {
			EmbedBuilder builder = new EmbedBuilder();
		    builder.setColor(Color.RED);
			builder.setTitle("Banissement");
		    builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
			builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://cramg.net", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
			builder.setDescription("L'utilisateur "+event.getJDA().getUserById(args[1]).getAsTag()+" a bien été banni !");
			builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
		    for (GuildChannel channel : guild.getChannels()) {
		    	if(channel.getName().equalsIgnoreCase("cramg-emits")) {
		    		event.getJDA().getTextChannelById(channel.getId()).sendMessage(builder.build()).queue();
		    	}
		    }
		    guild.ban(event.getJDA().getUserById(args[1]), 7).queue();
			} else {
			EmbedBuilder builder = new EmbedBuilder();
			builder.setColor(Color.YELLOW);
		    builder.setTitle("Avertissement");
			builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
		    builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://cramg.net", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
			builder.setDescription("L'utilisateur a "+event.getJDA().getUserById(args[1]).getAsTag()+" bien été banni sur un des serveurs de l'alliance !");
			builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
			for (GuildChannel channel : guild.getChannels()) {
		    	if(channel.getName().equalsIgnoreCase("cramg-emits")) {
		    		event.getJDA().getTextChannelById(channel.getId()).sendMessage(builder.build()).queue();
		    	}
		    }
			}
		}
		for (Users user : Users.getArray()) {
			if(user.getId().equalsIgnoreCase(args[1])) {
				user.setBanned(true);
				Users.ser();
			}
		}
		EmbedBuilder builder = new EmbedBuilder();
	    builder.setColor(Color.GREEN);
		builder.setTitle("Banissement");
	    builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
		builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://cramg.net", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
		builder.setDescription("L'utilisateur a bien été banni !");
		builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
		event.getChannel().sendMessage(builder.build()).submit();
	}
}
