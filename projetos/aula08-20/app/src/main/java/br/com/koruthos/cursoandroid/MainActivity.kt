package br.com.koruthos.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val TAG = "Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout que será carregado
        setContentView(R.layout.activity_main)

        // Mensagens de Log
        Log.v(TAG, "Verbose!")
        Log.d(TAG, "Debug!")
        Log.i(TAG, "Info!")
        Log.w(TAG, "Warn!")
        Log.e(TAG, "Error!")
        Log.wtf(TAG, "WTF!?")

        Log.d(TAG, "onCreate()")

        // Recupera os componentes da tela
        val btnComponentes: Button = findViewById(R.id.main_btn_componentes)
        val btnFragmentos: Button = findViewById(R.id.main_btn_fragmentos)

        // Cadastro dos eventos
        btnComponentes.setOnClickListener {
            val intent = Intent(this, ComponentesActivity::class.java)
            startActivity(intent)
        }

        btnFragmentos.setOnClickListener {
            val intent = Intent(this, FragmentosActivity::class.java)
            startActivity(intent)
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
