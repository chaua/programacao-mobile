package br.com.koruthos.cursoandroid.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.koruthos.cursoandroid.R
import java.math.BigDecimal

class Tela03Fragment : Fragment() {

    val TAG = "Tela03"

    var mMensagem: String = ""
    var mNumero: Int = 0

    /**
     * Desempacota as informações recebidas como parâmetro.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mMensagem = arguments?.getString(PARAM_MENSAGEM, "N/A")!!
        mNumero = arguments?.getInt(PARAM_NUMERO, 0)!!
    }

    /**
     * Define o layout do fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        val view = inflater.inflate(R.layout.fragment_tela03, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializa os componentes de tela
        val txtMensagem = activity?.findViewById<TextView>(R.id.tela03_txt_mensagem)
        val txtNumero = activity?.findViewById<TextView>(R.id.tela03_txt_numero)

        txtMensagem?.text = mMensagem
        txtNumero?.text = mNumero.toString()

    }

    /**
     * Builder do fragmento.
     *
     * Método estático usado para auxiliar na construção do Fragmento.
     * O método pertence à classe e não ao objeto. Padroniza a criação
     * dos fragmentos.
     */
    companion object {

        val PARAM_MENSAGEM = "mensagem"
        val PARAM_NUMERO = "numero"

        @JvmStatic
        fun newInstance(mensagem: String, numero: Int) : Tela03Fragment{
            val bundle = Bundle()
            bundle.putString(PARAM_MENSAGEM, mensagem)
            bundle.putInt(PARAM_NUMERO, numero)

            val fragmento = Tela03Fragment()
            fragmento.arguments = bundle
            return fragmento
        }
    }

}



