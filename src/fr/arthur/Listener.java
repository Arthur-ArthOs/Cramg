package fr.arthur;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.events.guild.GuildBanEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.pagination.AuditLogPaginationAction;

import java.awt.Color;

import Commands.AddPunishment;
import Commands.Clean;
import Commands.GBan;
import Commands.GUnban;
import Commands.Help;
import Commands.OnOffAutoban;
import Commands.RemovePunishment;
import Commands.Scan;
import Commands.View;
import DB.Autobans;
import DB.Users;

public class Listener extends ListenerAdapter{

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
    	for (Users user : Users.getArray()) {
    		if(user.getId().equalsIgnoreCase(event.getMember().getId())) {
    			if(user.getBanned() == true) {
    				if(event.getGuild().getName().equalsIgnoreCase("Cramg")) {
    					event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("513641766050594831")).queue();
    					event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("481219759988277267")).queue();
    					return;
    				}
    				if(Autobans.usesAutoban(event.getGuild().getId())) {
    		        event.getMember().getUser().openPrivateChannel().queue((channel) ->
    		        {
    		        	EmbedBuilder builder = new EmbedBuilder();
    		        	builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    		        	builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
    		        	builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    		        	builder.setTitle("Notification d'accusation", "https://i.ibb.co/wW5xnwW/*banSans-titre.png");
    		        	builder.addField("Pourquoi ne puis-je pas rejoindre ce serveur ?", "Vous avez été banni d'un des serveurs membres de la Cramg, il vous est donce impossible de rejoindre n'importe quel serveur membre de l'alliance", true);
    		        	builder.addField("Que puis-je faire pour être débanni ?", "Il suffit de rejoindre le serveur principal de la Cramg, ici, vous pourrez vous défendre lors d'un procès qui sera organisé une fois que vous aurez rejoint.", true);
    		            builder.addField("Invitation", "https://discord.gg/see3N2Z", true);
    		        	channel.sendMessage(builder.build()).queue();
    		            try {
							wait(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    		        });
    				event.getGuild().ban(event.getMember(), 7).complete();
    				return;
    				} else {
    					EmbedBuilder builder = new EmbedBuilder();
    		        	builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    		        	builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
    		        	builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    		        	builder.setTitle("Avertissement", "https://i.ibb.co/wW5xnwW/*banSans-titre.png");
                        builder.setDescription("Un membre ayant été banni sur l'un des serveurs membres de l'alliance a rejoint votre serveur !");
    					for (GuildChannel channel : event.getGuild().getChannels()) {
    				    	if(channel.getName().equalsIgnoreCase("cramg-emits")) {
    				    		event.getJDA().getTextChannelById(channel.getId()).sendMessage(builder.build()).queue();
    				    		return;
    				    	}
    				    } 	
    				}
    			}
    		}else {
    			continue;
    		}
    	}
    	Users.add(false, event.getMember().getId());
    }
    public void onGuildBan(GuildBanEvent event) {
    	AuditLogPaginationAction Logs = event.getGuild().retrieveAuditLogs();
    	Logs.type(ActionType.BAN);
    	Logs.limit(1);
    	String Tag = null;
    	String Id = null;
    	for(AuditLogEntry log : Logs) {
    		if(log.getUser().isBot()) {
    			return;
    		} else {
    		    Tag = log.getUser().getAsTag();
    		     Id = log.getUser().getId();
    		}
    	}
    	for (Users user : Users.getArray()) {
    		if(user.getId().equalsIgnoreCase(event.getUser().getId())) {
    		   for (Guild guild : event.getJDA().getGuilds()) {
    			  if(guild.getId().equalsIgnoreCase("324527359321440260")) {
    					EmbedBuilder builder = new EmbedBuilder();
    					builder.setColor(Color.YELLOW);
    				    builder.setTitle("Avertissement");
    					builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    				    builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://cramg.net", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    					builder.setDescription("L'utilisateur "+event.getUser().getAsTag()+" avec l'id : "+event.getUser().getId()+" a été banni par "+Tag+" avec l'id :" +Id+" sur :"+event.getGuild().getName());
    					builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
    					for (GuildChannel channel : guild.getChannels()) {
    				    	if(channel.getName().equalsIgnoreCase("cramg-emits")) {
    				    		event.getJDA().getTextChannelById(channel.getId()).sendMessage(builder.build()).queue();
    				    	}
    				    }
    					continue;
    				}
    			  if(Autobans.usesAutoban(guild.getId()) == true) {
    					EmbedBuilder builder = new EmbedBuilder();
    				    builder.setColor(Color.RED);
    					builder.setTitle("Banissement");
    				    builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    					builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://cramg.net", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    					builder.setDescription("L'utilisateur : "+event.getUser().getAsTag()+" a été banni sur ce serveur!");
    					builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
    				    for (GuildChannel channel : guild.getChannels()) {
    				    	if(channel.getName().equalsIgnoreCase("cramg-emits")) {
    				    		event.getJDA().getTextChannelById(channel.getId()).sendMessage(builder.build()).queue();
    				    	}
    				    }
    				    guild.ban(event.getUser(), 7).complete();
    					} else {
    					EmbedBuilder builder = new EmbedBuilder();
    					builder.setColor(Color.YELLOW);
    				    builder.setTitle("Avertissement");
    					builder.setFooter("By Cramg", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    				    builder.setAuthor("Cramg | Maison de Gestion : Bureau de l'Interieur", "https://cramg.net", "https://i.ibb.co/wW5xnwW/Sans-titre.png");
    					builder.setDescription("L'utilisateur : "+event.getUser().getAsTag()+" a été banni sur un des serveurs de l'alliance !");
    					builder.setThumbnail("https://i.ibb.co/wW5xnwW/Sans-titre.png");
    					for (GuildChannel channel : guild.getChannels()) {
    				    	if(channel.getName().equalsIgnoreCase("cramg-emits")) {
    				    		event.getJDA().getTextChannelById(channel.getId()).sendMessage(builder.build()).queue();
    				    	}
    				    }
    		        }
    		   }
               user.setBanned(true);
               Users.ser();
    		}
    	}	
    }
    public void onMessageReceived(MessageReceivedEvent event) {
    	String message = event.getMessage().getContentDisplay();
    	String args[] = event.getMessage().getContentDisplay().split(" ");
    	if(message.startsWith("*view")) {
    		View.execute(args, event);
    	}
    	if(message.startsWith("*scan")) {
    		Scan.execute(args, event);
    	}
    	if(message.startsWith("*punish")) {
    		AddPunishment.execute(args, event);
    	}
    	if(message.startsWith("*depunish")) {
    		RemovePunishment.execute(args, event);
    	}
    	if(message.startsWith("*gunban")) {
    		GUnban.execute(args, event);
    	}
    	if(message.startsWith("*ban")) {
    		GBan.execute(args, event);
    	}
    	if(message.startsWith("*autoban")) {
    		OnOffAutoban.execute(args, event);
    	}
    	if(message.startsWith("*help")) {
    		Help.execute(args, event);
    	}
    	if(message.startsWith("*clean")) {
    		Clean.execute(args, event);
    	}
    }
}
