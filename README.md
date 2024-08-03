# PokeDexCompose

## Rama: feature/data-and-network

Esta rama implementa los modelos de datos y la configuración de red para PokeDexCompose.

### Modelos de Datos

Se han creado las siguientes clases de modelo en `com.jaennova.pokedexcompose.data.model`:

- `Pokemon`: Representa la información detallada de un Pokémon.
- `Sprites`: Contiene las URLs de las imágenes del Pokémon.
- `PokemonList`: Representa la lista de Pokémon obtenida de la API.
- `PokemonListItem`: Representa un elemento individual en la lista de Pokémon.

### Configuración de Red

1. **API Service**

   Se ha creado la interfaz `PokeApiService` en `com.jaennova.pokedexcompose.data.api`:

   ```kotlin
   interface PokeApiService {
       @GET("pokemon")
       suspend fun getPokemonList(): PokemonList

       @GET("pokemon/{name}")
       suspend fun getPokemonDetails(@Path("name") name: String): Pokemon
   }

2. **Retrofit Client**

   Se ha creado la clase `PokeApi` en `com.jaennova.pokedexcompose.data.api` para configurar
   Retrofit:

```kotlin

object RetrofitClient {
private const val BASE_URL = "https://pokeapi.co/api/v2/"

    val instance: PokeApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(PokeApiService::class.java)
    }

}
```
## Cambios Realizados

Creación de modelos de datos en data.model.
Implementación de la interfaz PokeApiService para definir los endpoints de la API.
Configuración de Retrofit para realizar llamadas a la API.

## Próximos Pasos

Implementar el ViewModel para manejar la lógica de negocio.
Crear la UI básica con Jetpack Compose.
Mostrar la lista de Pokémon en la UI