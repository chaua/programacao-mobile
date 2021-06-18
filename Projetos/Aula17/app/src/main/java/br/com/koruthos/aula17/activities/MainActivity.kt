package br.com.koruthos.aula17.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.koruthos.aula17.R
import br.com.koruthos.aula17.databinding.ActivityMainBinding
import br.com.koruthos.aula17.model.Contato
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val estouLogado = SharedUtil.getLogado(this)
        Log.d("TAG", "Status logado $estouLogado")

        val contato = Contato("Scooby Doo", 7)
        SharedUtil.setContato(this, contato)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, OutraActivity::class.java)
            //intent.putExtra("MENSAGEM", "Olá!")
            //intent.putExtra("NUMERO", 42)
            startActivity(intent)
        }
    }
}
