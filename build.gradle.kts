import org.gradle.jvm.tasks.Jar

plugins { java }

allprojects {
  group = "com.duuuuardo.singr"
  version = Versions.SINGR

  repositories {
    mavenCentral()
    mavenLocal()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    maven("https://jitpack.io")
    maven("https://m2.dv8tion.net/releases")
  }
  tasks {
    register("fatJar", Jar::class.java) {
      archiveClassifier.set("all")
      duplicatesStrategy = DuplicatesStrategy.EXCLUDE
      from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
      val sourcesMain = sourceSets.main.get()
      from(sourcesMain.output)
    }
  }
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

java { toolchain { languageVersion.set(JavaLanguageVersion.of(11)) } }
