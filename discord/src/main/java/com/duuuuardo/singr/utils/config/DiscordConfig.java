package com.duuuuardo.singr.utils.config;

import java.util.List;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class DiscordConfig {
  public String discordToken;
  public String clientID;
  public String clientSecret;
  public List<GatewayIntent> intents;
  public OnlineStatus status;
  public Integer maxShards;
  public Boolean disallowBots;
}
