package com.jaennova.pokedexcompose.ui.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaennova.pokedexcompose.data.api.RetrofitClient
import com.jaennova.pokedexcompose.data.model.Pokemon
import com.jaennova.pokedexcompose.data.model.PokemonListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val _pokemonList = MutableStateFlow<List<PokemonListItem>>(emptyList())
    val pokemonList: StateFlow<List<PokemonListItem>> = _pokemonList

    private val _selectedPokemon = MutableStateFlow<Pokemon?>(null)
    val selectedPokemon: StateFlow<Pokemon?> = _selectedPokemon

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = RetrofitClient.instance.getPokemonList()
                _pokemonList.value = response.results
            } catch (e: Exception) {
                _error.value = "Error al cargar la lista de Pokémon"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchPokemonDetails(name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            _selectedPokemon.value = null
            try {
                val pokemon = RetrofitClient.instance.getPokemonDetails(name)
                _selectedPokemon.value = pokemon
            } catch (e: Exception) {
                _error.value = "Error al cargar los detalles del Pokémon"
            } finally {
                _isLoading.value = false
            }
        }
    }
}