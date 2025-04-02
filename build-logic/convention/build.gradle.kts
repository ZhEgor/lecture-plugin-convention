import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.zhiro.lecture.plugin.convention.build.logic.convention"

// Configure the build-logic plugins to target JDK 11
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
    }
}

dependencies {
    // нужные библиотеки для написания плагинов
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
//        Тут регистрируем наши кастомные плагины
        register("androidLibrary") { // название плагина
            id = "myplugin.android.library" // айди плагина, который можно подключить как id("myplugin.android.library")
            implementationClass = "AndroidLibraryConventionPlugin" // путь к классу
        }
    }
}