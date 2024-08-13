package br.com.koruthos.cursoandroid.activities

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityDatabindingBinding
import br.com.koruthos.cursoandroid.databinding.ActivityFragmentoBinding
import br.com.koruthos.cursoandroid.fragments.HomeFragment
import br.com.koruthos.cursoandroid.fragments.PerfilFragment

class FragmentoActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityFragmentoBinding

    private lateinit var mHomeFragment: HomeFragment
    private lateinit var mPerfilFragment: PerfilFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_fragmento)

        // Instanciação dos framentos
        mPerfilFragment = PerfilFragment.instance(10)
        mHomeFragment = HomeFragment.instance()

        // Adiciona os eventos ao bottomnavigation
        mBinding.fragmentoBottomnavigation.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.action_home -> trocarFragmento(mHomeFragment)
                R.id.action_perfil -> trocarFragmento(mPerfilFragment)
            }
            true
        }

        // Substitui os fragmentos no container
        trocarFragmento(mHomeFragment)
    }

    fun trocarFragmento(fragmento: Fragment) {
        val fragmentManager = supportFragmentManager
        val transacao = fragmentManager.beginTransaction()
        transacao.setTransition(TRANSIT_FRAGMENT_OPEN)
        transacao.replace(R.id.fragmento_container, fragmento)
        transacao.commit()
    }

}