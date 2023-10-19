package br.com.koruthos.cursoandroid

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.CompoundButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.databinding.ActivityDatabindingBinding

class DataBindingActivity : AppCompatActivity() {

    // Para habilitar o databing, é necessário configurar:
    //
    // 1. Habilitar o databinding no build.gradle do módulo - app
    // 2. Alterar o arquivo de layout incluindo as tags <layout> e <data>
    // 3. Carregar o contentView a partir do DataBinding

    // Referência para o DataBinding desta Activity
    private lateinit var mBinding: ActivityDatabindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Chamada para a classe de DataBinding - Define o layout da tela
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)


        // Recupera os valores passados por bundle
        if (arguments != null) {
            val nome = arguments.getString(EXTRA_NOME, "")
            Toast.makeText(this, "Olá $nome", Toast.LENGTH_SHORT).show()
        }


        // Passa os valores para o layout
        mBinding.mensagemInicial = "Olá, essa é a mensagem inicial!"

        // Cadastra o evento no botão
        mBinding.databindingButton.setOnClickListener {
            mBinding.databindingTxtMensagem.text = getString(R.string.databinding_txt_mensagem_botao)
        }

        // Cadastra o evento no checkbox
        mBinding.databindingCheckbox.setOnCheckedChangeListener { btn, checked ->
            Log.d(TAG, "setOnCheckedChangeListener: ${mBinding.databindingCheckbox.isChecked}")
            if (checked) {
                mBinding.databindingTxtMensagem.text = "Checkbox marcada"
            } else {
                mBinding.databindingTxtMensagem.text = "Checkbox desmarcada"
            }
        }
        mBinding.databindingCheckbox.isChecked = true

        // Cadastra o evento do radio button
        mBinding.databindingRadio1.setOnCheckedChangeListener { btn, checked ->
            Log.d(TAG, " Radio1 - setOnCheckedChangeListener: ")
            if (checked) {
                mBinding.databindingTxtMensagem.setTextColor(ContextCompat.getColor(this, R.color.green_600))
            }
        }
        mBinding.databindingRadio2.setOnCheckedChangeListener { btn, checked ->
            Log.d(TAG, " Radio2 - setOnCheckedChangeListener: ")
            if (checked) {
                mBinding.databindingTxtMensagem.setTextColor(ContextCompat.getColor(this, R.color.blue_600))
            }
        }
        mBinding.databindingRadio3.setOnCheckedChangeListener { btn, checked ->
            Log.d(TAG, " Radio3 - setOnCheckedChangeListener: ")
            if (checked) {
                mBinding.databindingTxtMensagem.setTextColor(ContextCompat.getColor(this, R.color.red_600))
            }
        }

        // Cadastra o evento do switch
        mBinding.databindingSwitch.setOnCheckedChangeListener { btn, checked ->
            Log.d(TAG, "switch - setOnCheckedChangeListener: ")
            if (checked) {
                mBinding.databindingTxtMensagem.visibility = View.VISIBLE
            } else {
                mBinding.databindingTxtMensagem.visibility = View.INVISIBLE
            }
        }

        // Teste de eventos com edittext
        mBinding.databindingEdittext.setOnEditorActionListener { v, actionId, event ->
            val retorno = if (actionId == EditorInfo.IME_ACTION_SEND) {
                Toast.makeText(this, "Enviando!", Toast.LENGTH_SHORT).show()
                true
            } else {
                false
            }

            retorno
        }

        mBinding.databindingBtnConfirmar.setOnClickListener {
            // Se a caixa de texto estiver vazia, exibe a mensagem de erro
            if (mBinding.databindingEdittext.text.toString().isEmpty()) {
                mBinding.databindingEdittext.error = "Campo vazio"
                mBinding.databindingEdittext.requestFocus()
            }
        }


    }




    // companion object: declaração de variáveis e métodos de classe
    companion object {
        const val EXTRA_NOME = "NOME"
        const val EXTRA_IDADE = "IDADE"
    }


}