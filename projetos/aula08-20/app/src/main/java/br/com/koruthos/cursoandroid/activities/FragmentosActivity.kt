package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.fragments.Tela01Fragment
import br.com.koruthos.cursoandroid.fragments.Tela02Fragment
import br.com.koruthos.cursoandroid.fragments.Tela03Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentosActivity : AppCompatActivity() {
    private val TAG = "Fragmentos"

    lateinit var mTela01Fragment: Tela01Fragment
    lateinit var mTela02Fragment: Tela02Fragment
    lateinit var mTela03Fragment: Tela03Fragment

    lateinit var mNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        // Cadastra os eventos do bottomNavigation
        mNavigation = findViewById(R.id.fragmentos_navigation)
        mNavigation.setOnItemSelectedListener(::onNavigationClick)

        // Instancia os fragmentos de uma vez só
        mTela01Fragment = Tela01Fragment.newInstance()
        mTela02Fragment = Tela02Fragment.newInstance()
        mTela03Fragment = Tela03Fragment.newInstance("Olá, mundo!", 42)


        mTela03Fragment.mMensagem

        trocarFragmento(mTela01Fragment)
    }

    private fun onNavigationClick(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.action_home -> trocarFragmento(mTela01Fragment)
            R.id.action_objetivos -> trocarFragmento(mTela02Fragment)
            R.id.action_perfil -> trocarFragmento(mTela03Fragment)
        }
        return true
    }

    /**
     * Função para realizar a troca dinâmica dos fragmentos.
     */
    private fun trocarFragmento(fragmento: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.replace(R.id.fragmentos_container, fragmento)
        fragmentTransaction.commit()
    }
}
