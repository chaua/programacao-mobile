package br.com.koruthos.aula11

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG = "AULA11"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout a ser carregado para a Activity
        // - Nome dos arquivos de layout: activity_<nome>
        setContentView(R.layout.activity_main)

        // Niveis de Log
        Log.v(TAG, "Log do tipo verbose")
        Log.d(TAG, "Log do tipo debug")
        Log.i(TAG, "Log do tipo info")
        Log.w(TAG, "Log do tipo warning")
        Log.e(TAG, "Log do tipo error")
        Log.wtf(TAG, "Log do tipo WTF!")

        Log.d(TAG, "onCreate")


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }


}
