package br.com.koruthos.cursoandroid.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.constantes.TAG
import br.com.koruthos.cursoandroid.databinding.ActivityComponentesBinding
import android.util.Log

class ComponentesActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityComponentesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_componentes)

        // Acessar componentes de tela:
        // 1. Tradicional: findViewById(id)
        //    val btnOla = findViewById<Button>(R.id.componentes_btn_ola)
        //    val btnClique = findViewById<Button>(R.id.componentes_btn_clique)

        // 2. DataBinding
        //  Existem bibliotecas que fazem o trabalho de declaração automática dos componentes
        //  Vantagem: Economiza digitação de código -> minimiza erros
        //      - Dagger2 - terceiros
        //      - DataBinding - incluida no android

        // Configuração do DataBinding
        //      1. Habilitar o databinding no gradle
        //      2. Modificar os arquivos de layout
        //      3. Substituir a chamada do setContentView()

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_componentes)

        // Tratamento de eventos
        // =====================
        // Existem diferentes formas de cadastrar um evento em um componente
        // Os eventos são dispatados pelos componentes após a interação do usuário
        // As função para cadastro de evendto começam com <on> e terminam com <Listener>

        // 1. Via função lambda
        //   - usado quando o evento não precisa ser reaproveitado
        //   - são poucas linhas de código
        mBinding.componentesBtnOla.setOnClickListener {
            Toast.makeText(this, getText(R.string.componentes_btn_ola), Toast.LENGTH_SHORT).show()
        }

        // 2. Via método
        //   - usado quando o evento precisa ser reaproveitado. Exemplo: salvar
        //   - podem ser funções complexas
        mBinding.componentesBtnClique.setOnClickListener(::onOlaClickListener)


        mBinding.componentesEdtMensagem.setOnEditorActionListener { textView, i, keyEvent ->
            Toast.makeText(this, i.toString(), Toast.LENGTH_SHORT).show()
            true
        }

        mBinding.componentesBtnOk.setOnClickListener {
            val mensagem = mBinding.componentesEdtMensagem.text.toString().uppercase()
            mBinding.componentesEdtMensagem.setText(mensagem)
        }


    }

    fun onOlaClickListener(v: View) {
        Log.d(TAG, "onOlaClickListener")
        Toast.makeText(this, getText(R.string.componentes_btn_clique), Toast.LENGTH_SHORT).show()

    }


}
