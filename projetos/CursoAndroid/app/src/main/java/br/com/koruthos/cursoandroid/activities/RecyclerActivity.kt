package br.com.koruthos.cursoandroid.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityMainBinding
import br.com.koruthos.cursoandroid.databinding.ActivityRecyclerBinding
import br.com.koruthos.cursoandroid.models.Produto
import br.com.koruthos.cursoandroid.views.adapters.ProdutoAdapter

class RecyclerActivity : AppCompatActivity() {

    // Variável para acessar o databinding
    private lateinit var mBinding: ActivityRecyclerBinding

    private lateinit var mProdutos: List<Produto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler)

        // Inicializa a lista de produtos
        mProdutos = listOf<Produto>(
            Produto("Camiseta", 12.0, ""),
            Produto("Calça", 12.0, ""),
            Produto("PS5", 1200.0, ""),
            Produto("Bolsa", 1300.0, ""),
            Produto("Casaco", 300.0, ""),
            Produto("Bola", 300.0, ""),
            Produto("PS5", 1200.0, ""),
            Produto("Bolsa", 1300.0, ""),
            Produto("Casaco", 300.0, ""),
            Produto("Bola", 300.0, ""),
            Produto("Casaco", 300.0, ""),
            Produto("Bola", 300.0, ""),
            Produto("PS5", 1200.0, ""),
            Produto("Bolsa", 1300.0, ""),
            Produto("Casaco", 300.0, ""),
            Produto("Bola", 300.0, ""),
        )

        // == Configuração do RecyclerView ==
        var adapter = ProdutoAdapter(mProdutos)

        // Define o adapter no RecyclerView
        mBinding.recyclerRecyclerview.adapter = adapter

        // Define o tipo de Layout do RecyclerView
        // - Diz como que itens devem ser organizados no recycler view
        //   - LinearLayoutManager: Organiza os itens em forma de lista na vertical ou horizontal
        //   - GridLayoutManager: Organiza os titem em forma de lista com várias colunas
         mBinding.recyclerRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // mBinding.recyclerRecyclerview.layoutManager = GridLayoutManager(this, 2)

        // Necessário atualizar o recycler view sempre que a lista seja atualizados
        // mBinding.recyclerRecyclerview.adapter.notifyDataSetChanged()


    }

}