
// Repositories

repositories {
    mavenLocal()
    google()
    mavenCentral()
}

// Plugins

apply(plugin = "com.vanniktech.maven.publish")
apply(plugin = "io.gitlab.arturbosch.detekt")
apply(plugin = "java-library")
apply(plugin = "org.jetbrains.dokka")
apply(plugin = "org.jlleitschuh.gradle.ktlint")

// Dependencies

val versions: Map<String, String> = (extra["versions"] as Map<String, String>)
val kotlinVersion = extra["kotlinVersion"]

dependencies {

    "dokkaHtmlPlugin"("org.jetbrains.dokka:kotlin-as-java-plugin:" + versions["dokka"])

    "api"(platform("org.jetbrains.kotlin:kotlin-bom:" + kotlinVersion))

    "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    "testImplementation"("io.kotest:kotest-assertions-core:" + versions["kotest"])
    "testImplementation"("io.kotest:kotest-property:" + versions["kotest"])
    "testImplementation"("io.kotest:kotest-runner-junit5:" + versions["kotest"])
    "testImplementation"("org.jetbrains.kotlin:kotlin-test-junit5")
    "testImplementation"("org.junit.jupiter:junit-jupiter:" + versions["junit-jupiter"])
}

// Task configuration

tasks.withType<Test> {
    useJUnitPlatform()
}
