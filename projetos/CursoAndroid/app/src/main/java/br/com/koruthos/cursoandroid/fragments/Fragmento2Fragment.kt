package br.com.koruthos.cursoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.koruthos.cursoandroid.databinding.FragmentFragmento2Binding

class Fragmento2Fragment: Fragment() {

    // onCreateView():
    // - Inflar o layout do fragmento
    // - Retornar a view correspondente
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mBinding = FragmentFragmento2Binding.inflate(inflater, container,false)
        return mBinding.root
    }

    // onViewCreated()
    // - Inicialização dos componentes
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // Criar metodos e atributos estaticos
    // - Existem no contexto da classe, e nao dos objetos
    companion object {

        // Método comum para construção dos objetos
        fun instance() = Fragmento2Fragment()

    }

}