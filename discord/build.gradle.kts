import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val singrVersion by lazy { ext["singr-version"] as String }
val jdaVersion by lazy { ext["jda-version"] as String }

plugins {
  java
  id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
  gradlePluginPortal()
  google()
  mavenCentral()
  maven("https://dl.bintray.com/kotlin/kotlin-eap")
  maven("https://plugins.gradle.org/m2/")
}

tasks.withType<Jar> { manifest { attributes["Main-Class"] = "com.duuuuardo.singr.SingrLauncher" } }

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")

  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.0")
  implementation("com.google.guava:guava:31.1-jre")
  implementation("org.slf4j:slf4j-api:2.0.7")
  implementation("org.slf4j:slf4j-simple:2.0.7")
  implementation("net.dv8tion:JDA:${jdaVersion}")
}

tasks {
  named<ShadowJar>("shadowJar") {
    archiveBaseName.set("discord-fat")
    mergeServiceFiles()
  }
}

tasks { build { dependsOn(shadowJar) } }

tasks.named<Test>("test") { useJUnitPlatform() }
