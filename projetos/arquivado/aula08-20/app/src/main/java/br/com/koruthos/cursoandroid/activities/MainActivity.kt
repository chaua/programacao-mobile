package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.constantes.TAG
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v(TAG, "Log: verbose")
        Log.d(TAG, "Log: debug")
        Log.i(TAG, "Log: info")
        Log.w(TAG, "Log: warning")
        Log.e(TAG, "Log: error")
        Log.wtf(TAG, "Log: wtf?")

        Log.d(TAG, "onCreate()")

        // Acessa os componentes de tela
        val btnTraduzir = findViewById<Button>(R.id.main_btn_traduzir)
        val txtTraducao = findViewById<TextView>(R.id.main_txt_traducao)
        val edtMensagem = findViewById<TextInputEditText>(R.id.main_edt_mensagem)

        txtTraducao.visibility = View.GONE

        btnTraduzir.setOnClickListener {
            Log.d(TAG, "Clicou no botão!")
            Toast.makeText(this, "Traduzindo!", Toast.LENGTH_LONG).show()

            var traducao = edtMensagem.text.toString()
            traducao = traducao.replace("o", "ue")
            // TODO: incluir outras regras

            txtTraducao.text = traducao
            txtTraducao.visibility = View.VISIBLE
        }



    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }
}
