package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula12ComDataBindingBinding
import br.com.koruthos.cursoandroid.databinding.ActivityTemplateBinding
import br.com.koruthos.cursoandroid.models.Pokemon
import br.com.koruthos.cursoandroid.models.PokemonResponse
import br.com.koruthos.cursoandroid.networks.NetworkManager
import br.com.koruthos.cursoandroid.util.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

/**
 * Exemplo usando a biblioteca retrofit
 */
class Aula18RetrofitActivity : AppCompatActivity() {

    var mOffset = 0
    val mLimit = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Chamada dos metodos da API
//        val consulta = NetworkManager.service.consultarPokemon("bulbasaur")

//        consulta.enqueue(object : Callback<Pokemon> {
//
//            // Método de call em caso de sucesso
//            override fun onResponse(p0: Call<Pokemon>, p1: Response<Pokemon>) {
//                onPokemonSuccess(p1.body())
//            }
//
//            override fun onFailure(p0: Call<Pokemon>, p1: Throwable) {
//                Log.e(TAG, "onFailure: ", p1)
//            }
//
//        })

        val consulta = NetworkManager.service.consultarPokemons(mOffset, mLimit)

        consulta.enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(p0: Call<PokemonResponse>, p1: Response<PokemonResponse>) {
                if (p1.body() != null) {
                    onConsultarPokemonsSuccess(p1.body()!!)
                } else {
                    Toast.makeText(this@Aula18RetrofitActivity, "Body vazio!",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(p0: Call<PokemonResponse>, p1: Throwable) {
                Log.e(TAG, "onFailure: $p1", p1)
            }

        })


    }

    private fun onConsultarPokemonsSuccess(body: PokemonResponse) {
        for (pokemon in body.results) {
            Log.i(TAG, "$pokemon")
        }

        // Descomentar para chamar todas as páginas
//        mOffset += mLimit
//        NetworkManager.service
//            .consultarPokemons(mOffset, mLimit)
//            .enqueue(object : Callback<PokemonResponse> {
//                override fun onResponse(p0: Call<PokemonResponse>, p1: Response<PokemonResponse>) {
//                    if (p1.body() != null) {
//                        onConsultarPokemonsSuccess(p1.body()!!)
//                    } else {
//                        Toast.makeText(this@Aula18RetrofitActivity, "Body vazio!",Toast.LENGTH_LONG).show()
//                    }
//                }
//
//                override fun onFailure(p0: Call<PokemonResponse>, p1: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            })



    }

    override fun onStop() {
        super.onStop()
        NetworkManager.stop()
    }

    private fun onPokemonSuccess(pokemon: Pokemon?) {
        Log.d(TAG, "onPokemonSuccess: $pokemon")
    }

}