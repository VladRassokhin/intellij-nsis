plugins {
    id("org.jetbrains.intellij") version "1.10.0"
    id("org.jetbrains.grammarkit") version "2021.2.2"
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
    generateLexer {
        source.set("src/com/krylysov/nsisplugin/Nsis.flex")
        targetClass.set("NsisLexer")
        targetDir.set("gen/com/krylysov/nsisplugin")
    }
    compileJava {
        dependsOn(generateLexer)
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