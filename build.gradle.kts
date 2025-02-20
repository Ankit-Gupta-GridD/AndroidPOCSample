
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.detekt) apply false
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
