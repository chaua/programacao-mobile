package br.com.koruthos.cursoandroid.network

import br.com.koruthos.cursoandroid.models.Product
import br.com.koruthos.cursoandroid.models.ResponseProducts
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyJsonService {

    // Neste arquivo são configurados todos os endpoints do servidor no formato de função usando anotações:
    // - Na declaração de cada função, utiliza o método HTTP do endpoint
    //      @GET, @POST, @DELETE, @PUT, @PATCH
    //
    // - O caminho do endpoint é passado como parâmetro da anotação
    //      @GET("products/")
    //
    // - Se a URL tiver algum parâmetro na URL, ele é definido entre {}.
    // - Este parâmetro deverá ser declarado como parâmetros do método usando a anotação @Path
    //      @DELETE("products/{id})
    //      fun deletar(@Path("id") var): ...
    //
    // - Se a URL tiver algum parâmetro opcionalm ele é definido no método com a anotação @Query
    //
    // - Se o método precisar enviar um objeto no corpo da mensagem, ele é definido com a anotação @Body
    // - IMPORTANTE: o objeto deve ser serializável!
    //
    // - O método deve retornar um Call (retrofit2) com o tipo dos dados esperados na reposta do endpoint

    // GET 	/products 	        // get all products
    @GET("products/")
    fun getTodosProdutos(): Call<ResponseProducts>

    // GET 	/products/1 	    // get single product
    @GET("products/{id}")
    fun getProduto(@Path("id") id: Int): Call<Product>

    // GET 	/products?limit=10&skip=1 	// search products
    @GET("products/")
    fun getProdutosPaginado(@Query("limit") limit: Int, @Query("skip") pagina: Int): Call<ResponseProducts>

    // POST 	/products/add 	// add a product
//    @POST("products/add")
//    fun postProduto(@Body produto: Any): Call<Any>

    // PUT 	/products/1 	    // update a product
//    @PUT("products/{id}")
//    fun putProduto(@Path("id") id: Int, @Body produto: Any): Call<Any>

    // PATCH 	/products/1 	// update a product
//    @PATCH("products/{id}")
//    fun patchProduto(@Path("id") id: Int, @Body produto: Any): Call<Any>

    // DELETE 	/products/1 	// delete a product
//    @DELETE("products/{id}")
//    fun deleteProduto(@Path("id") id: Int): Call<Any>

}