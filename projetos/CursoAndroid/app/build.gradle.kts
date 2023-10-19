// Plugins do projeto
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Plugin necessário para o databinding
//    id("kotlin-kapt")
}

// Configurações do aplicativos
android {
    namespace = "br.com.koruthos.cursoandroid"
    compileSdk = 33

    defaultConfig {
        applicationId = "br.com.koruthos.cursoandroid"
        minSdk = 23
        targetSdk = 33

        // Versionamento da aplicação na loja
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false

            // Otimizações do código de release
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

    // Habilitar o databing
    buildFeatures {
        dataBinding = true
    }

}

// Bibliotecas externas utilizadas no projeto
// Android Arsenal - site com várias bibliotecas disponíveis
dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Inclusão de imagens redondas
    implementation("de.hdodenhof:circleimageview:3.1.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}