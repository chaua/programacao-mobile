package br.com.koruthos.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import br.com.koruthos.cursoandroid.databinding.ActivityDataBindingBinding
import br.com.koruthos.cursoandroid.databinding.ActivityFragmentoBinding
import br.com.koruthos.cursoandroid.databinding.ActivityMainBinding
import br.com.koruthos.cursoandroid.util.TAG

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
//        mBinding.fragmentoBottomNav.



        // Carrega o primeiro fragmento
        trocarFragmento(mFragmento1)

    }


    fun trocarFragmento(fragmento: Fragment) {
        val fragmentManager = supportFragmentManager
        val transacao = fragmentManager.beginTransaction()
        transacao.setTransition(TRANSIT_FRAGMENT_OPEN)
        transacao.replace(R.id.fragmento_container, fragmento)
        transacao.commit()
    }


}