package com.jaennova.pokedexcompose.data.api

import com.jaennova.pokedexcompose.data.model.Pokemon
import com.jaennova.pokedexcompose.data.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): Pokemon
}