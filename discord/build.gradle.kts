plugins {
  java
}

val mainClass = "com.duuuuardo.singr.SingrLauncher"

repositories {
  gradlePluginPortal()
  google()
  mavenCentral()
  maven("https://dl.bintray.com/kotlin/kotlin-eap")
  maven("https://plugins.gradle.org/m2/")
  maven("https://m2.dv8tion.net/releases")
}

tasks.withType<Jar> { 
  manifest { attributes["Main-Class"] = mainClass } 
  archiveBaseName = "${project.name}-runnable"
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")

  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  implementation("com.squareup.okhttp:okhttp:2.7.5")
  implementation("com.sedmelluq:lavaplayer:1.3.77")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.0")
  implementation("com.google.guava:guava:31.1-jre")
  implementation("org.slf4j:slf4j-api:2.0.7")
  implementation("org.slf4j:slf4j-simple:2.0.7")
  implementation("net.dv8tion:JDA:${Versions.JDA}")
}

tasks.named<Test>("test") { useJUnitPlatform() }
