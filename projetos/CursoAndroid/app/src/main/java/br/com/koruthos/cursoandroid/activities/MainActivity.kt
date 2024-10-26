package br.com.koruthos.cursoandroid.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.koruthos.cursoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.mainBtnCicloDeVida.setOnClickListener {
            startActivity(Intent(this, Aula08CicloDeVidaActivity::class.java))
        }

        mBinding.mainBtnLinearLayout.setOnClickListener {
            startActivity(Intent(this, Aula09LinearLayoutActivity::class.java))
        }

        mBinding.mainBtnConstraintLayout.setOnClickListener {
            startActivity(Intent(this, Aula10ConstraintLayoutActivity::class.java))
        }

        mBinding.mainBtnAcessoComDataBinding.setOnClickListener {
            startActivity(Intent(this, Aula12AcessoComDataBindingActivity::class.java))
        }

        mBinding.mainBtnAcessoSemDataBinding.setOnClickListener {
            startActivity(Intent(this, Aula12AcessoSemDataBindingActivity::class.java))
        }

        mBinding.mainBtnComponentesTexto.setOnClickListener {
            startActivity(Intent(this, Aula13ComponentesTextoActivity::class.java))
        }

        mBinding.mainBtnComponentesBotao.setOnClickListener {
            startActivity(Intent(this, Aula14ComponentesBotaoActivity::class.java))
        }

        mBinding.mainBtnFragmentosBottomNav.setOnClickListener {
            startActivity(Intent(this, Aula15FragmentosBottomNavActivity::class.java))
        }

        mBinding.mainBtnFragmentosTabLayout.setOnClickListener {
            startActivity(Intent(this, Aula15FragmentosTabLayoutActivity::class.java))
        }

        mBinding.mainBtnFragmentosViewPager.setOnClickListener {
            startActivity(Intent(this, Aula15FragmentosViewPagerActivity::class.java))
        }

        mBinding.mainBtnRecyclerView.setOnClickListener {
            startActivity(Intent(this, Aula16RecyclerViewActivity::class.java))
        }

        mBinding.mainBtnTradutor.setOnClickListener {
            // Cria uma intenção para ir para outra activity
            val intent = Intent(this,  Aula16TradutorActivity::class.java)
            startActivity(intent)
        }


    }


}