package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityAula12ComDataBindingBinding
import br.com.koruthos.cursoandroid.databinding.ActivityTemplateBinding
import br.com.koruthos.cursoandroid.util.TAG

/**
 * TemplateActivity: Activity para ser usada como base para outras.
 *
 * TODO: Alterar o nome da classe e do arquivo para o nome da activity.
 */
class TemplateActivity : AppCompatActivity() {

    // TODO: Alterar o nome da classe gerada pelo DataBinding para o nome da activity.
    private lateinit var mBinding: ActivityTemplateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Alterar o nome do arquivo XML para o nome da activity.
        mBinding = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // TODO: Implementar o código da activity aqui.
    }

}