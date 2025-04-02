import com.android.build.api.dsl.ApplicationExtension
import com.zhiro.lecture.plugin.build.logic.convention.configureKotlin
import com.zhiro.lecture.plugin.build.logic.convention.utils.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies


/**
 * Плагин для настройки application модулей (app)
 */
class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                compileSdk = 35 // тот самый compileSdk

                defaultConfig {
                    minSdk = 27
                    targetSdk = 35
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }

                configureKotlin()
            }

            dependencies {
                add("implementation", libs.findLibrary("kotlinx-coroutines-core").get())
            }
        }
    }
}
