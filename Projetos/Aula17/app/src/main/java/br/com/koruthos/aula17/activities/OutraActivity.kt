package br.com.koruthos.aula17.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.koruthos.aula17.R
import br.com.koruthos.aula17.databinding.ActivityOutraBinding

class OutraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOutraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedUtil.setLogado(this, true)
        val contato = SharedUtil.getContato(this)

        binding.txtHello.text = "Contato: ${contato.nome} ${contato.idade}"

    }
}
