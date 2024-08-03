package com.jaennova.pokedexcompose.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jaennova.pokedexcompose.ui.viewmodel.PokemonViewModel

@Composable
fun PokemonApp(viewModel: PokemonViewModel = viewModel()) {
    val pokemonList by viewModel.pokemonList.collectAsState()

    LazyColumn {
        items(pokemonList) { pokemon ->
            Text(text = pokemon.name, modifier = Modifier.padding(16.dp))
        }
    }
}