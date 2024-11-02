package br.com.koruthos.cursoandroid.networks

import br.com.koruthos.cursoandroid.network.PokemonService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Classe para gerenciar as chamadas aos serviços da API.
 */
object NetworkManager {

    // URL base da API - Terminar a URL com /
    private val URL = "https://pokeapi.co/api/v2/"

    lateinit var client: OkHttpClient

    val service: PokemonService by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(PokemonService::class.java)
    }

    fun stop() {
        client.dispatcher().cancelAll()
    }
}
