# PokeDexCompose

PokeDexCompose es una aplicación de Android que utiliza la PokeAPI para mostrar información sobre Pokémon. Este proyecto sirve como ejemplo de cómo consumir una API REST usando Retrofit y la arquitectura MVVM en Android con Jetpack Compose.

## Rama: setup-initial-project

Esta rama contiene la configuración inicial del proyecto PokeDexCompose.

### Configuración del proyecto

1. Se creó un nuevo proyecto en Android Studio usando la plantilla "Empty Compose Activity".
2. Se configuró el archivo `build.gradle.kts` con las dependencias necesarias.

### Dependencias principales

- Retrofit para las llamadas a la API
- Coil para la carga de imágenes
- ViewModel de Jetpack para la arquitectura MVVM

### Estructura del proyecto

Se crearon los siguientes paquetes principales:

- `com.jaennova.pokedexcompose.data.api`
- `com.jaennova.pokedexcompose.data.model`
- `com.jaennova.pokedexcompose.ui.viewmodel`
- `com.jaennova.pokedexcompose.ui.screen`

### Configuración de AndroidManifest.xml

Se añadió el permiso de internet al archivo `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

### Configuración de libs.versions.toml

Se creó el archivo `libs.versions.toml` en la raíz del proyecto con las versiones de las dependencias:

```toml
[versions]
retrofit = "2.9.0"
coilCompose = "2.4.0"
converterGson = "2.9.0"
lifecycleRuntimeKtx = "2.8.4"
navigationCompose = "2.7.7"

[libraries]
androidx-lifecycle-viewmodel-compose = { module = "androidx.lifecycle:lifecycle-viewmodel-compose", version.ref = "lifecycleRuntimeKtx" }
coil-compose = { module = "io.coil-kt:coil-compose", version.ref = "coilCompose" }
converter-gson = { module = "com.squareup.retrofit2:converter-gson", version.ref = "converterGson" }
androidx-navigation-compose = { group = "androidx.navigation", name = "navigation-compose", version.ref = "navigationCompose" }
retrofit = { module = "com.squareup.retrofit2:retrofit", version.ref = "retrofit" }
kotlinx-coroutines-android = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-android", version.ref = "kotlinxCoroutinesAndroid" }
```

### Configuración de build.gradle.kts

Se añadieron las siguientes dependencias al archivo `app/build.gradle.kts`:

```kotlin
dependencies {

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Coil
    implementation(libs.coil.compose)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Otras dependencias...
}
```