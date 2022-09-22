plugins {
    id("org.jetbrains.intellij") version "1.10.0"
}

repositories {
    mavenCentral()
}

intellij {
    version.set("2021.2.2")
    updateSinceUntilBuild.set(false)
    sameSinceUntilBuild.set(false)
}

tasks {
    buildSearchableOptions {
        enabled = false
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

sourceSets {
    main {
        java {
            srcDirs("src", "gen")
        }
        resources {
            srcDirs("res")
        }
    }
}