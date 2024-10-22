package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula15FragmentosBottomNavBinding
import br.com.koruthos.cursoandroid.fragments.Aula15FilmesFragment
import br.com.koruthos.cursoandroid.fragments.Aula15HomeFragment
import br.com.koruthos.cursoandroid.fragments.Aula15LivrosFragment
import br.com.koruthos.cursoandroid.fragments.Aula15PerfilFragment

/**
 * Aula 15 - Fragmentos e Bottom Navigation
 */
class Aula15FragmentosBottomNavActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAula15FragmentosBottomNavBinding

    private lateinit var mHomeFragment: Aula15HomeFragment
    private lateinit var mLivrosFragment: Aula15LivrosFragment
    private lateinit var mPerfilFragment: Aula15PerfilFragment
    private lateinit var mFilmesFragment: Aula15FilmesFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout do databinding e define como layout da activity
        mBinding = ActivityAula15FragmentosBottomNavBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Instancia todos os containers de fragmentos
        mHomeFragment = Aula15HomeFragment.newInstance()
        mLivrosFragment = Aula15LivrosFragment.newInstance()
        mFilmesFragment = Aula15FilmesFragment.newInstance()
        mPerfilFragment = Aula15PerfilFragment.newInstance()

        // Define o primeiro fragmento a ser exibido
        if (savedInstanceState == null) {
            trocarFragmento(mHomeFragment)
        }

        // Cadastra o evento para troca de fragmentos na bottom navigation
        mBinding.aula15BnvMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.aula15_bnv_home -> trocarFragmento(mHomeFragment)
                R.id.aula15_bnv_livros -> trocarFragmento(mLivrosFragment)
                R.id.aula15_bnv_filmes -> trocarFragmento(mFilmesFragment)
                R.id.aula15_bnv_perfil -> trocarFragmento(mPerfilFragment)
            }
            true
        }

    }

    /**
     * Método para trocar o fragmento exibido pela activity.
     *
     * @param fragment Fragmento a ser exibido
     */
    private fun trocarFragmento(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.aula15_container, fragment)
            .commit()
    }

//    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        var selectedFragment: Fragment? = null
//
//        when (item.itemId) {
//            R.id.aula15_bnv_home -> selectedFragment = Aula15HomeFragment()
//            R.id.aula15_bnv_livros -> selectedFragment = Aula15LivrosFragment()
//            R.id.aula15_bnv_videos -> selectedFragment = Aula15VideosFragment()
//            R.id.aula15_bnv_perfil -> selectedFragment = Aula15PerfilFragment()
//        }
//
//        selectedFragment?.let {
//            supportFragmentManager.beginTransaction().replace(R.id.aula15_frg_container, it).commit()
//        }
//        true
//    }
}