package Commands;

import DB.Autobans;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class OnOffAutoban {
	  public static void execute(String args[], MessageReceivedEvent event) {
		if(event.getMember().getId().equalsIgnoreCase("185073797345312770")) {
		  if(args[1].equalsIgnoreCase("on")) {
			  Autobans.add(event.getGuild().getId());
		  }else {
			  Autobans.remove(event.getGuild().getId());
		}
	  }
   }
}
