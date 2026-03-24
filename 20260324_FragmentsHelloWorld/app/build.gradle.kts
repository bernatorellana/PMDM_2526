plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.fragmentshelloworld"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.fragmentshelloworld"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    val fragment_version = "1.8.9"

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("androidx.lifecycle:lifecycle-extensions:2.1.0")

    implementation("androidx.fragment:fragment:${fragment_version}")


    dependencies {
        // For Kotlin use navigation-fragment-ktx, for Java use navigation-fragment
        implementation("androidx.navigation:navigation-fragment:2.8.8")
        implementation("androidx.navigation:navigation-ui:2.8.8")
    }

}