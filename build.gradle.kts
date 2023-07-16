val singrVersion = "2020-SNAPSHOT"
val jdaVersion = "5.0.0-beta.12"

allprojects {
  extra.apply {
    set("singr-version", singrVersion)
    set("jda-version", jdaVersion)
  }
}
