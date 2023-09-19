package br.com.koruthos.cursoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da tela
        // Classe R é uma classe que referencia todos os recursos (/res)
        setContentView(R.layout.activity_main)

        // Alt + Enter: Contexto para importacao e erros
        // Ctrl + P: Mostra todos os parametros do metodo

        // Classe Log: Imprime todos os logs
        Log.v("TAG", "Verbose")
        Log.d("TAG", "Debug")
        Log.i("TAG", "Info")
        Log.w("TAG", "Warning")
        Log.e("TAG", "Error")
        Log.wtf("TAG", "Wtf?")
    }

    override fun onStart() {
        super.onStart()
        Log.d(" TAG", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(" TAG", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(" TAG", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(" TAG", "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(" TAG", "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(" TAG", "onDestroy()")
    }


}