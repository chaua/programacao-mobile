package br.com.koruthos.cursoandroid.network

import br.com.koruthos.cursoandroid.models.Personagem
import br.com.koruthos.cursoandroid.models.ResponsePersonagem
import retrofit2.Call
import retrofit2.http.*

// Define todos os enpoints do webservice
interface ApiService {

    // --------------------------------
    // https://rickandmortyapi.com/api/character

    @GET("character?page={pagina}")
    fun listarPersonagens(@Path("pagina") pagina: Int) : Call<ResponsePersonagem>

    // Exemplo de outra operações
    @POST("character")
    fun inserirPersonagem(@Body personagem: Personagem) : Call<Personagem>

    @PUT("character/{id}")
    fun atualizarPersonagem(@Path("id") id: Int, @Body personagem: Personagem) : Call<Personagem>

    @DELETE("character/{id}")
    fun deletarPersonagem(@Path("id") id: Int) : Call<Personagem>



}
