plugins {
    application
    kotlin("jvm") version "1.6.20"
}

repositories {
    mavenCentral()
}

dependencies {

}

application {
    mainClass.set("com.geno1024.qqtangextractor.QQTangExtractor")
}

tasks {
    val fatJar = register<Jar>("fatJar") {
        dependsOn("compileJava", "compileKotlin", "processResources")
        from(
            configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) },
            sourceSets.main.get().output
        )
        manifest {
            attributes(
                "Main-Class" to application.mainClass
            )
        }
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    build {
        dependsOn(fatJar)
    }
}
