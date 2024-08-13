package br.com.koruthos.cursoandroid.network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Padrão de projetos: Singleton
//  - Garante que seja criado somente 1 objeto da classe no projeto todo
//  - Para criar uma classe Singleton, em kotlin declaramos com object
object NetworkManager {

    // URL base da API
    // - Importante - precisa da / no final
    private val URL = "https://pokeapi.co/api/v2/"

    lateinit var client: OkHttpClient

    val service: PokeAPI by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(PokeAPI::class.java)
    }

    fun stop() {
        client.dispatcher().cancelAll()
    }


}