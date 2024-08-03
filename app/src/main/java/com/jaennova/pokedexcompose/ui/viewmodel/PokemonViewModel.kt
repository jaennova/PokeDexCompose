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