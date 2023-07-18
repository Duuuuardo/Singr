package com.duuuuardo.singr.utils.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;

public class ServerConfig {
  public Integer connectTimeout;
  public Integer readTimeout;
  public Integer writeTimeout;
  public Integer maxRequestsPerHost;

  public static ServerConfig read(File file) {
    try {
      ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

      ServerConfig config = objectMapper.readValue(file, ServerConfig.class);
      return config;
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
      return null;
    }
  }
}
