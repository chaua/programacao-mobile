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
        // - Inserção de dados fixos apenas para testar o componente
        // - A lista de dados pode vir do BD local ou como resposta de webservice
        mProdutos = listOf(
            Produto("iPhone 9", 549.0, "https://i.dummyjson.com/data/products/1/1.jpg"),
            Produto("iPhone X", 899.0, "https://i.dummyjson.com/data/products/2/1.jpg"),
            Produto("Samsung Universe 9", 1249.0, "https://i.dummyjson.com/data/products/3/1.jpg"),
            Produto("OPPOF19", 280.0, "https://i.dummyjson.com/data/products/4/1.jpg"),
            Produto("Huawei P30", 499.0, "https://i.dummyjson.com/data/products/5/1.jpg"),
            Produto("MacBook Pro", 1749.0, "https://i.dummyjson.com/data/products/6/1.png"),
            Produto("Samsung Galaxy Book", 1499.0, "https://i.dummyjson.com/data/products/7/1.jpg"),
            Produto("Microsoft Surface Laptop 4", 1499.0, "https://i.dummyjson.com/data/products/8/1.jpg"),
            Produto("Infinix INBOOK", 1099.0, "https://i.dummyjson.com/data/products/9/1.jpg"),
            Produto("HP Pavilion 15-DK1056WM", 1099.0, "https://i.dummyjson.com/data/products/10/1.jpg"),
            Produto("perfume Oil", 13.0, "https://i.dummyjson.com/data/products/11/1.jpg"),
            Produto("Brown Perfume", 40.0, "https://i.dummyjson.com/data/products/12/1.jpg"),
            Produto("Fog Scent Xpressio Perfume", 13.0, "https://i.dummyjson.com/data/products/13/1.jpg"),
            Produto("Non-Alcoholic Concentrated Perfume Oil", 120.0, "https://i.dummyjson.com/data/products/14/1.jpg"),
            Produto("Eau De Perfume Spray", 30.0, "https://i.dummyjson.com/data/products/15/1.jpg"),
            Produto("Hyaluronic Acid Serum", 19.0, "https://i.dummyjson.com/data/products/16/1.png"),
            Produto("Tree Oil 30ml", 12.0, "https://i.dummyjson.com/data/products/17/1.jpg"),
            Produto("Oil Free Moisturizer 100ml", 40.0, "https://i.dummyjson.com/data/products/18/1.jpg"),
            Produto("Skin Beauty Serum.", 46.0, "https://i.dummyjson.com/data/products/19/1.jpg"),
            Produto("Freckle Treatment Cream- 15gm", 70.0, "https://i.dummyjson.com/data/products/20/1.jpg"),
            Produto("- Daal Masoor 500 grams", 20.0, "https://i.dummyjson.com/data/products/21/1.png"),
            Produto("Elbow Macaroni - 400 gm", 14.0, "https://i.dummyjson.com/data/products/22/1.jpg"),
            Produto("Orange Essence Food Flavou", 14.0, "https://i.dummyjson.com/data/products/23/1.jpg"),
            Produto("cereals muesli fruit nuts", 46.0, "https://i.dummyjson.com/data/products/24/1.jpg"),
            Produto("Gulab Powder 50 Gram", 70.0, "https://i.dummyjson.com/data/products/25/1.png"),
            Produto("Plant Hanger For Home", 41.0, "https://i.dummyjson.com/data/products/26/1.jpg"),
            Produto("Flying Wooden Bird", 51.0, "https://i.dummyjson.com/data/products/27/1.jpg"),
            Produto("3D Embellishment Art Lamp", 20.0, "https://i.dummyjson.com/data/products/28/1.jpg"),
            Produto("Handcraft Chinese style", 60.0, "https://i.dummyjson.com/data/products/29/1.jpg"),
            Produto("Key Holder", 30.0, "https://i.dummyjson.com/data/products/30/1.jpg"),
        )

        // == Configuração do RecyclerView ==
        val adapter = ProdutoAdapter(mProdutos)

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