package com.duuuuardo.singr;

import com.duuuuardo.singr.utils.config.DiscordConfig;
import com.duuuuardo.singr.utils.config.ServerConfig;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Singr {
  private DiscordConfig config;
  private ServerConfig serverConfig;

  public Singr(DiscordConfig config, ServerConfig serverConfig) {
    super();
    this.config = config;
    this.serverConfig = serverConfig;
  }

  private static Logger logger = LoggerFactory.getLogger(Singr.class);

  public void start() {
    SingrLauncher.singr = this;

    Dispatcher dispatcher = new Dispatcher();
    dispatcher.setMaxRequestsPerHost(serverConfig.maxRequestsPerHost);
    logger.info("Building OkHttp client!");
    var okHttpBuilder =
        new OkHttpClient.Builder()
            .dispatcher(dispatcher)
            .connectTimeout(serverConfig.connectTimeout, TimeUnit.SECONDS)
            .readTimeout(serverConfig.readTimeout, TimeUnit.SECONDS)
            .writeTimeout(serverConfig.writeTimeout, TimeUnit.SECONDS)
            .protocols(List.of(Protocol.HTTP_1_1));

    DefaultShardManagerBuilder builder =
        DefaultShardManagerBuilder.create(config.discordToken, config.intents)
            .disableCache(Arrays.asList(CacheFlag.values()))
            .enableCache(config.discord.cacheFlags)
            .setChunkingFilter(ChunkingFilter.NONE)
            .setMemberCachePolicy(MemberCachePolicy.ALL)
            .setShardsTotal(config.maxShards)
            .setStatus(config.status)
            .setActivity(
                Activity.of(
                    Activity.ActivityType.valueOf(config.activity.type),
                    config.activity.name,
                    "https://www.twitch.tv/eoduuardo"))
            .setBulkDeleteSplittingEnabled(false)
            .setHttpClientBuilder(okHttpBuilder)
            .setRawEventsEnabled(true);

    logger.info("Connecting SingR to discord!");
    builder.build();
  }
}
