package br.com.koruthos.cursoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.koruthos.cursoandroid.databinding.FragmentHomeBinding
import br.com.koruthos.cursoandroid.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {

    private lateinit var mBinding: FragmentPerfilBinding

    /**
     * Este método é usado para carregar o layout do fragmento. Segue uma lógica diferente das Atividades.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentPerfilBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    /**
     * Este método é usado para inicializar os componentes de tela e chamadas de webservice.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //mBinding....
    }


    // Builder do fragmento
    // - Por convenção, sempre instanciamos os fragmentos pelo método builder
    companion object {

        // TODO: Passgem de parâmetro para o fragmento
        fun instance(num: Int) = PerfilFragment()
    }

}