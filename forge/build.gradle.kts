architectury {
    forge()
}

loom {
    forge {
        mixinConfig( "ad_astra_rocketed-common.mixins.json")
        mixinConfig( "ad_astra_rocketed.mixins.json")
    }

    runs {
        create("data") {
            data()
            programArgs("--all", "--mod", "ad_astra")
            programArgs("--output", project(":common").file("src/main/generated/resources").absolutePath)
            programArgs("--existing", project(":common").file("src/main/resources").absolutePath)
        }
    }
}

val common: Configuration by configurations.creating {
    configurations.compileClasspath.get().extendsFrom(this)
    configurations.runtimeClasspath.get().extendsFrom(this)
    configurations["developmentForge"].extendsFrom(this)
}

dependencies {
    common(project(":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionForge")) { isTransitive = false }

    val minecraftVersion: String by project
    val mixinExtrasVersion: String by project
    val forgeVersion: String by project
    val jeiVersion: String by project

    forge(group = "net.minecraftforge", name = "forge", version = "$minecraftVersion-$forgeVersion")

    modLocalRuntime(group = "mezz.jei", name = "jei-$minecraftVersion-forge", version = jeiVersion) { isTransitive = false }

//    modLocalRuntime(group = "maven.modrinth", name = "jade", version = "13.2.2")
    "modImplementation"("curse.maven:create-planetary-tweaks-594527:4675046")
    "modImplementation"("software.bernie.geckolib:geckolib-forge-1.20:4.2")

//
    forgeRuntimeLibrary("com.teamresourceful:yabn:1.0.3")
    forgeRuntimeLibrary("com.teamresourceful:bytecodecs:1.0.2")

    "annotationProcessor"(group = "io.github.llamalad7", name = "mixinextras-forge", version = mixinExtrasVersion).apply {
        implementation(this)
        "include"(this)
    }
}