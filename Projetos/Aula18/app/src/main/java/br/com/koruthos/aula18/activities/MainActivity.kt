package br.com.koruthos.aula18.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.koruthos.aula15.models.Curso
import br.com.koruthos.aula15.models.PacoteJSON
import br.com.koruthos.aula15.network.NetworkManager
import br.com.koruthos.aula18.R
import br.com.koruthos.aula18.databinding.ActivityMainBinding
import retrofit2.Call

import android.util.Log
import android.view.View

import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.loading?.visibility = View.VISIBLE

        // Realiza uma chamada para o servidor
        val call = NetworkManager.service.listarCursos(0)

        // Chamada assíncrona para o servidor
        // - enqueue(Callback) -> callback tem o retorno do servidor
        //                     -> pode vir a qualquer momento!
        call?.enqueue(object : Callback<PacoteJSON<List<Curso?>?>?> {

            // Servidor retornou resposta!
            override fun onResponse(call: Call<PacoteJSON<List<Curso?>?>?>,
                                    response: Response<PacoteJSON<List<Curso?>?>?>) {
                // Verifica se veio retorno de sucesso: 200 - OK
                if (response.isSuccessful) {
                    tratarSucesso(response.body())
                }
                else if (response.code() == 500) {
                    Log.d("TAG", "ERRO: ${response.message()}")
                }

            }

            // Erro ao processar a resposta do servidor - erro ao converter resposta para objeto
            override fun onFailure(call: Call<PacoteJSON<List<Curso?>?>?>, t: Throwable) {
                Log.e("TAG", "ERRO FATAL!", t)
            }

        })


    }

    private fun tratarSucesso(body: PacoteJSON<List<Curso?>?>?) {
        val listaCursos = body?.objeto

        var mensagem = ""
        for (curso in listaCursos!!) {
            mensagem += curso?.id.toString() + "\n"
            mensagem += curso?.titulo.toString() + "\n"
            mensagem += curso?.descricao.toString() + "\n\n"
        }

        binding?.txtResposta?.text = mensagem
        binding?.loading?.visibility = View.GONE

    }
}
