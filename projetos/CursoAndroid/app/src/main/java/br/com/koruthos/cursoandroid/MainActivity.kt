package br.com.koruthos.cursoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.sql.SQLException

class MainActivity : AppCompatActivity() {

    private val TAG = ""
    
    // onCreate: Chamado na criação da Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")

        // setContentView: Define qual é o layout a ser carregado
        setContentView(R.layout.activity_main)
        
        // Log da aplicação
        Log.v(TAG, "Log Verboso") // imprime passo a passo
        Log.d(TAG, "Log Debug") // chamada de funções, variáveis
        Log.i(TAG, "Log Info") // eventos, conexão com sucesso
        Log.w(TAG, "Log Warning") // evento que deveria acontecer, mas é erro
        Log.e(TAG, "Log Error") // quando ocorre erros, catch, 
        Log.wtf(TAG, "Log WTF?") // erro muito bizarro
        
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
    

}