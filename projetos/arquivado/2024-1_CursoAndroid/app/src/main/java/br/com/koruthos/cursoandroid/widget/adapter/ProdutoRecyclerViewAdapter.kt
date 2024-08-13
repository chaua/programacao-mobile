package br.com.koruthos.cursoandroid.widget.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ItemProdutoBinding
import br.com.koruthos.cursoandroid.models.Produto
import com.bumptech.glide.Glide

class ProdutoRecyclerViewAdapter(private val produtos: List<Produto>) : RecyclerView.Adapter<ProdutoRecyclerViewAdapter.ViewHolder>() {

    // Define o layout de cada item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Recupera o objeto que infla um layout
        val layoutInflater = LayoutInflater.from(parent.context)

        // Infla o layout dos itens e retorna o ViewHolder
        val binding = ItemProdutoBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = produtos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]

        // Amarra qual produto será atribuido ao view holder
        holder.binding.produto = produto

        // Comando anterior é equivalente a:
        // holder.binding.produtoTxtNome.text = produto.nome
        // holder.binding.produtoTxtValor.text = produto.valor

        // Carrega a imagem usando a lib Glide
        Glide
            .with(holder.binding.root)
            .load("https://picsum.photos/id/$position/200/300")
            .centerCrop()
            .placeholder(R.drawable.ic_game_boy)
            .into(holder.binding.produtoImgFoto)

        // Cadastra os eventos de callback
        // TODO

    }

    // =================================================================================
    // EVENTO DE CALLBACK
    // =================================================================================

    // TODO ...



    // =================================================================================
    // VIEW HOLDER
    // =================================================================================
    class ViewHolder(val binding: ItemProdutoBinding) : RecyclerView.ViewHolder(binding.root)


}