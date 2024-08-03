# PokeDexCompose

## Rama: feature/viewmodel-and-ui

Esta rama implementa el ViewModel para manejar la lógica de negocio y crea la UI básica con Jetpack Compose para PokeDexCompose.

### ViewModel

Se ha creado `PokemonViewModel` en `com.jaennova.pokedexcompose.ui.viewmodel`:

```kotlin
class PokemonViewModel : ViewModel() {
    private val _pokemonList = MutableStateFlow<List<PokemonListItem>>(emptyList())
    val pokemonList: StateFlow<List<PokemonListItem>> = _pokemonList

    private val _selectedPokemon = MutableStateFlow<Pokemon?>(null)
    val selectedPokemon: StateFlow<Pokemon?> = _selectedPokemon

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getPokemonList()
                _pokemonList.value = response.results
                Log.d("PokemonViewModel", "Fetched ${response.results.size} Pokemon")
            } catch (e: Exception) {
                Log.e("PokemonViewModel", "Error fetching Pokemon list", e)
            }
        }
    }

    fun fetchPokemonDetails(name: String) {
        viewModelScope.launch {
            try {
                val pokemon = RetrofitClient.instance.getPokemonDetails(name)
                _selectedPokemon.value = pokemon
                Log.d("PokemonViewModel", "Fetched details for Pokemon: ${pokemon.name}")
            } catch (e: Exception) {
                Log.e("PokemonViewModel", "Error fetching Pokemon details", e)
            }
        }
    }
}
```
### UI Básica

Se ha creado `PokemonListScreen` en `com.jaennova.pokedexcompose.ui.screens`:

```kotlin
@Composable
fun PokemonApp(viewModel: PokemonViewModel = viewModel()) {
    val pokemonList by viewModel.pokemonList.collectAsState()

    LazyColumn {
        items(pokemonList) { pokemon ->
            Text(text = pokemon.name, modifier = Modifier.padding(16.dp))
        }
    }
}
```

### Cambios Realizados

1. Implementación del `PokemonViewModel` para manejar la lógica de negocio.
2. Creación de una UI básica con Jetpack Compose que muestra una lista de nombres de Pokémon.
3. Integración del ViewModel con la UI para mostrar datos dinámicos.

### Próximos Pasos

1. Mejorar la UI de la lista de Pokémon.
2. Implementar la pantalla de detalles del Pokémon.
3. Agregar navegación entre la lista y los detalles.
4. Implementar la carga de imágenes con Coil.

