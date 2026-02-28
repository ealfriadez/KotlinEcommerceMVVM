plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.elionet.ecommerceappmvvm"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.elionet.ecommerceappmvvm"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Retrofit 3.x with Gson converter (replace with the latest version if needed)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.gson)

    //NAVIGATION COMPOSE
    implementation(libs.androidx.navigation.compose)
    implementation(libs.accompanist.systemuicontroller)

    //DAGER HILT - INYECCION DE DEPENDENCIAS
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation (libs.androidx.material3)
    ksp(libs.hilt.android.compiler)

    //MOSHI
    implementation(libs.moshi.v1152)
    implementation(libs.moshi.kotlin)

    //PREFERENCES DATA STORE
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    //COIL - ASYNC IMAGE
    implementation(libs.coil.compose)

    //FILES TRANSFORMATION
    implementation(libs.commons.io)

    //ROOM
    implementation("androidx.room:room-runtime:2.5.0")
    ksp("androidx.room:room-compiler:2.5.0")
    annotationProcessor("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")

    //CARRUSEL DE IMAGENES
    implementation("androidx.compose.foundation:foundation:1.6.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}