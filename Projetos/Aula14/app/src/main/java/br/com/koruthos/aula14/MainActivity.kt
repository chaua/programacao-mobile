package br.com.koruthos.aula14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

// Atividade é onde executada toda aplicação
// - Atividade é um Context
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Acessar componentes via codigo
        // - Pegar o conteudo do componente
        // - Alterar o conteudo do componente
        // - Cadastrar eventos

        // como acessar?
        // 1. Modo tradicional: informa o id do componente e recupera a referencia
        //    - problemas: Permite acessar um id que não pertence ao layout
        //                 Não sabe qual é o tipo do componente
        val titulo = findViewById<TextView>(R.id.txtTitulo)
        titulo.text = "Minha aplicação!"

        // 2. Via bibliotecas: bibliotecas de terceiros que fazem a amarracao do componente com
        //    uma variável - Dagger, Annotations, DataBinding (MVVM)

        // 3. Via Kotlin
        txtTitulo.text = "Título da aplicação!"
        txtSubtitulo.text = "Subtítulo da aplicação!"

        // Cadastro de eventos: Padrão de projetos Observer
        // - Função lambda (função anonima)
        txtTitulo.setOnClickListener {
            Toast.makeText(this@MainActivity, "Clicou no título!", Toast.LENGTH_LONG).show()
        }

        btnEvento.setOnClickListener { onClickEvento() }

        checkBox.text = "Quero receber promoções!"


    }

    fun onClickEvento() {
        Toast.makeText(this@MainActivity, "Clicou no botão!", Toast.LENGTH_LONG).show()
        txtSubtitulo.text = edtNome.text

        if (checkBox.checked) {
            Toast.makeText(this@MainActivity, "Quero promoções!", Toast.LENGTH_LONG).show()
        }
    }



}
