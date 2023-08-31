plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.salla.mvi"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.salla.mvi"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.salla.mvi.presentation.app.InstrumentationTestRunner"

    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation(project(":mvi"))
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.activity:activity-ktx:1.7.2")
    //ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    kapt("androidx.lifecycle:lifecycle-common-java8:2.6.1")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")

//    testImplementation  ("org.mockito:mockito-core:5.5.0")
    androidTestImplementation("org.mockito:mockito-android:5.5.0")
//    testImplementation("org.mockito:mockito-inline:5.5.0")


    implementation("io.insert-koin:koin-android:3.4.3")
    // Koin Test features
    testImplementation("io.insert-koin:koin-test:3.4.3")
    // Koin for JUnit 4
    testImplementation("io.insert-koin:koin-test-junit4:3.4.3")
    // Koin for JUnit 5
    testImplementation("io.insert-koin:koin-test-junit5:3.4.3")

    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")


    //Image Loading
    implementation("io.coil-kt:coil:2.1.0")

}