package br.com.koruthos.cursoandroid.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityRetrofitBinding
import br.com.koruthos.cursoandroid.models.Pokemon
import br.com.koruthos.cursoandroid.models.ResponsePokeAPI
import br.com.koruthos.cursoandroid.network.NetworkManager
import br.com.koruthos.cursoandroid.util.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRetrofitBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)

        // Chamada para os webservices
        // - Activity: realiza no onCreate
        // - Fragmento: realiza no onViewCreated
        val call = NetworkManager.service.getPokemons(20, 0)

        call.enqueue(object : Callback<ResponsePokeAPI> {

            // Resposta de sucesso do servidor
            override fun onResponse(
                call: Call<ResponsePokeAPI>,
                response: Response<ResponsePokeAPI>
            ) {
                Log.d(TAG, "onResponse: código de resposta http - ${response.code()}")
                Log.d(TAG, "onResponse: código de resposta http - ${response.body()}")

                if (response.isSuccessful && response.body() != null) {
                    onSuccess(response.body()!!.results)
                }

            }

            // Resposta de falha do servidor
            override fun onFailure(call: Call<ResponsePokeAPI>, t: Throwable) {
                onError(t.message)
            }

        })


    }

    // Tratativa de sucesso
    private fun onSuccess(pokemons: List<Pokemon>?) {

    }

    // Tratativa de erro
    private fun onError(message: String?) {
        Toast.makeText(this, "ERRO: $message", Toast.LENGTH_SHORT).show()
    }


}