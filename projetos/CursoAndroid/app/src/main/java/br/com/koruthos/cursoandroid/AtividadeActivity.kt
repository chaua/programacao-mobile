package br.com.koruthos.cursoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class AtividadeActivity : AppCompatActivity() {

    private val TAG = "Main"

    /**
     * onCreate: Responsável pela construção da activity
     *
     * - Define o layout das telas
     * - Amarração de evento
     * - Recuperação de estado anterior da tela
     * - Chamada para webservices (?)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define qual o layout a ser carregado nesta activity
        setContentView(R.layout.activity_main3)

        // A classe R possui diversos ponteiros para os arquivos
        // que estão no diretório de recursos (/res)
        // - Todos os arquivos de recursos devem seguir o padrão de nomenclatura
        //   de variáveis (snake_case: tudo minusculo separado por _)


        // Log no Android
        // - Classe Log permite a impressão de logs
        // - v: verboso
        // - d: debug
        // - i: informação
        // - w: warning (alerta)
        // - e: erro (fatal)
        // - wtf: não sei o que houve!
        Log.d(TAG, "onCreate: ")

        Log.v(TAG, "VERBOSO")
        Log.d(TAG, "DEBUG")
        Log.i(TAG, "INFO")
        Log.w(TAG, "WARNING")
        Log.e(TAG, "ERROR")
        Log.wtf(TAG, "WTF")

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()

    }
    
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()


    }


}