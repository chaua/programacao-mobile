package br.com.koruthos.aula16.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.com.koruthos.aula16.R
import br.com.koruthos.aula16.databinding.ActivityMainBinding
import br.com.koruthos.aula16.fragments.HelloFragment

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    private var fragmentTela1 = HelloFragment.newInstance("Tela 1")
    private var fragmentTela2 = HelloFragment.newInstance("Tela 2")
    private var fragmentTela3 = HelloFragment.newInstance("Tela 3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Amarração do layout via binding
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding?.root)

        trocarFragmento(fragmentTela1)

        // Amarração dos eventos dos botões do bottom navigation
        mBinding?.bottomNavigation?.setOnNavigationItemSelectedListener { onSelecaoBottomNavigation(it) }


    }

    private fun onSelecaoBottomNavigation(menuItem: MenuItem) : Boolean {
        when (menuItem.itemId) {
            R.id.action_tela1 -> {
                trocarFragmento(fragmentTela1)
                return true
            }
            R.id.action_tela2 -> {
                trocarFragmento(fragmentTela2)
                return true
            }
            R.id.action_tela3 -> {
                trocarFragmento(fragmentTela3)
                return true
            }
        }
        return false
    }

    private fun trocarFragmento(fragmento: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.replace(R.id.container, fragmento)
        fragmentTransaction.commit()
    }


}
