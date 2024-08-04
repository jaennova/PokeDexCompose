package com.jaennova.pokedexcompose.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jaennova.pokedexcompose.ui.screens.PokemonApp
import com.jaennova.pokedexcompose.ui.screens.PokemonDetailScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.PokemonList.route) {
        composable(AppScreens.PokemonList.route) {
            PokemonApp(navController = navController)
        }

        composable(
            route = "${AppScreens.PokemonDetail.route}/{pokemonName}",
            arguments = listOf(navArgument("pokemonName") { type = NavType.StringType })
        ) { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName")
            Log.d("Navigation", "Entering Pokemon detail screen with name: $pokemonName")
            if (pokemonName != null) {
                PokemonDetailScreen(
                    pokemonName = pokemonName,
                    navController = navController
                )
            } else {
                Log.e("Navigation", "Pokemon name is null in detail screen")
            }
        }
    }
}