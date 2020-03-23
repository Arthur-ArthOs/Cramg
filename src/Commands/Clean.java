package Commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Clean {
	public static void execute(String args[], MessageReceivedEvent event) {
		Guild guild = event.getGuild();
		for(GuildChannel channel : guild.getChannels()) {
			if(channel.getName().equalsIgnoreCase(args[1])) {
				channel.delete().queue();
			}
		}
	}
}
