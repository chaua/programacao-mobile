package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula12ComDataBindingBinding
import br.com.koruthos.cursoandroid.databinding.ActivityTemplateBinding
import br.com.koruthos.cursoandroid.models.Pokemon
import br.com.koruthos.cursoandroid.networks.NetworkManager
import br.com.koruthos.cursoandroid.util.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Exemplo usando a biblioteca retrofit
 */
class Aula18RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Chamada dos metodos da API
        val consulta = NetworkManager.service.consultarPokemon("bulbasaur")

        consulta.enqueue(object : Callback<Pokemon> {

            // Método de call em caso de sucesso
            override fun onResponse(p0: Call<Pokemon>, p1: Response<Pokemon>) {
                onPokemonSuccess(p1.body())
            }

            override fun onFailure(p0: Call<Pokemon>, p1: Throwable) {
                Log.e(TAG, "onFailure: ", p1)
            }

        })


    }

    override fun onStop() {
        super.onStop()
        NetworkManager.stop()
    }

    private fun onPokemonSuccess(pokemon: Pokemon?) {
        Log.d(TAG, "onPokemonSuccess: $pokemon")
    }

}