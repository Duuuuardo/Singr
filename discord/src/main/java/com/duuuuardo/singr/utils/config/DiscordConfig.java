package com.duuuuardo.singr.utils.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.util.List;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class DiscordConfig {
  public String discordToken;
  public String clientID;
  public String clientSecret;
  public List<GatewayIntent> intents;
  public OnlineStatus status;
  public Integer maxShards;
  public Boolean disallowBots;
  public Integer maxrequestsPerHost;
  public Activity activity;
  public Discord discord;

  public static class Discord {
    public List<CacheFlag> cacheFlags;
  }

  public static class Activity {
    public String name;
    public String type;
  }

  public static DiscordConfig read(File file) {
    try {
      ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

      DiscordConfig config = objectMapper.readValue(file, DiscordConfig.class);
      return config;
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
      return null;
    }
  }
}
