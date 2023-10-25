package br.com.koruthos.cursoandroid.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ItemProdutoBinding
import br.com.koruthos.cursoandroid.models.Produto
import com.bumptech.glide.Glide
import java.text.NumberFormat

class ProdutoAdapter(private val produtos: List<Produto>) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Recupera o objeto que infla um layout
        val layoutInflater = LayoutInflater.from(parent.context)

        // Infla o layout dos itens e retorna o ViewHolder
        val binding = ItemProdutoBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Amarra o item da lista com o correspondente do ViewHolder
        holder.binding.produto = produtos[position]

        // Carrega as imagens via URL
        Glide
            .with(holder.binding.root)
            .load(produtos[position].foto)
            .centerCrop()
            .placeholder(R.drawable.ic_imagem)
            .error(R.drawable.ic_imagem_erro)
            .into(holder.binding.produtoImgFoto);

        // Também é possível realizar o tratamento de eventos dos componentes do item
        // TODO: amaração das imagens
    }

    // Retorna o número de itens da lista
    override fun getItemCount(): Int  = produtos.size

    // =================================================================================
    // VIEW HOLDER
    // =================================================================================
    class ViewHolder(val binding: ItemProdutoBinding) : RecyclerView.ViewHolder(binding.root)


}