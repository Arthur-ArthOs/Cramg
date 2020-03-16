package Commands;

import DB.Users;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Scan {
	  public static void execute(String args[], MessageReceivedEvent event) {
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
				  Users.add(false, member.getId());
				  Users.ser();
				  event.getChannel().sendMessage(member.getEffectiveName()+ " : ajouté").queue();
			  }
		  }
	  }
}
