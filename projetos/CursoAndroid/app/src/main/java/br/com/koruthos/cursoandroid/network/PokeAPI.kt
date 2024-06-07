package br.com.koruthos.cursoandroid.network

import br.com.koruthos.cursoandroid.models.Pokemon
import br.com.koruthos.cursoandroid.models.ResponsePokeAPI
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

// Esta interface é usada para mapear todas as chamadas REST da API
// dentro do nosso projeto
// Estrutura das chamadas REST:
//  REQUEST:
//      - parametros como parte da url
//      - parametros opcionais da url
//      - objetos no body
// RESPONSE
//      - sem retorno
//      - objetos no body

interface PokeAPI {

    // GET: Retorna varios itens
    // Query: parametros passados depois da ?
    @GET("pokemon")
    fun getPokemons(@Query("limit") limit: Int = 10,
                    @Query("offset") offset: Int = 10) : Call<ResponsePokeAPI>

    // GET: Retorna unico item
    @GET("pokemon/{nome}")
    fun getPokemon(@Path("nome") nome: String) : Call<ResponsePokeAPI>

    // POST: Cadastrar um item
    @POST("pokemon")
    fun postPokemon(@Body pokemon: Pokemon) : Call<String?>

    // PUT/PATCH: Atualizar um item
    @PUT("pokemon/{id}")
    fun putPokemon(@Path("id") id: Int,
                   @Body pokemon: Pokemon) : Call<String?>

    @PATCH("pokemon/{id}")
    fun patchPokemon(@Path("id") id: Int,
                     @Body pokemon: Pokemon) : Call<String?>

    // DELETE: Deletar um item
    @DELETE("pokemon/{id}")
    fun deletePokemon(@Path("id") id: Int) : Call<String?>


}