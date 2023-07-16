package com.duuuuardo.singr;

import com.duuuuardo.singr.utils.config.DiscordConfig;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Singr {
  private DiscordConfig config;

  public Singr(DiscordConfig config) {
    super();
    this.config = config;
  }

  private static Logger logger = LoggerFactory.getLogger(Singr.class);

  public void start() {
    DefaultShardManagerBuilder builder =
        DefaultShardManagerBuilder.create(config.discordToken, config.intents)
            .setShardsTotal(config.maxShards)
            .setStatus(config.status)
            .setBulkDeleteSplittingEnabled(false)
            .setRawEventsEnabled(true);

    logger.info("Connecting SingR to discord!");
    builder.build();
  }
}
