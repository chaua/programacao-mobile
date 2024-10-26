/**
 * *************************************************************************************************
 * ARQUIVO: build.gradle.kts
 * *************************************************************************************************
 *
 * Este arquivo é responsável por configurar o projeto Android. Nele, é possível configurar o namespace,
 * versões, configurações de compilação, entre outras configurações.
 *
 * Depois de configurar o arquivo, é necessário sincronizar o projeto para que as configurações sejam
 * aplicadas.
 */

// =================================================================================================
// PLUGINS
// =================================================================================================
// plugins: são responsáveis por adicionar funcionalidades ao projeto.
//      - O plugin com.android.application é responsável por configurar o projeto Android.
//      - O plugin org.jetbrains.kotlin.android é responsável por configurar o projeto Kotlin.
//      - O plugin kotlin-kapt é responsável por configurar a compilação do Kotlin.
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")   // TODO: Precisa adicionar para o DataBinding
}

// =================================================================================================
// ANDROID
// =================================================================================================
// android: é o bloco de configuração do projeto Android. Nele, é possível configurar o namespace,
// versões, configurações de compilação, entre outras configurações.
android {

    // Pacote base do projeto.
    namespace = "br.com.koruthos.cursoandroid"
    // Versão do SDK de compilação.
    compileSdk = 35

    // Configurações padrões do projeto
    defaultConfig {
        // ID da aplicação.
        applicationId = "br.com.koruthos.cursoandroid"
        // Versão mínima do SDK.
        minSdk = 24
        // Versão do SDK de destino.
        targetSdk = 35
        // Versão do código da versão. Deve ser incrementado a cada nova versão.
        versionCode = 1
        // Nome da versão. Utilizado para identificar a versão do aplicativo.
        versionName = "1.0.0"

        // Configurações do teste de instrumentação.
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // buildTypes: são os tipos de compilação do projeto. Nele, é possível configurar as configurações de compilação.
    // No exemplo, a configuração release está desabilitando a minificação e habilitando o proguard.
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    // compileOptions: são as opções de compilação do projeto. Nele, é possível configurar a versão de compatibilidade e destino.
    // No exemplo, a versão de compatibilidade e destino é a 17.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // kotlinOptions: são as opções de compilação do Kotlin. Nele, é possível configurar a versão de destino.
    // No exemplo, a versão de destino é a 17.
    kotlinOptions {
        jvmTarget = "17"
    }

    // buildFeatures: são as funcionalidades de compilação do projeto. Nele, é possível configurar as funcionalidades
    // de data binding e view binding. No exemplo, as funcionalidades de data binding e view binding estão habilitadas.
    buildFeatures {
        dataBinding = true  // TODO: Habilita o Data Binding
    }

    // buildToolsVersion: é a versão da ferramenta de compilação. No exemplo, a versão é a 35.0.0.
    buildToolsVersion = "35.0.0"
}


// =================================================================================================
// DEPENDÊNCIAS
// =================================================================================================
// dependencies: são as dependências do projeto. Para adicionar uma dependência, é necessário utilizar
// a função implementation e passar o nome da dependência.
//    - implementation("nome_da_dependencia")

dependencies {
    // ---------------------------------------------------------------------------------------------
    // DEPENDÊNCIAS DO ANDROID
    // ---------------------------------------------------------------------------------------------

    // androidx.core: é a dependência do Core KTX. Será utilizada para adicionar extensões do Kotlin.
    implementation("androidx.core:core-ktx:1.13.1")

    // androidx.appcompat: é a dependência do AppCompat. Será utilizada para adicionar compatibilidade com versões antigas.
    implementation("androidx.appcompat:appcompat:1.7.0")

    // androidx.constraintlayout: é a dependência do ConstraintLayout. Será utilizada para adicionar o layout de constraint.
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // androidx.databinding: é a dependência do Data Binding. Será utilizada para adicionar o Data Binding.
    implementation("androidx.databinding:databinding-runtime:8.7.1")

    // com.google.android.material: é a dependência do Material Components. Será utilizada para adicionar componentes do Material Design.
    implementation("com.google.android.material:material:1.12.0")

    // ---------------------------------------------------------------------------------------------
    // OUTRAS DEPENDÊNCIAS
    // ---------------------------------------------------------------------------------------------

    // circleimageview: é a dependência do CircleImageView. Serve para adicionar a imagem circular.
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // glide: é a dependência do Glide. Serve para carregar imagens de forma assíncrona.
    implementation("com.github.bumptech.glide:glide:4.12.0")

}