package br.com.koruthos.cursoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.databinding.ActivityDataBindingBinding
import br.com.koruthos.cursoandroid.databinding.ActivityMainBinding
import br.com.koruthos.cursoandroid.util.TAG

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.mainBtnFragmento.setOnClickListener {
            val intent = Intent(this, FragmentoActivity::class.java)
            startActivity(intent)
        }

    }


}