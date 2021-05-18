package br.com.koruthos.aula11

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val APP = "AULA11"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout a ser carregado para a Activity
        // - Nome dos arquivos de layout: activity_<nome>
        setContentView(R.layout.activity_main)

        // Niveis de Log
        Log.v(APP, "Log do tipo verbose")
        Log.d(APP, "Log do tipo debug")
        Log.i(APP, "Log do tipo info")
        Log.w(APP, "Log do tipo warning")
        Log.e(APP, "Log do tipo error")
        Log.wtf(APP, "Log do tipo WTF!")

        Log.d(APP, "onCreate")


    }

    override fun onStart() {
        super.onStart()
        Log.d(APP, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(APP, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(APP, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(APP, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(APP, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(APP, "onRestart")
    }


}
