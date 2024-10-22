package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula15FragmentosBottomNavBinding
import br.com.koruthos.cursoandroid.databinding.ActivityAula15FragmentosViewPagerBinding
import br.com.koruthos.cursoandroid.fragments.Aula15FilmesFragment
import br.com.koruthos.cursoandroid.fragments.Aula15HomeFragment
import br.com.koruthos.cursoandroid.fragments.Aula15LivrosFragment
import br.com.koruthos.cursoandroid.fragments.Aula15PerfilFragment
import br.com.koruthos.cursoandroid.widgets.adapters.Aula15ViewPagerAdapter

/**
 * Aula 15 - Fragmentos e View Pager
 */
class Aula15FragmentosViewPagerActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAula15FragmentosViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout do databinding e define como layout da activity
        mBinding = ActivityAula15FragmentosViewPagerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Carrega o adapter do view pager, que é responsável por exibir os fragmentos
        mBinding.aula15ViewPager.adapter = Aula15ViewPagerAdapter(this)

    }


}