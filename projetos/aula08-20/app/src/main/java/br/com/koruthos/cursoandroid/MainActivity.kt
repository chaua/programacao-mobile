package br.com.koruthos.cursoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

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
