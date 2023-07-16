plugins { application }

repositories { mavenCentral() }

tasks.jar {
  manifest.attributes["Main-Class"] = "com.duuuuardo.singr.SingrLauncher"
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")

  testRuntimeOnly("org.junit.platform:junit-platform-launcher")

  implementation("com.google.guava:guava:31.1-jre")
}


java { toolchain { languageVersion.set(JavaLanguageVersion.of(11)) } }

application { mainClass.set("com.duuuuardo.singr.App") }

tasks.named<Test>("test") { useJUnitPlatform() }
