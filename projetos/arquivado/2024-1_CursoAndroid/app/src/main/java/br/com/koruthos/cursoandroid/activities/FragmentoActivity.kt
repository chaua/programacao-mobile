package br.com.koruthos.cursoandroid.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import br.com.koruthos.cursoandroid.fragments.Fragmento1Fragment
import br.com.koruthos.cursoandroid.fragments.Fragmento2Fragment
import br.com.koruthos.cursoandroid.fragments.Fragmento3Fragment
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityFragmentoBinding

class FragmentoActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityFragmentoBinding

    private lateinit var mFragmento1: Fragmento1Fragment
    private lateinit var mFragmento2: Fragmento2Fragment
    private lateinit var mFragmento3: Fragmento3Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_fragmento)

        // Instancia os fragmentos
        mFragmento1 = Fragmento1Fragment.instance()
        mFragmento2 = Fragmento2Fragment.instance()
        mFragmento3 = Fragmento3Fragment.instance()

        // Cadastra os eventos na bottom navigation
        mBinding.fragmentoBottomNav.setOnItemSelectedListener {
            // Verificar qual ação foi selecionada - retorna true
            when (it.itemId) {
                R.id.action_frag1 -> trocarFragmento(mFragmento1)
                R.id.action_frag2 -> trocarFragmento(mFragmento2)
                R.id.action_frag3 -> trocarFragmento(mFragmento3)

                // Retorna false se nenhuma ação foi selecionada
                else -> false
            }

        }

        // Carrega o primeiro fragmento
        trocarFragmento(mFragmento1)
    }


    fun trocarFragmento(fragmento: Fragment): Boolean {
        val fragmentManager = supportFragmentManager
        val transacao = fragmentManager.beginTransaction()
        transacao.setTransition(TRANSIT_FRAGMENT_OPEN)
        transacao.replace(R.id.fragmento_container, fragmento)
        transacao.commit()
        return true
    }


}