package br.com.koruthos.cursoandroid.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Variável para acessar o databinding
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da tela - modo tradicional
        // Classe R é uma classe que referencia todos os recursos (/res)
        // setContentView(R.layout.activity_main)

        // Define o layout da tela - modo databinding
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Cadastra os eventos dos botões
        mBinding.mainBtnTradutor.setOnClickListener {
            // Para abrir outra atividade:
            // 1. Criar uma intenção
            // 2. Inicia a intenção
            val intent = Intent(this, TradutorActivity::class.java)
            startActivity(intent)
        }

        mBinding.mainBtnConstraint.setOnClickListener {
            val intent = Intent(this, ConstraintActivity::class.java)
            startActivity(intent)
        }

        mBinding.mainBtnComponentes.setOnClickListener {
            val intent = Intent(this, ComponentesActivity::class.java)
            startActivity(intent)
        }

        // Exemplo de passagem de parâmetros para a Atividade
        mBinding.mainBtnDatabinding.setOnClickListener {
            val intent = Intent(this, DataBindingActivity::class.java)
            intent.putExtra(DataBindingActivity.EXTRA_NOME, "Homer Simpsons")
            intent.putExtra(DataBindingActivity.EXTRA_IDADE, 40)
            startActivity(intent)
        }

        mBinding.mainBtnRecyclerview.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }

        mBinding.mainBtnFragmento.setOnClickListener {
            val intent = Intent(this, FragmentoActivity::class.java)
            startActivity(intent)
        }

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