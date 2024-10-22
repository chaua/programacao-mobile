package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula12ComDataBindingBinding
import br.com.koruthos.cursoandroid.util.TAG

/**
 * Aula 12 - Acesso com DataBinding
 *
 * O objetivo deste código é mostrar como acessar os elementos de uma tela usando o DataBinding.
 * DataBinding é uma biblioteca que permite acessar os elementos de uma tela de forma mais simples
 * e direta, sem a necessidade de fazer o cast do componente. O acesso aos componentes é feito
 * através de uma classe gerada automaticamente pelo DataBinding, que contém referências para os
 * componentes da tela.
 *
 * Para usar o DataBinding, é necessário realizar três configurações iniciais:
 *      - Habilitar o DataBinding no arquivo build.gradle do módulo do projeto.
 *      - Adicionar a tag <layout> no arquivo XML da tela.
 *      - Inflar a tela usando o método DataBindingUtil.setContentView().
 *
 * As vantagens de usar o Data Binding são:
 *      - Facilidade de acesso aos componentes.
 *      - Não é necessário fazer o cast do componente.
 *      - O código fica mais limpo e legível.
 *      - O código fica menos propenso a erros.
 *
 * As desvantagens de usar o Data Binding são:
 *      - A necessidade de adicionar dependências no projeto.
 *      - A necessidade de fazer algumas configurações iniciais.
 *      - A necessidade de aprender a usar o Data Binding.
 */
class Aula12AcessoComDataBindingActivity : AppCompatActivity() {

    // Criamos um atributo para armazenar a referência da classe gerada pelo DataBinding
    //      - A classe gerada pelo DataBinding contém referências para os componentes da tela
    //      - O atributo é privado e lateinit, para ser inicializado posteriormente
    //      - O atributo é do tipo da classe gerada pelo DataBinding, que é gerada a partir do nome
    //        do arquivo XML da tela, substituindo os caracteres especiais por underline e adicionando
    //        a palavra Binding no final
    private lateinit var mBinding: ActivityAula12ComDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla a tela usando o DataBinding. O método DataBindingUtil.setContentView() retorna uma
        // referência para a classe gerada pelo DataBinding, que contém referências para os componentes
        // da tela
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_aula12_com_data_binding)

        // Define o texto do título
        // Com o DataBinding, o acesso aos componentes é feito diretamente através da classe gerada
        mBinding.databindingTxtTitulo.text = getString(R.string.databinding_txt_titulo_com_databinding)
        mBinding.databindingTxtExplicacao.text = getString(R.string.databinding_txt_explicacao_com_databinding)

        // -------------------------
        // Jogo da bomba
        // -------------------------

        // Recupera o array de strings do arquivo de recursos
        //      - O método getStringArray() retorna um array de strings do arquivo de recursos
        val itens = resources.getStringArray(R.array.databinding_btn_itens)

        // Embaralha o array de strings. Cada posição do array representa o botão
        // correspondente na na lista de botões
        itens.shuffle()

        // Cria a lista com todos os botões para facilitar o cadastro  dos
        // eventos de clique
        val botoes = listOf(
            mBinding.databindingBtn01,
            mBinding.databindingBtn02,
            mBinding.databindingBtn03,
            mBinding.databindingBtn04,
            mBinding.databindingBtn05,
            mBinding.databindingBtn06,
            mBinding.databindingBtn07,
            mBinding.databindingBtn08,
            mBinding.databindingBtn09,
            mBinding.databindingBtn10,
            mBinding.databindingBtn11,
            mBinding.databindingBtn12,
        )

        // Para cada botão, cadastra o evento de clique
        // Segue a mesma lógica que o código sem data binding
        for (i in 0 until botoes.size) {
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