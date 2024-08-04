package com.jaennova.pokedexcompose.navigation

sealed class AppScreens(val route: String) {
    data object PokemonList : AppScreens("pokemonList")
    data object PokemonDetail : AppScreens("pokemonDetail/{pokemonName}")
}