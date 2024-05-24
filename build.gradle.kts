plugins {
    id("org.jetbrains.intellij") version "1.17.3"
    id("org.jetbrains.grammarkit") version "2022.3.2.2"
}

repositories {
    mavenCentral()
}

intellij {
    version.set("2023.3")
    updateSinceUntilBuild.set(false)
    sameSinceUntilBuild.set(false)
}

tasks {
    buildSearchableOptions {
        enabled = false
    }
    generateLexer {
        val pkg = "com/krylysov/nsisplugin"
        sourceFile.set(file("src/$pkg/Nsis.flex"))
        targetOutputDir.set(file("gen/$pkg"))
    }
    compileJava {
        dependsOn(generateLexer)
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
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