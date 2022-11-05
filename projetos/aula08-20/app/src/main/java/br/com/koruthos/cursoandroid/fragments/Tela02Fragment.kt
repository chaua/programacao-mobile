package br.com.koruthos.cursoandroid.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.koruthos.cursoandroid.R

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



