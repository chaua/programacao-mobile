package br.com.koruthos.aula16.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.koruthos.aula16.R
import br.com.koruthos.aula16.databinding.FragmentHelloBinding

private const val ARG_MENSAGEM = "ARG_MENSAGEM"

class HelloFragment : Fragment() {

    private var mensagem = "Hello!"

    /**
     * Desempacota as informações passadas pela atividade pai.
     * As informações vem via bundle.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Variavel que desempacota as informações recebidas
        // mensagem = arguments.getString(ARG_MENSAGEM)
        arguments?.let {
            mensagem = it.getString(ARG_MENSAGEM)!!
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Cria a view = modo tradicional
        // val view = inflater.inflate(R.layout.fragment_hello, container, false)

        // Cria a view usando data binding
        val binding = FragmentHelloBinding.inflate(inflater, container, false)
        val view = binding.root

        // TODO: amarrar eventos
        binding.txtMensagem.setOnClickListener {
            Toast.makeText(context, "Clicou!", Toast.LENGTH_LONG).show()
        }

        // TODO: inicializar os valores dos componentes
        binding.txtMensagem.text = mensagem

        // TODO: inicia chamadas para webservices

        // Retorna a view criada
        return view
    }


    /**
     * Método estático para realizar a construção do fragmento
     * Pertence a classe e não aos objetos - operações estáticas (static)
     */
    companion object {
        @JvmStatic
        fun newInstance(mensagem: String) =
            HelloFragment().apply{
                arguments = Bundle().apply {
                    putString(ARG_MENSAGEM, mensagem)
                }
            }

        // Fragmento não precisa de parametros via Bundle
        //@JvmStatic
        //fun newInstance() = HelloFragment()

    }

}
