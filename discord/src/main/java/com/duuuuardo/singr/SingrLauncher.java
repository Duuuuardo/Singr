package com.duuuuardo.singr;

import com.duuuuardo.singr.utils.config.DiscordConfig;
import com.duuuuardo.singr.utils.config.ServerConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SingrLauncher {
  public static Singr singr;

  public static void main(String[] args) {
    var configurationFile = new File("./discord.yaml");
    var serverConfFile = new File("./server.yaml");

    if (!configurationFile.exists() || !serverConfFile.exists()) {
      System.out.println("Welcome to Singr Launcher!");
      System.out.println("");
      System.out.println("Some configuration files were created in the executable folder!");
      System.out.println("");
      System.out.println("Fill all files with the needed configuration for the bot.");
      System.out.println("After completing theese steps you can run the jar again!");

      copyFileFromJar("/discord.yaml", "./discord.yaml");
      copyFileFromJar("/server.yaml", "./server.yaml");

      System.exit(1);
      return;
    }

    DiscordConfig config = DiscordConfig.read(configurationFile);
    ServerConfig serverConfig = ServerConfig.read(serverConfFile);
    Singr singr = new Singr(config, serverConfig);
    singr.start();
  }

  private static void copyFileFromJar(String input, String output) {
    var inputStream = SingrLauncher.class.getResourceAsStream(input);
    try (FileOutputStream file = new FileOutputStream(output)) {
      file.write(inputStream.readAllBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
