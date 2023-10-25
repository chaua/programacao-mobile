package br.com.koruthos.cursoandroid.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.koruthos.cursoandroid.R
import com.google.android.material.textfield.TextInputEditText
import java.util.Locale

class TradutorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tradutor)

        // Acesso aos componentes da tela
        // 1. Modo tradicional: findViewById()
        val textoEntrada: TextInputEditText = findViewById(R.id.tradutor_edt_texto)
        val textoSaida: TextView = findViewById(R.id.tradutor_txt_resultado)
        val botaoTraduzir: Button = findViewById(R.id.tradutor_btn_traduzir)

        // 2. Modo sofisticado: Data Binding
        // TBD!

        // Cadastro de eventos
        // 1. Cadastro de uma função lambda: comandos simples de 1 ou 2 linhas
        botaoTraduzir.setOnClickListener {
            val traducao = traduzirPortunhol(textoEntrada.text.toString())
            textoSaida.text = traducao
        }

        // 2. Cadastro de uma função da classe: comandos complexos ou para reaproveitar
        // TBD!
        // botaoTraduzir.setOnClickListener(<função da classe>)

    }

    fun traduzirPortunhol(mensagem: String): String {

        // Converte a mensagem para minúsculo
        var texto = mensagem.lowercase(Locale.ROOT)

        // Substitui o texto para portunhol
        texto = texto.replace("\\bo\\b".toRegex(), "lo")
        texto = texto.replace("\\ba\\b".toRegex(), "la")
        texto = texto.replace("\\be\\b".toRegex(), "y")
        texto = texto.replace("\\b(é|eh)\\b".toRegex(), "es")
        texto = texto.replace("\\bnós\\b ".toRegex(), "nosotros")
        texto = texto.replace("\\b(tu|vc|você)\\b".toRegex(), "usted")
        texto = texto.replace("\\b(vcs|vocês)\\b".toRegex(), "ustedes")
        texto = texto.replace("\\bj\\b".toRegex(), "shôta")
        texto = texto.replace("\\bJ\\b".toRegex(), "Shôta")
        texto = texto.replace("v".toRegex(), "b")
        texto = texto.replace("ão\\b".toRegex(), "ión")
        texto = texto.replace("ões\\b".toRegex(), "iónes")
        texto = texto.replace("inha\\b".toRegex(), "ita")
        texto = texto.replace("inho\\b".toRegex(), "ito")
        texto = texto.replace("dade\\b".toRegex(), "dad")
        texto = texto.replace("nh".toRegex(), "ñ")
        texto = texto.replace("\\beu\\b".toRegex(), "jo")
        texto = texto.replace("\\bmas\\b".toRegex(), "pero")
        texto = texto.replace("\\bdo\\b".toRegex(), "del")
        texto = texto.replace("\\bem\\b".toRegex(), "en")
        texto = texto.replace("\\bum\\b".toRegex(), "uno")
        texto = texto.replace("\\buma\\b".toRegex(), "una")
        texto = texto.replace("\\b(meu|minha)\\b".toRegex(), "mi")
        texto = texto.replace("\\bbom\\b".toRegex(), "bueno")
        texto = texto.replace("\\bboa\\b".toRegex(), "buena")
        texto = texto.replace("\\bcara\\b".toRegex(), "cabrón")
        texto = texto.replace("\\bhoje\\b".toRegex(), "hoy")
        texto = texto.replace("\\b(\\w)(o)(\\w{2,6})\\b".toRegex(), "$1ue$3")
        texto = texto.replace("\\b(\\w)(e)(\\w{2,6})\\b".toRegex(), "$1ie$3")

        return texto
    }

}