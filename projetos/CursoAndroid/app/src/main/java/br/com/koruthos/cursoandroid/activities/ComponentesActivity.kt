package br.com.koruthos.cursoandroid.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import br.com.koruthos.cursoandroid.R
import com.google.android.material.textfield.TextInputEditText

class ComponentesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_componentes)

        // * Acesso aos componentes
        //
        // Modo tradicional:
        //      - Usamos a função findViewById() que é herdada da Activity
        //      - Problema 1: falta de amarração entre o ID e a tela - pode gerar erros
        //      - Problema 2: Boiler plate code para recuperar os componentes
        //
        // Uso de bibliotecas para amarração:
        //      - Bibliotecas de terceiros que reduzem o boilerplate
        //      - Problema: suporte de terceiros para biblioteca
        //
        // Data binding:
        //      - Já está incluos na biblioteca padrão do android (Jetpack - androidx)

        // Modo de acesso tradicional
        val textView1: TextView = findViewById(R.id.componentes_txt_texto)
        textView1.text = "Alô, mamãe"
        textView1.text = getText(R.string.app_name)

        // Cadastrar eventos aos componentes
        //  - Todos os eventos que o componente responde começam com a palavra On
        //  - Padrão de projetos Observer
        //
        //      - Via expressão lambda
        //      - Via método da classe
        val botao1: Button = findViewById(R.id.componentes_btn_ok)
        val botao2: Button = findViewById(R.id.componentes_btn_nok)
        val edtNormal: TextInputEditText = findViewById(R.id.componentes_edt_normal)

        // Exemplo com expressão lambda:
        //  - Usamos quando código é simples: 1 ou 2 linhas
        //  - Se o evento tiver apenas um parâmetro, o kotlin declara implicitamente o parametro
        //       como it
        //  - Se tiver mais de um parametro, é obrigatorio declarar todos parametros
        //
        //  SINTAXE: { param: Tipo -> implementação }
        botao1.setOnClickListener {
            Toast.makeText(this, "Clicou no botão 1!", Toast.LENGTH_SHORT).show()
        }

        // Exemplo com método da classe
        //  - Usamos método da classe para operações complexas ou reaproveitar código
        //
        // SINTAXE: listener(::nomeDoMetodo)
        botao2.setOnClickListener(::onBotaoLongClick)

        // Exemplo com listener que possui mais de um método
        //  - Usando quando o listenter possui mais de um método de evento
        //  - Precisa declarar como object : InterfaceDoEvento
        //  - Os métodos são implementados com a sobrescrita dos métodos
        //  - Acesso à classe externa via: this@NomeDaClasseExterna
        edtNormal.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                Toast.makeText(this@ComponentesActivity, "Editou $p1!", Toast.LENGTH_SHORT).show()
                return true
            }
        })

    }


    fun onBotaoLongClick(view: View) {
        Toast.makeText(this, "Clicou no botão 2!", Toast.LENGTH_SHORT).show()
    }


}