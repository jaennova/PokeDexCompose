# PokéDex Compose

PokéDex Compose es una aplicación Android moderna que utiliza la PokeAPI para mostrar información sobre Pokémon. Esta aplicación sirve como ejemplo de cómo implementar MVVM, Retrofit, Jetpack Compose y otras bibliotecas modernas de Android.

## Características

- Lista de Pokémon con imágenes
- Detalles de Pokémon individual
- Arquitectura MVVM
- UI construida con Jetpack Compose
- Peticiones de red con Retrofit
- Carga de imágenes con Glide

## Tecnologías utilizadas

- Kotlin
- Jetpack Compose
- ViewModel
- Retrofit
- Glide
- Coroutines
- PokeAPI

## Configuración del proyecto

1. Clone el repositorio
2. Abra el proyecto en Android Studio
3. Sincronice el proyecto con los archivos Gradle
4. Ejecute la aplicación en un emulador o dispositivo Android

## Estructura del proyecto

- `data`: Contiene las clases relacionadas con la obtención y manejo de datos.
    - `api`: Definición de la interfaz de Retrofit para la PokeAPI.
    - `model`: Clases de datos que representan la información de Pokémon.
    - `repository`: Implementación del repositorio que maneja la obtención de datos.
- `ui`: Contiene las clases relacionadas con la interfaz de usuario.
    - `theme`: Definición del tema de la aplicación.
    - `pokemonlist`: Pantalla y ViewModel para la lista de Pokémon.
    - `pokemondetail`: Pantalla y ViewModel para los detalles de un Pokémon.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abra un issue primero para discutir lo que le gustaría cambiar.

## Licencia

[MIT](https://choosealicense.com/licenses/mit/)