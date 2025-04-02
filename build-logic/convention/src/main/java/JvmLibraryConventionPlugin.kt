import com.zhiro.lecture.plugin.build.logic.convention.configureKotlinJvm
import com.zhiro.lecture.plugin.build.logic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Плагин для настройки Java модулей (common)
 */
class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("java-library")
                apply("org.jetbrains.kotlin.jvm")
            }

            configureKotlinJvm()

            dependencies {
//                библиотеку можно подключить таким образом из toml
                add("implementation", libs.findLibrary("kotlinx-coroutines-core").get())
            }
        }
    }
}
