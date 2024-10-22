package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula16RecyclerViewBinding
import br.com.koruthos.cursoandroid.fragments.Aula16PokemonFragment

/**
 * Aula 16 - RecyclerView
 *
 * O RecyclerView é um componente que permite exibir uma lista de itens de forma eficiente e flexível.
 *
 * Ele é mais eficiente que o ListView e o GridView, pois ele recicla as views que não estão visíveis
 * na tela, reduzindo o consumo de memória e melhorando a performance. Além disso, ele permite criar
 * layouts mais complexos, com diferentes tipos de views em uma mesma lista.
 *
 * Para usar o RecyclerView, é necessário criar um adapter que estende a classe RecyclerView.Adapter e
 * implementa os métodos necessários para exibir os itens na lista. O adapter é responsável por criar
 * as views dos itens, inflar o layout dos itens, e atualizar as views com os dados dos itens.
 */
class Aula16RecyclerViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAula16RecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAula16RecyclerViewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Carrega os fragmentos na tela
        val pokemonFragment = Aula16PokemonFragment.newInstance()

        // Atribui o listener para tratar os cliques nos itens da lista
        mBinding.aula16BnvMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.aula16_bnv_pokemon -> trocarFragmento(pokemonFragment)
            }
            true
        }


        // Carrega o primeiro fragmento na tela
        trocarFragmento(pokemonFragment)
    }

    private fun trocarFragmento(fragmento: Aula16PokemonFragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.aula16_container, fragmento)
            .commit()
    }

}