
repositories {
    mavenLocal()
    mavenCentral()
    google()
}

plugins {
    id("io.mailguru.gradle-config") version "1.0.2"
    // add additional plugins here
}

base {
    group = "io.mailguru"
    archivesName.set("mailguru-kotlin-skeleton")
}

mavenPublishing {
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.S01)
    signAllPublications()
    pom {
        name.set("Put the display name here; should differ from the artifactID.")
        description.set("Put your description here.")
        url.set("https://github.com/mlgr-io/kotlin-skeleton")
        licenses {
            license {
                name.set("GNU General Public License, Version 3")
                url.set("https://www.gnu.org/licenses/gpl-3.0.txt")
            }
        }
        developers {
            developer {
                id.set("mlgr-io")
                name.set("mailguru UG (haftungsbeschränkt)")
                email.set("support@mailguru.io")
                url.set("https://github.com/mlgr-io")
            }
        }
        scm {
            connection.set("scm:git:git@github.com:mlgr-io/kotlin-skeleton.git")
            developerConnection.set("scm:git:git@github.com:mlgr-io/kotlin-skeleton.git")
            url.set("https://github.com/mlgr-io/kotlin-skeleton")
        }
    }
    repositories {
        maven {
            url = if (version.toString().endsWith("SNAPSHOT")) {
                uri(layout.buildDirectory.dir("repos/snapshots"))
            } else {
                uri(layout.buildDirectory.dir("repos/releases"))
            }
        }
    }
}
