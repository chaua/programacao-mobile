package br.com.koruthos.cursoandroid.network

import br.com.koruthos.cursoandroid.models.Pokemon
import br.com.koruthos.cursoandroid.models.PokemonResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    // https://pokeapi.co/api/v2/pokemon?offset=10&limit=10
    @GET("pokemon")
    fun consultarPokemons(@Query("offset") offset:Int, @Query("limit") limit:Int = 10): Call<PokemonResponse>

    // https://pokeapi.co/api/v2/pokemon/bulbassaur
    @GET("pokemon/{nome}")
    fun consultarPokemon(@Path("nome") nome: String): Call<Pokemon>

    // https://pokeapi.co/api/v2/pokemon
    @POST("pokemon")
    fun inserirPokemon(@Body pokemon: Pokemon): Call<Pokemon>

    @PUT("pokemon/{id}")
    fun atualizarPokemon(@Path("id") id: Int, @Body pokemon: Pokemon): Call<String?>

    @DELETE("pokemon/{id}")
    fun deletarPokemon(@Path("id") id: Int): Call<String?>


}