package br.com.koruthos.cursoandroid.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityComponenteBinding

class ComponenteActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityComponenteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_componente)

        // TextView: Eventos
        mBinding.componenteTxtMensagem.setOnClickListener {
            Toast.makeText(this, "Clicou TextView!", Toast.LENGTH_SHORT).show()
            mBinding.componenteTxtMensagem.setTextColor(ContextCompat.getColor(this, R.color.green_800))
        }

        // InputEditText: Evento do teclado
        mBinding.componenteEdtSenha.setOnEditorActionListener { v, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (mBinding.componenteEdtSenha.text.toString() == "123") {
                    Toast.makeText(this, "Acertou", Toast.LENGTH_SHORT).show()
                } else {
                    mBinding.componenteEdtSenha.error = "Senha inválida!"
                }
                true
            }
            false
        }


    }
}