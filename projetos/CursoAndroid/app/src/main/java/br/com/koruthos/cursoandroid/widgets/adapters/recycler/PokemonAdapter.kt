package br.com.koruthos.cursoandroid.widgets.adapters.recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ItemAula16PokemonBinding
import br.com.koruthos.cursoandroid.models.Pokemon
import br.com.koruthos.cursoandroid.util.TAG
import com.bumptech.glide.Glide


/**
 * Aula 16 - RecyclerView.Adapter
 *
 * O adapter é uma classe que estende a classe RecyclerView.Adapter e implementa os métodos necessários
 * para exibir os itens na lista. O adapter é responsável por criar as views dos itens, inflar o layout
 * dos itens, e atualizar as views com os dados dos itens.
 *
 * A classe PokemonAdapter herda da classe abstrata RecyclerView.Adapter. Esta classe possui 3 métodos
 * abstratos:
 *      - onCreateViewHolder: Cria uma nova view para exibir os itens da lista.
 *      - onBindViewHolder: Atualiza a view com os dados do item na posição informada.
 *      - getItemCount: Retorna a quantidade de itens na lista.
 *
 * O construtor da classe PokemonAdapter recebe uma lista de pokémons e um listener para tratar os cliques
 * nos itens da lista. O listener é uma interface que define os métodos para tratar os cliques nos itens.
 * Neste exemplo, declaramos o listener como uma interface interna da classe PokemonAdapter, mas ele poderia
 * ser uma classe separada. O listener é passado como parâmetro para o construtor da classe PokemonAdapter.
 *
 * Além disso, a classe PokemonAdapter possui uma classe interna PokemonViewHolder, que estende a classe
 * RecyclerView.ViewHolder. Esta classe é responsável por manter a referência para a view do item da lista.
 */
class PokemonAdapter(
    val pokemons: List<Pokemon>,
    val callback: EventListener
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    /**
     * onCreateViewHolder: Cria uma nova view para exibir os itens da lista.
     *
     * @param parent: O ViewGroup pai que contém a view.
     * @param viewType: O tipo da view. É possível ter diferentes tipos de views em uma mesma lista.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Recupera o objeto que infla um layout
        val layoutInflater = LayoutInflater.from(parent.context)

        // Infla o layout dos itens e retorna o ViewHolder
        val binding = ItemAula16PokemonBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }


    /**
     * onBindViewHolder: Atualiza a view com os dados do item na posição informada.
     *
     * @param holder: O ViewHolder que contém a view do item.
     * @param position: A posição do item na lista.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: Pokémon da posição ${position}")

        // Recupera o pokemon atual
        val pokemon = pokemons[position]

        // Atualiza a view com os dados do pokemon
        holder.binding.pokemon = pokemon

        // O código acima é equivalente ao código debaixo
        // holder.binding.pokemonName.text = pokemon.nome
        // holder.binding.pokemonType.text = pokemon.tipo

        // Carrega a imagem dos pokemons
        //      - Para isso usaremos a biblioteca Glide. Essa biblioteca é usada para baixar
        //      e exibir imagens de forma eficiente. Ela possui métodos para carregar imagens
        //      de URLs, de arquivos, de recursos, entre outros.
        Glide
            .with(holder.binding.root)
            .load(pokemon.urlImagem)
            .centerCrop()
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_placeholder)
            .into(holder.binding.pokemonImage)

        // Cadastra os eventos de callback
        //      - Neste exemplo, qndo o card for clickado, ele vai avisar a activity
        holder.binding.pokemonCard.setOnClickListener {
            callback.onItemClick(pokemon)
        }

        holder.binding.pokemonImage.setOnClickListener {
            callback.onCompartilharClick(pokemon)
        }

        // Atualiza a view com os dados do pokemon
        holder.binding.executePendingBindings()
    }

    /**
     * getItemCount: Retorna a quantidade de itens na lista.
     */
    override fun getItemCount(): Int = pokemons.size


    // ---------------------------------------------------------------------------------------------
    // INTERFACE:
    // ---------------------------------------------------------------------------------------------

    /**
     * Interface para tratar os eventos de clique nos itens da lista.
     */
    interface EventListener {
        fun onItemClick(pokemon: Pokemon)
        fun onCompartilharClick(pokemon: Pokemon)
    }

    // ---------------------------------------------------------------------------------------------
    // VIEW HOLDER:
    // ---------------------------------------------------------------------------------------------

    /**
     * Classe para manter a referência para a view do item da lista.
     */
    class ViewHolder(val binding: ItemAula16PokemonBinding) : RecyclerView.ViewHolder(binding.root)

}
