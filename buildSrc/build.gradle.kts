import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    `kotlin-dsl`
    kotlin("plugin.serialization") version "1.5.31"
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("commons-codec:commons-codec:1.15")
}
