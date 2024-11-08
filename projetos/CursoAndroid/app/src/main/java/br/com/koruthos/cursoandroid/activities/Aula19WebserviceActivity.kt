package br.com.koruthos.cursoandroid.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula12ComDataBindingBinding
import br.com.koruthos.cursoandroid.databinding.ActivityAula19WebserviceBinding
import br.com.koruthos.cursoandroid.databinding.ActivityTemplateBinding
import br.com.koruthos.cursoandroid.models.Pokemon
import br.com.koruthos.cursoandroid.models.PokemonResponse
import br.com.koruthos.cursoandroid.networks.NetworkManager
import br.com.koruthos.cursoandroid.util.TAG
import br.com.koruthos.cursoandroid.widgets.adapters.recycler.PokemonAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

/**
 * Exemplo usando a biblioteca retrofit
 */
class Aula19WebserviceActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAula19WebserviceBinding
    private lateinit var mAdapter: PokemonAdapter

    private var mPokemons = mutableListOf<Pokemon>()

    private var mOffset = 0
    private val mLimit = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAula19WebserviceBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Configura o RecyclerView
        mAdapter = PokemonAdapter(mPokemons, object : PokemonAdapter.EventListener {
            override fun onItemClick(pokemon: Pokemon) {
                Toast
                    .makeText(this@Aula19WebserviceActivity, "${pokemon.nome}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onCompartilharClick(pokemon: Pokemon) {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    setType("text/plain")
                    putExtra(Intent.EXTRA_TEXT, "${pokemon.nome}")
                }
                startActivity(Intent.createChooser(intent, "Compartilhar"));
            }

        })

        mBinding.aula19RecyclerView.layoutManager = LinearLayoutManager(this)
        mBinding.aula19RecyclerView.adapter = mAdapter

        // Captura o evento de scroll para carregar mais itens na página
        mBinding.aula19RecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // Se não for mais possível realizar o scroll para baixo, chama o webservice
                if (!recyclerView.canScrollVertically(1)) { //1 for down
                    chamarWebservice()
                }
            }
        })

        // Chamada dos metodos da API
        chamarWebservice()
    }

    private fun chamarWebservice() {
        val consulta = NetworkManager.service.consultarPokemons(mOffset, mLimit)

        consulta.enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(p0: Call<PokemonResponse>, p1: Response<PokemonResponse>) {
                if (p1.body() != null) {
                    onConsultarPokemonsSuccess(p1.body()!!)
                } else {
                    Toast.makeText(this@Aula19WebserviceActivity, "Body vazio!",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(p0: Call<PokemonResponse>, p1: Throwable) {
                Log.e(TAG, "onFailure: $p1", p1)
            }

        })
    }

    private fun onConsultarPokemonsSuccess(response: PokemonResponse) {
        Log.d(TAG, "onConsultarPokemonsSuccess: ")

        // Esconde o progress bar e exibe o recycler view
        mBinding.aula19ProgressBar.visibility = View.GONE
        mBinding.aula19RecyclerView.visibility = View.VISIBLE

        // Adiciona o resultado da lista do webservice ao final da nossa lista que
        // esta amarrada ao adapter
        mPokemons.addAll(response.results)
        Log.d(TAG, "onConsultarPokemonsSuccess: ${mPokemons.size}")

        // Atualiza o adapter
        mAdapter.notifyItemRangeInserted(mOffset, mOffset + mLimit)
        mAdapter.notifyDataSetChanged()

        // Atualiza o offset
        mOffset += mLimit

    }

    override fun onStop() {
        super.onStop()
        NetworkManager.stop()
    }

}