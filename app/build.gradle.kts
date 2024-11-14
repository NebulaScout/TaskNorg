plugins {
    alias(libs.plugins.android.application)

    // Google services gradle plugin
    id("com.google.gms.google-services")
}

android {
    namespace = "com.project.tasknorg"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.project.tasknorg"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.activity)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // import firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))
    // Firebase analytics
    implementation("com.google.firebase:firebase-analytics")

    // Recycler view swipe decorator
    implementation ("it.xabaras.android:recyclerview-swipedecorator:1.4")
}