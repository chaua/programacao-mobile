package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula15FragmentosTabLayoutBinding
import br.com.koruthos.cursoandroid.widgets.adapters.Aula15ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

/**
 * Aula 15 - Fragmentos e View Pager
 */
class Aula15FragmentosTabLayoutActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAula15FragmentosTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout do databinding e define como layout da activity
        mBinding = ActivityAula15FragmentosTabLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Carrega o adapter do view pager, que é responsável por exibir os fragmentos
        mBinding.aula15ViewPager.adapter = Aula15ViewPagerAdapter(this)

        // TabLayoutMediator é responsável por vincular o TabLayout ao ViewPager. Ele é responsável por
        // criar as guias e definir o texto de cada guia.
        //      - TabLayout: É um layout de guias que exibe guias em uma linha horizontal.
        //      - ViewPager: É um layout que permite ao usuário deslizar para a esquerda ou para a direita
        //                   para ver diferentes fragmentos.
        TabLayoutMediator(mBinding.aula15TabLayout, mBinding.aula15ViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.aula15_bnv_home)
                1 -> getString(R.string.aula15_bnv_livros)
                2 -> getString(R.string.aula15_bnv_filmes)
                3 -> getString(R.string.aula15_bnv_perfil)
                else -> getString(R.string.aula15_bnv_home)
            }
        }.attach()
    }


}