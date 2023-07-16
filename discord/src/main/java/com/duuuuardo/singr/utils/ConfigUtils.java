package com.duuuuardo.singr.utils;

import com.duuuuardo.singr.utils.config.DiscordConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;

public class ConfigUtils {
  public static DiscordConfig readConfigurationFromFile(File file) {
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
