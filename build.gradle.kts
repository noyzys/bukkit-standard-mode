group = "io.github.noyzys.cpvp.standard"
version = "0.0.1-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.4.10"
}

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("io.vavr:vavr-kotlin:0.10.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.+")

    compileOnly(files("C:/Users/opel3/Desktop/Depends/PaperSpigot-1.8.8-R0.1-SNAPSHOT-latest.jar"))
}
