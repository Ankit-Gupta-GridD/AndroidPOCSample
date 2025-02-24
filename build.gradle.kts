
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.detekt) apply true
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
}

detekt{
    source.setFrom("src/main/java", "src/main/kotlin")
    config.setFrom("$rootDir/detekt.yml")
    buildUponDefaultConfig = true // Merges with default rules of detek
    parallel = true
    ignoreFailures = false // CI will fail if issues are found
}

tasks.register("detektAll") {
    group = "verification"
    description = "Run Detekt on all modules"

    dependsOn(
        subprojects.mapNotNull {
            it.tasks.findByName("detekt")
        }
    )
}
