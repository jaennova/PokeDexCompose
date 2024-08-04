package com.jaennova.pokedexcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.jaennova.pokedexcompose.navigation.AppScreens
import com.jaennova.pokedexcompose.ui.viewmodel.PokemonViewModel

@Composable
fun PokemonApp(viewModel: PokemonViewModel = viewModel(), navController: NavController) {
    val pokemonList by viewModel.pokemonList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Lista de Pokémones",
            style = MaterialTheme.typography.titleMedium,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = CenterHorizontally)
        )
        LazyColumn {
            items(pokemonList) { pokemon ->
                PokemonListItem(
                    pokemon = pokemon,
                    onItemClick = { navController.navigate("${AppScreens.PokemonDetail.route}/${pokemon.name}") })
            }
        }
    }
}
