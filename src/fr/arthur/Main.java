package fr.arthur;

import javax.security.auth.login.LoginException;

import DB.Punishments;
import DB.Users;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.exceptions.RateLimitedException;

public class Main {
	public static void main(String[] args) throws LoginException, IllegalArgumentException, InterruptedException, RateLimitedException{
	 JDA jda = new JDABuilder(AccountType.BOT).setToken("Njg3MzAyNzMyODU5NTcyMjI0.XnCgfw.f6aT9MYH5SykEyrVPUg1wh7rBz0").build();
	 Users.deser();
	 Punishments.deser();
	 jda.addEventListener(new Listener());
	}
}
