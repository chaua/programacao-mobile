package br.com.koruthos.aula15.network

import br.com.koruthos.aula15.models.Curso
import br.com.koruthos.aula15.models.PacoteJSON
import retrofit2.Call
import retrofit2.http.*

// Resposta:
// {
//    "data": ...,
//    "status": 0,
//    "mensagem": "OK"
//    "object": ...
// }

// {"nome": ..., "matricula"}
// {"erro": ...}

interface ApiService {

    // http://services.koruthos.com.br/tecplus/curso_extensao/3
    @GET("curso_extensao/{id}")
    fun listarCurso(@Path("id") id: Int): Call<PacoteJSON<Curso?>?>?

    // Outro exemplo
    // http://services.koruthos.com.br/tecplus/curso_extensao/all?pagina={pagina}&tamanho={tamanho}
    @GET("curso_extensao/all/{pagina}")
    fun listarCursos(@Path("pagina") pagina: Int): Call<PacoteJSON<List<Curso?>?>?>?

    @POST("curso_extensao/new")
    fun inserirCurso(@Body curso: Curso?): Call<PacoteJSON<Curso?>?>?

    @PUT("curso_extensao")
    fun atualizarCurso(@Body curso: Curso?): Call<PacoteJSON<Curso?>?>?

    @DELETE("curso_extensao/{id}")
    fun removerCurso(@Path("id") id: Int): Call<PacoteJSON<Curso?>?>?
}
