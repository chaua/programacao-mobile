package br.com.koruthos.cursoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.switchmaterial.SwitchMaterial

class ComponentesActivity : AppCompatActivity() {
    private val TAG = "Componentes"

    // Convenção: nomes de atributos das classes começam com m

    // lateinit: usado para indicar que o atributo será inicializado depois
    //           e não pode ser null
    private lateinit var mProgressBar: ProgressBar

    private lateinit var mImageButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_componentes)

        // 1. Acesso aos componentes do layout
        // - Modo tradicional de acessar um componente do layout
        // - Problemas:
        //      - Precisa criar uma variável para cada componente
        //      - Pode gerar erros na refatoração
        //      - Validação do id no arquivo de layout
        val btnConfirmar = findViewById<Button>(R.id.componentes_btn_confirmar)
        val txtTitulo = findViewById<TextView>(R.id.componentes_txt_titulo)

        val btnCarregar: Button = findViewById(R.id.componentes_btn_carregar)

        val swtNoturno: SwitchMaterial = findViewById(R.id.componentes_swt_noturno)

        val chkPromocao: CheckBox = findViewById(R.id.componentes_chk_promocao)

        mProgressBar = findViewById(R.id.componentes_progress_bar)
        mImageButton = findViewById(R.id.componentes_btn_imagem)

        // Exemplo de webView
        //val webView: WebView
        //webView.loadUrl(mPesquisa.text)

        // 2. Acesso de componentes através de bibliotecas de data binding
        // - Exemplo: dagger

        // 3. DataBinding via Android

        // ====================================
        // Cadastro dos eventos dos componentes

        // 1. Cadastro do evento via lambda
        // - Usado para ações simples - poucas linhas de código
        btnConfirmar.setOnClickListener {
            txtTitulo.text = "Ops! Fui clicado!"
        }

        // 2. Cadastro do evento via método
        // - Usado para ações complexas
        // - Usado para reaproveitar as ações
        btnCarregar.setOnClickListener(::onCarregarClick)

        swtNoturno.setOnCheckedChangeListener { v, b ->
            Log.d(TAG, "onCreate: $b")
            mProgressBar.visibility = View.VISIBLE
            mImageButton.visibility = View.VISIBLE

            chkPromocao.isChecked = b
        }


    }

    private fun onCarregarClick(view: View?) {
        Log.d(TAG, "onCarregarClick: ")
        // visibility: GONE, VISIBLE, INVISIBLE

        // GONE: Esconde o componente e suprime o seu espaço
        mProgressBar.visibility = View.GONE

        // INVISIBLE: Esconde o componente e mantém o espaço
        mImageButton.visibility = View.INVISIBLE
    }


}
