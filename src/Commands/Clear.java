package Commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Clear {
	public static void execute(String args[], MessageReceivedEvent event) {
		Guild guild = event.getGuild();
		for(GuildChannel channel : guild.getChannels()) {
			if(channel.getName().equalsIgnoreCase("shop")) {
				channel.delete().queue();
			}
		}
	}
}
