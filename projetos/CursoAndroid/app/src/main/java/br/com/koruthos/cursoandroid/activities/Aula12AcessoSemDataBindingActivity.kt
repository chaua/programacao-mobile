package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.util.TAG

/**
 * Aula 12 - Acesso sem DataBinding
 *
 * O objetivo deste código é mostrar como acessar os elementos de uma tela usando o método
 * tradicional, sem o uso do DataBinding. O acesso aos componentes é feito através do método
 * findViewById, que retorna uma referência ao componente desejado.
 *
 * Para acessar um componente, é necessário informar o ID do componente, que é definido no arquivo
 * XML da tela. O ID é definido através do atributo android:id, que recebe um valor único para
 * identificar o componente.
 *
 * As vantagens de usar o método tradicional são:
 *      - Facilidade de acesso aos componentes.
 *      - Não é necessário adicionar dependências no projeto.
 *
 * As desvantagens de usar o método tradicional são:
 *      - A necessidade de fazer o cast do componente para o tipo correto.
 *      - O trabalho manual de acessar cada componente.
 *      - O código fica mais verboso e menos legível.
 *      - O código fica mais propenso a erros.
 */
class Aula12AcessoSemDataBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aula12_sem_data_binding)

        // Acessa os componentes da tela
        //      - O método findViewById retorna uma referência ao componente desejado
        //      - É necessário fazer o cast do componente para o tipo correto
        val titulo = findViewById<TextView>(R.id.databinding_txt_titulo)
        val explicacao = findViewById<TextView>(R.id.databinding_txt_explicacao)

        // Define o texto do título
        //      - A propriedade text define o texto do componente
        //      - O método getString() retorna uma string do arquivo de recursos
        titulo.text = getString(R.string.databinding_txt_titulo_sem_databinding)
        explicacao.text = getString(R.string.databinding_txt_explicacao_sem_databinding)

        // -------------------------
        // Jogo da bomba
        // -------------------------

        // Recupera o array de strings do arquivo de recursos
        //      - O método getStringArray() retorna um array de strings do arquivo de recursos
        val itens = resources.getStringArray(R.array.databinding_btn_itens)

        // Embaralha o array de strings. Cada posição do array representa o botão
        // correspondente na na lista de botões
        itens.shuffle()

        // Cria a lista com todos os botões
        val botoes = listOf<Button>(
            findViewById<Button>(R.id.databinding_btn_02),
            findViewById<Button>(R.id.databinding_btn_03),
            findViewById<Button>(R.id.databinding_btn_01),
            findViewById<Button>(R.id.databinding_btn_04),
            findViewById<Button>(R.id.databinding_btn_05),
            findViewById<Button>(R.id.databinding_btn_06),
            findViewById<Button>(R.id.databinding_btn_07),
            findViewById<Button>(R.id.databinding_btn_08),
            findViewById<Button>(R.id.databinding_btn_09),
            findViewById<Button>(R.id.databinding_btn_10),
            findViewById<Button>(R.id.databinding_btn_11),
            findViewById<Button>(R.id.databinding_btn_12),
        )

        // Para cada botão, cadastra o evento de clique
        for (i in 0 until botoes.size) {

            // setOnClickListener() cadastra o evento de clique no botão
            //     - O método setOnClickListener() recebe um objeto do tipo View.OnClickListener
            //     - O objeto View.OnClickListener é uma interface que define o método onClick()
            //     - O método onClick() é chamado quando o botão é clicado
            //     - A interface View.OnClickListener é uma interface funcional, ou seja, possui
            //       apenas um método abstrato. Por isso, é possível passar uma expressão lambda
            //       para o método setOnClickListener()
            // Implementação do evento de clique usando uma expressão lambda
            botoes[i].setOnClickListener {
                // Troca o texto do botão para o item correspondente
                botoes[i].text = itens[i]

                // Quando o botão for clicado, chama essa função para validar a condição de derrota
                verificaItemClicado(botoes[i], botoes)
            }

        }

    }

    /**
     * Verifica se o item clicado é uma bomba. Se for, exibe a mensagem de derrota, caso contrário,
     * desabilita o botão clicado.
     *
     * @param botaoClicado Botão clicado
     * @param botoes Lista de botões
     */
    private fun verificaItemClicado(botaoClicado: Button, botoes: List<Button>) {
        // Verifica se o botão clicado é uma bomba
        if (botaoClicado.text == "💣") {
            Log.d(TAG, "Você perdeu!")

            // Troca a mensagem exibida na tela
            val mensagem = findViewById<TextView>(R.id.databinding_txt_mensagem)
            mensagem.text = getString(R.string.databinding_txt_mensagem_perdeu)

            // Desabilita todos os botões
            for (botao in botoes) {
                botao.isEnabled = false
            }
        } else {
            Log.d(TAG, "Você clicou no botão ${botaoClicado.text}")

            // Troca a mensagem exibida na tela
            val mensagem = findViewById<TextView>(R.id.databinding_txt_mensagem)
            mensagem.text = getString(R.string.databinding_txt_mensagem_continuar)
        }

    }

}
