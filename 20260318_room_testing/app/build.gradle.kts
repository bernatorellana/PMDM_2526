plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.a20260318_room_testing"
    compileSdk {
        version = release(36)
    }
    buildFeatures {
        viewBinding=true
    }
    defaultConfig {
        applicationId = "com.example.a20260318_room_testing"
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
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // depedències necessàries per Room
    //===============================================
    // Room runtime
    implementation("androidx.room:room-runtime:2.8.4")

    // Room compiler (annotation processor)
    annotationProcessor("androidx.room:room-compiler:2.8.4")

    // Optional: Room KTX (useful for coroutines, can skip in pure Java)
    implementation("androidx.room:room-ktx:2.8.4")

    // Optional: for LiveData support
    //implementation("androidx.room:room-livedata:2.8.4")
    // Lifecycle / LiveData dependencies
    implementation("androidx.lifecycle:lifecycle-livedata:2.8.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.8.4")
}