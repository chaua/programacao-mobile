package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula14ComponentesBotaoBinding


class Aula14ComponentesBotaoActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAula14ComponentesBotaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_aula14_componentes_botao)
    }


}