package br.com.koruthos.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
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

        // Habilita o botão de voltar
        val actionBar = getActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)

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

            // Envia um texto par

        }

        // 2. Cadastro do evento via método
        // - Usado para ações complexas
        // - Usado para reaproveitar as ações
        btnCarregar.setOnClickListener(::onCarregarClick)

        swtNoturno.setOnCheckedChangeListener { view, checked ->
            Log.d(TAG, "onCreate: $checked")
            mProgressBar.visibility = View.VISIBLE
            mImageButton.visibility = View.VISIBLE

            chkPromocao.isChecked = checked
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

    // Para definir o menu da action bar, é necessário sobrescrever
    // dois métodos
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_componentes, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_salvar -> {
                Toast.makeText(this, "Salvando os dados!", Toast.LENGTH_LONG).show()

                // Chama uma intenção para enviar uma mensagem para outra atividade
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "Hello, Kotlin!")
                }
                startActivity(Intent.createChooser(intent, "Please choose your preferred application:"))
            }
            R.id.action_recortar -> {
                Toast.makeText(this, "Recortando coisas!", Toast.LENGTH_LONG).show()
            }
        }

        return true
    }



}
