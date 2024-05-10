package br.com.koruthos.cursoandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.databinding.ActivityComponenteBinding
import br.com.koruthos.cursoandroid.databinding.ActivityDataBindingBinding

class ComponenteActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityComponenteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_componente)


    }
}