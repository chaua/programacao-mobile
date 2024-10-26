package br.com.koruthos.cursoandroid.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.koruthos.cursoandroid.databinding.FragmentAula16PokemonBinding
import br.com.koruthos.cursoandroid.models.Pokemon
import br.com.koruthos.cursoandroid.repository.PokemonRepository
import br.com.koruthos.cursoandroid.util.TAG
import br.com.koruthos.cursoandroid.widgets.adapters.recycler.PokemonAdapter

/**
 * Aula 16 - RecyclerView
 */
class Aula16PokemonFragment : Fragment() {

    private lateinit var mBinding: FragmentAula16PokemonBinding

    /**
     * Carrega o layout XML do fragmento e retorna a View criada.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentAula16PokemonBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    /**
     * Inicializa o fragmento após a View ser criada.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupera uma lista estática de pokémons
        //  - Neste exemplo, a lista de pokémons é fixa, mas em um aplicativo real, a lista
        //    de pokémons seria carregada de uma API ou de um banco de dados.
        //  - A lista é carregada através de um método estático da classe PokemonDAO.
        val pokemons = PokemonRepository().getPokemons()

        // Cria um adapter para exibir a lista de pokémons
        //  - O adapter é uma classe que estende a classe RecyclerView.Adapter e implementa
        //    os métodos necessários para exibir os itens na lista.
        //
        // O construtor da classe adapter possui dois parâmetros:
        //      - A lista de pokémons a ser exibida
        //      - O listener para tratar os cliques nos itens da lista
        val adapter = PokemonAdapter(pokemons, object : PokemonAdapter.EventListener {
            override fun onItemClick(pokemon: Pokemon) {
                abrirPagina(pokemon)
            }
        })

        // Atribui o adapter ao RecyclerView
        mBinding.aula16RvPokemon.adapter = adapter

        // Cria o layout manager para exibir os itens na vertical. Os parâmetros são:
        //      - O contexto da aplicação
        //      - A orientação da lista (LinearLayoutManager.VERTICAL ou LinearLayoutManager.HORIZONTAL)
        //      - Se a lista deve ser invertida
        mBinding.aula16RvPokemon.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // GridLayoutManager: permite organizar os itens em forma de tabela
        // mBinding.aula16RvPokemon.layoutManager = GridLayoutManager(context, 2)
    }

    /**
     * Abre a página do pokémon selecionado no navegador do sistema.
     *
     * @param pokemon: O pokémon selecionado
     */
    private fun abrirPagina(pokemon: Pokemon) {
        Log.d(TAG, "onItemClick: ${pokemon.nome}")

        // Cria um intent para abrir a página do pokémon no navegador do sistema
        //  - O intent é uma mensagem que é enviada para o sistema operacional para realizar uma ação
        //      - ACTION_VIEW é usado para abrir uma página no navegador
        //      - URI representa a página a ser aberta
        val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, Uri.parse(pokemon.urlDetalhes))
        startActivity(intent)
    }


    /**
     * Companion object para criar uma nova instância do fragmento.
     */
    companion object {
        fun newInstance() = Aula16PokemonFragment()
    }
}
