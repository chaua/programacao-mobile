package br.com.koruthos.cursoandroid.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityRecyclerBinding
import br.com.koruthos.cursoandroid.models.Produto
import br.com.koruthos.cursoandroid.widget.adapter.ProdutoRecyclerViewAdapter

class RecyclerActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRecyclerBinding

    private lateinit var mProdutoAdapter: ProdutoRecyclerViewAdapter

    // Pode ser inicializada no construtor ou qndo for preenchida
    private lateinit var mProdutos: MutableList<Produto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler)

        // Define a lista de itens a serem exibidos pelo recycler view
        // - Origem de banco de dados local, via webservice, via arquivo
        // - Vamos usar uma lista estática
        mProdutos = mutableListOf(
            Produto("Batata", "12.99"),
            Produto("Detergente", "1.99"),
            Produto("Televisão", "5,999.99"),
            Produto("PS5", "3,999.99"),
            Produto("Liquidificador", "999.99"),
            Produto("Coca-cola", "9.99"),
            Produto("Batata", "12.99"),
            Produto("Detergente", "1.99"),
            Produto("Televisão", "5,999.99"),
            Produto("PS5", "3,999.99"),
            Produto("Liquidificador", "999.99"),
            Produto("Coca-cola", "9.99"),
        )

        // Configurar o recycler view
        // - Formato do layout
        // - Criação do Adapter
        // - Lista dos itens a serem exibidos
        // - Cadastros de eventos de callback - a activity que é responsável por
        //      tratar os eventos dos componentes da recycler

        // Configuração do layout
        mBinding.recyclerRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false,
        )

//        mBinding.recyclerRecyclerView.layoutManager = GridLayoutManager(
//            this,
//            2
//        )

        // Define o adapter
        mProdutoAdapter = ProdutoRecyclerViewAdapter(mProdutos)
        mBinding.recyclerRecyclerView.adapter = mProdutoAdapter

    }


}