package com.duuuuardo.singr;

import com.duuuuardo.singr.utils.ConfigUtils;
import com.duuuuardo.singr.utils.config.DiscordConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SingrLauncher {
  public static void main(String[] args) {
    var configurationFile = new File("./discord.yaml");

    if (!configurationFile.exists()) {
      System.out.println("Welcome to Singr Launcher!");
      System.out.println("");
      System.out.println("Some configuration files were created in the executable folder!");
      System.out.println("");
      System.out.println("Fill all files with the needed configuration for the bot.");
      System.out.println("After completing theese steps you can run the jar again!");

      copyFileFromJar("/discord.yaml", "./discord.yaml");
      System.exit(1);
      return;
    }

    DiscordConfig config = ConfigUtils.readConfigurationFromFile(configurationFile);

    Singr singr = new Singr(config);
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
