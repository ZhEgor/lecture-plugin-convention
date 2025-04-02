import com.android.build.api.dsl.LibraryExtension
import com.zhiro.lecture.plugin.build.logic.convention.configureKotlin
import com.zhiro.lecture.plugin.build.logic.convention.utils.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * Плагин для настройки Android модулей (auth, dashboard, data, domain)
 */
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
//                те самые плагины которые подключаем через, id("com.android.library")
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {

                compileSdk = 35 // тот самый compileSdk

                defaultConfig {
                    minSdk = 27
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }
                // объявили экстеншин для удобства
                configureKotlin()
            }

            dependencies {
//                библиотеку можно подключить таким образом из toml
                add("implementation", libs.findLibrary("kotlinx-coroutines-core").get())
            }
        }
    }
}