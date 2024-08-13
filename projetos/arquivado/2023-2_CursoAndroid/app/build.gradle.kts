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
    implementation("androidx.databinding:databinding-runtime:8.1.2")

    // Biblioteca para criação de imagens redondas
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Biblioteca para carregar imagens:
    //    - Redimensiona imagens automaticamente e realiza a cache
    //    - Tratativa para quando a imagem está carregando ou deu erro
    //    - https://github.com/bumptech/glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Retrofit: biblioteca para realizar chamadas para o webservice
    implementation("com.squareup.retrofit2:retrofit:2.5.0") {
        exclude("okhttp")
    }
    implementation("com.squareup.okhttp3:okhttp:3.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.10.0")
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")

    // Gson: biblioteca para serializar objetos Java em JSON
    implementation("com.google.code.gson:gson:2.8.9")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}