package br.com.koruthos.cursoandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.koruthos.cursoandroid.databinding.FragmentHomeBinding
import br.com.koruthos.cursoandroid.models.ResponseProducts
import br.com.koruthos.cursoandroid.network.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    /**
     * Este método é usado para carregar o layout do fragmento. Segue uma lógica diferente das Atividades.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    /**
     * Este método é usado para inicializar os componentes de tela e chamadas de webservice.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Chamada para o webservice
        val call = NetworkManager.service.getProdutosPaginado(3, 0)

        call.enqueue(object: Callback<ResponseProducts> {

            // onResponse: recebemos a resposta do servidor
            override fun onResponse(call: Call<ResponseProducts>, response: Response<ResponseProducts>) {
                Log.d("TAG", "onResponse: codigo = ${response.code()}")
                val body = response.body()!! // Conteudo da mensagem

                if (response.code() == 200) {
                    exibirProdutos(body)
                } else {
                    Log.e("TAG", "ERRO: codigo = ${response.code()}")
                }

            }

            override fun onFailure(call: Call<ResponseProducts>, t: Throwable) {
                Log.e("TAG", "$t", t)
            }

        })

        // Inicializa o recycler view
        // Inicializa as outras views


    }

    private fun exibirProdutos(body: ResponseProducts) {
        Log.d("TAG", "exibirProdutos: $body")
    }


    override fun onDestroy() {
        super.onDestroy()
        NetworkManager.stop()
    }

    // Builder do fragmento
    // - Por convenção, sempre instanciamos os fragmentos pelo método builder
    companion object {
        fun instance() = HomeFragment()
    }

}