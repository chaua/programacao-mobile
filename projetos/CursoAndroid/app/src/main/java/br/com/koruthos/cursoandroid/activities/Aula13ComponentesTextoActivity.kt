package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula13ComponentesTextoBinding
import br.com.koruthos.cursoandroid.util.TAG
import com.google.android.material.snackbar.Snackbar


class Aula13ComponentesTextoActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAula13ComponentesTextoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_aula13_componentes_texto)

        // Cadastra os eventos dos botões usando métodos da classe
        mBinding.aula13BtnEventoTextoNormal.setOnClickListener(::onBotaoEventoClick)
        mBinding.aula13BtnEventoNumeros.setOnClickListener(::onBotaoEventoClick)
        mBinding.aula13BtnEventoEmail.setOnClickListener(::onBotaoEventoClick)
        mBinding.aula13BtnEventoSenha.setOnClickListener(::onBotaoEventoClick)
        mBinding.aula13BtnEventoSenhaOlho.setOnClickListener(::onBotaoEventoClick)
        mBinding.aula13BtnEventoSend.setOnClickListener(::onBotaoEventoClick)
        mBinding.aula13BtnEventoSearch.setOnClickListener(::onBotaoEventoClick)

        // Cadastra o evendo do botao "enter" do teclado
        mBinding.aula13BtnEventoSend.setOnEditorActionListener { v, actionId, event ->
            onBotaoEventoClick(v)
            true
        }

        mBinding.aula13BtnEventoSearch.setOnEditorActionListener { v, actionId, event ->
            onBotaoEventoClick(v)
            true
        }


        // Cadastra os eventos dos botões usando lambda
        mBinding.aula13BtnEventoErroIcon.setOnClickListener {
            mBinding.aula13EdtEventoErroIcon.error = getText(R.string.aula13_txt_error)
        }

        // Captura o evento de mudança de texto
        mBinding.aula13EdtEventoTextview.addTextChangedListener {
            mBinding.aula13TxtExibirTextview.text = mBinding.aula13EdtEventoTextview.text.toString().uppercase()
        }

    }

    /**
     * Evento genérico para eventos do botão
     *
     * @param v View que chamou o evento
     */
    private fun onBotaoEventoClick(v: View) {
        Log.d(TAG, "onBotaoEventoClick: ")

        // Pega a mensagem digitada no campo de texto
        val mensagem = when (v.id) {
            R.id.aula13_btn_evento_texto_normal -> mBinding.aula13EdtEventoTextoNormal.text.toString()
            R.id.aula13_btn_evento_numeros -> mBinding.aula13EdtEventoNumeros.text.toString()
            R.id.aula13_btn_evento_email -> mBinding.aula13EdtEventoEmail.text.toString()
            R.id.aula13_btn_evento_senha -> mBinding.aula13EdtEventoSenha.text.toString()
            R.id.aula13_btn_evento_senha_olho -> mBinding.aula13EdtEventoSenhaOlho.text.toString()
            R.id.aula13_btn_evento_send -> mBinding.aula13EdtEventoSend.text.toString()
            R.id.aula13_btn_evento_search -> mBinding.aula13EdtEventoSearch.text.toString()
            else -> ""
        }

        // Esconde o teclado a partir da View que está focada
        if (getSystemService(INPUT_METHOD_SERVICE) is InputMethodManager) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
        }

        // Exibe a mensagem em uma Snackbar
        // Para a Snackbar, é necessário passar a view raiz da tela. Usamos como raiz o container
        // definido no layout com CoordinatorLayout. Isso permite que a Snackbar seja exibida
        // corretamente, mesmo que o teclado virtual esteja aberto
        Snackbar.make(mBinding.container, mensagem, Snackbar.LENGTH_SHORT).show()

    }


}