package br.com.koruthos.cursoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.databinding.ActivityEventoBinding
import java.sql.SQLException

class EventoActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = ""

    // lateinit: comando que avisa o compilador que a variavel será inicializada
    //           posteriomente
    private lateinit var mBinding: ActivityEventoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Modo tradicional
        // setContentView(R.layout.activity_evento)

        // c. Alteramos a activity para ysar o databinding
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_evento)

        // ---------------------------------------
        // Acessar componente via codigo
        // ---------------------------------------

        // 1. Tradicional (desuso)
        val btnToUpperCase = findViewById<Button>(R.id.evento_btn_touppercase)

        // 2. Bibliotecas de apoio - remover o boilerplate
        // Dagger e outras

        // 3. DataBinding (Amarração do layout com código)
        //    Ritual de configuração do DataBinding
        //          a. Habilitar databinding no build.gradle do app
        //          b. Incluir a tag <layout> no arquivo de layout
        //          c. Alterar a activity para carregar o databinding

        // Para acessar um componente usamos o objeto de binding
        mBinding.eventoBtnTouppercase.text = "Novo nome"


        // ---------------------------------------
        // Cadastro de evento
        // ---------------------------------------

        // 1. Cadastro de metodo da classe
        btnToUpperCase.setOnClickListener(this)

        // 2. Via lambda

        // Usamos essa estrategia para eventos que sao comuns a mais de um componente
        // Exemplo: Operacao de salvar pode ser feita por um botao ou menu
        mBinding.eventoBtnTouppercase.setOnClickListener(::onUpperCaseClick)

        // Usamos para eventos unicos
        mBinding.eventoBtnTouppercase.setOnClickListener { v: View ->
            // Corpo da funcao - funcoes curtas e unicas
            mBinding.eventoTxtDisplay.text = mBinding.eventoEdtMensagem.text.toString().uppercase()
        }

        // Se a lambda tiver somente um parametro, ele pode ser omitido
        // O nome da variavel do parametro se chama it
        mBinding.eventoBtnTouppercase.setOnClickListener {
            mBinding.eventoTxtDisplay.text = mBinding.eventoEdtMensagem.text.toString().uppercase()
        }

        // 3. Via classe anônima
        // Usado somente qndo o evento/listener tiver mais de dois metodos para serem sobrescritos
        mBinding.eventoBtnTouppercase.setOnClickListener(object : View.OnClickListener  {
            override fun onClick(p0: View?) {
                mBinding.eventoTxtDisplay.text = mBinding.eventoEdtMensagem.text.toString().uppercase()
            }
        })






        // Exemplo de componentes

        // Sobrescreve a ação do enter do teclado
        mBinding.eventoEdtEmail.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                // Sobrescreve a acao do botao

                // Como a ação executou
                true
            }
            else {
                false
            }
        }

        // Exibe a operação de erro no edit text
        mBinding.eventoBtnError.setOnClickListener {
            mBinding.eventoEdtEmail.setError("Erro!")
        }










    }

    override fun onClick(view: View?) {
        val txtDisplay = findViewById<TextView>(R.id.evento_txt_display)
        val edtMensagem = findViewById<TextView>(R.id.evento_edt_mensagem)

        txtDisplay.text = edtMensagem.text.toString().uppercase()
    }

    fun onUpperCaseClick(view: View?) {
        val txtDisplay = findViewById<TextView>(R.id.evento_txt_display)
        val edtMensagem = findViewById<TextView>(R.id.evento_edt_mensagem)

        txtDisplay.text = edtMensagem.text.toString().uppercase()
    }




}