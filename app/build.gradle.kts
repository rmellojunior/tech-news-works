import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.technewsworks"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.technewsworks"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    flavorDimensions += "source"
    productFlavors {
        create("lite") {
            dimension = "source"

            // securing API_KEY (basic approach)
            val properties = Properties()
            properties.load(file("./src/main/local.properties").inputStream())
            buildConfigField("String", "API_KEY", properties.getProperty("API_KEY") ?: "")
        }
        create("premium") {
            dimension = "source"
            applicationIdSuffix = ".premium"

            // securing API_KEY (basic approach)
            val properties = Properties()
            properties.load(file("./src/premium/local.properties").inputStream())
            buildConfigField("String", "API_KEY", properties.getProperty("API_KEY") ?: "")
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // DI
    val daggerHiltVersion = "2.49"
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    annotationProcessor("com.google.dagger:hilt-compiler:$daggerHiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-compiler:$daggerHiltVersion")

    // NETWORK
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    // IMAGE
    implementation("com.github.skydoves:landscapist-glide:2.3.1")

    // PAGING
    val pagingVersion = "3.2.1"
    implementation("androidx.paging:paging-runtime-ktx:$pagingVersion")
    implementation("androidx.paging:paging-compose:$pagingVersion")

    // BIOMETRIC
    implementation("androidx.biometric:biometric:1.2.0-alpha05")


    // TESTS
    implementation("androidx.paging:paging-testing:$pagingVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
    // default libs
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // mockk
    val mockkVersion = "1.13.9"
    testImplementation("io.mockk:mockk:$mockkVersion")
}