package br.com.koruthos.aula15

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.koruthos.aula15.databinding.ActivityMainBinding

import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    val TAG = "Aula15"
    var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        // Utilizando data binding
        // - Classe de layout tem o seguinte nome:
        //     - mesmo nome do arquivo xml em CamelCase: activity_main => ActivityMain
        //     - adicionado sufixo -Binding: ActivityMainBinding
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding?.root) // ? evita erro de NullPointerException

        mBinding?.btnCalcular?.setOnClickListener { onCalcularClick() }
    }

    fun onCalcularClick() {
        Log.d(TAG, "onCalcularClick()")
        val peso = mBinding?.edtPeso?.text.toString().toDouble()
        val altura = mBinding?.edtAltura?.text.toString().toDouble()

        val imc = peso / (altura * altura)

        mBinding?.txtResposta?.text = "Seu IMC é $imc"
        mBinding?.txtResposta?.visibility = View.VISIBLE

        onCompartilharClick(imc)
    }

    fun onCompartilharClick(imc: Double) {

        val alerta = AlertDialog.Builder(this) // padrão de projetos para construção de objetos
            .setTitle(R.string.main_alert_titulo)
            .setMessage(R.string.main_alert_mensagem)
            .setPositiveButton("Sim") { _,_ ->
                val it = Intent(Intent.ACTION_SEND)
                it.putExtra(Intent.EXTRA_TEXT, "O meu IMC é $imc")
                it.type = "text/plain"
                it.`package` = "web.whatsapp"
                startActivity(it)
            }
            //.setNegativeButton()
            //.setNeutralButton()
            .create()

        alerta.show()   // Exibe o alerta

    }

    fun onDateClick() {

        // val picker = DatePickerDialog

    }



}
