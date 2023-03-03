package br.com.koruthos.cursoandroid.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.models.ResponsePersonagem
import br.com.koruthos.cursoandroid.networks.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tela02Fragment : Fragment() {

    val TAG = "Tela02"

    /**
     * Define o layout do fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        val view = inflater.inflate(R.layout.fragment_tela02, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val service = NetworkManager.service

        val call = service.listarPersonagens(0)

        call.enqueue(object : Callback<ResponsePersonagem> {
            override fun onResponse(
                call: Call<ResponsePersonagem>,
                response: Response<ResponsePersonagem>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<ResponsePersonagem>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }



    /**
     * Builder do fragmento.
     *
     * Método estático usado para auxiliar na construção do Fragmento.
     * O método pertence à classe e não ao objeto. Padroniza a criação
     * dos fragmentos.
     */
    companion object {

        @JvmStatic
        fun newInstance() = Tela02Fragment()
    }

}



