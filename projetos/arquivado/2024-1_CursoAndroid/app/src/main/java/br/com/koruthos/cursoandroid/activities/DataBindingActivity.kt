package br.com.koruthos.cursoandroid.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Para acessar um componente de tela existem
        // várias maneiras
        // - Modo tradicional
        // - Modo usando bibliotecas de terceiros
        // - Módulo de data binding

        // 1. Modo tradicional
        // Informa qual será o layout para ser carregado na Activity
        // setContentView(R.layout.activity_data_binding)

//        val painel: TextView = findViewById(R.id.databinding_txt_painel)
//        val botao1: Button = findViewById(R.id.databinding_btn_lambda)
//        val botao2: Button = findViewById(R.id.databinding_btn_classe)
//        val botao3: Button = findViewById(R.id.databinding_btn_metodo)

        // Acessando os métodos dos objetos
//        painel.text = getString(R.string.app_name)
//        painel.text = "${painel.text}\n ----\n\n"

        // 2. Usando data binding
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        // Acessando os métodos dos objetos
        mBinding.databindingTxtPainel.text = getString(R.string.app_name)
        mBinding.databindingTxtPainel.text = "${mBinding.databindingTxtPainel.text}\n ----\n\n"

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
        mBinding.databindingBtnLambda.setOnClickListener {
            Toast.makeText(this, "Lambda", Toast.LENGTH_SHORT).show()
            mBinding.databindingTxtPainel.text = "Executou lambda"
        }

        // 2. Cadastrando a própria classe para tratar o evento
        //  - Classe precisa implementar a interface do listener
        mBinding.databindingBtnClasse.setOnClickListener(this)

        // 3. Cadastrando um método da classe
        // - Passar o endereço do método que será executado - mesma assinatura da interface
        // - Somente se o listener tiver um método
        mBinding.databindingBtnMetodo.setOnClickListener(::onClickMetodo)

    }

    override fun onClick(v: View?) {
        Toast.makeText(this, "Listener da Classe", Toast.LENGTH_SHORT).show()
        mBinding.databindingTxtPainel.text = "Executou Classe"
    }

    private fun onClickMetodo(v: View?) {
        Toast.makeText(this, "Listener do Método", Toast.LENGTH_SHORT).show()
        mBinding.databindingTxtPainel.text = "Executou Metodo"
    }


}