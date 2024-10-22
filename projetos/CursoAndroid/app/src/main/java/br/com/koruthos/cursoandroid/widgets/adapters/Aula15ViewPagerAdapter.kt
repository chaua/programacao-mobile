package br.com.koruthos.cursoandroid.widgets.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.koruthos.cursoandroid.fragments.Aula15FilmesFragment
import br.com.koruthos.cursoandroid.fragments.Aula15HomeFragment
import br.com.koruthos.cursoandroid.fragments.Aula15LivrosFragment
import br.com.koruthos.cursoandroid.fragments.Aula15PerfilFragment

/**
 * ViewPagerAdapter
 *
 * Esta classe é responsável por gerenciar os fragmentos que serão exibidos no ViewPager2.
 *
 * O viewpager é um componente que permite a navegação entre diferentes fragmentos, deslizando
 * o dedo na tela. Ele é muito utilizado em aplicativos que possuem muitas telas, como galerias
 * de imagens, listas de produtos, etc.
 *
 * Precisamos criar um adapter que estenda a classe FragmentStateAdapter, que é responsável por
 * gerenciar os fragmentos que serão exibidos no ViewPager2. O adapter é responsável por criar
 * os fragmentos e retorná-los de acordo com a posição.
 */

class Aula15ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    /**
     * Método para criar o fragmento de acordo com a posição.
     */
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Aula15HomeFragment.newInstance()
            1 -> Aula15LivrosFragment.newInstance()
            2 -> Aula15FilmesFragment.newInstance()
            3 -> Aula15PerfilFragment.newInstance()
            else -> Aula15HomeFragment.newInstance()
        }
    }

    /**
     * Método para retornar a quantidade de fragmentos.
     */
    override fun getItemCount(): Int {
        return 4
    }
}