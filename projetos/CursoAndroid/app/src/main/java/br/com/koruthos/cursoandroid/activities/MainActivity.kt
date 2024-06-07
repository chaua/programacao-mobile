package br.com.koruthos.cursoandroid.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.mainBtnFragmento.setOnClickListener {
            val intent = Intent(this, FragmentoActivity::class.java)
            startActivity(intent)
            // código abaixo ainda é executado
        }

        mBinding.mainBtnRecycler.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
            // código abaixo ainda é executado
        }

    }


}