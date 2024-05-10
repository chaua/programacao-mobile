package br.com.koruthos.cursoandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DataBindingActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Informa qual será o layout para ser carregado na Activity
        setContentView(R.layout.activity_data_binding)

        // Para acessar um componente de tela existem
        // várias maneiras
        // - Modo tradicional
        // - Modo usando bibliotecas de terceiros
        // - Módulo de data binding

        // 1. Modo tradicional
        val painel: TextView = findViewById(R.id.databinding_txt_painel)
        val botao: Button = findViewById(R.id.databinding_btn_oi)

        // Acessando os métodos dos objetos
        painel.text = getString(R.string.app_name)
        painel.text = "${painel.text}\n ----\n\n"

        // Adicionando um evento ao botão

        // Eventos:
        // - Cadastrar uma função lambda
        //      - Código executado é simples
        //      - Código não precisa ser reutilizado
        // - Cadastrar um método da classe
        //      - Código complexo (legibilidade)
        //      - Reutilização de código (operação salvar é chamada pelo
        //      botão e pelo teclado)

        // 1. Cadastrando evento com função lambda
        botao.setOnClickListener {
            Toast.makeText(this, "Oi", Toast.LENGTH_SHORT).show()
            painel.text = "Oi!"
        }

    }

}