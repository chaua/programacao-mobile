package br.com.koruthos.aula19.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.koruthos.aula15.models.Curso
import br.com.koruthos.aula19.R
import br.com.koruthos.aula19.databinding.ActivityMainBinding
import br.com.koruthos.aula19.widgets.adapters.CursoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setActionBar(binding.toolbar?)

        // Cria uma lista de cursos
        val cursos: MutableList<Curso> = ArrayList()
        cursos.add(Curso(1, "Curso 1", "Descrição do curso 1", "https://via.placeholder.com/300.png/09f/fff"))
        cursos.add(Curso(2, "Curso 2", "Descrição do curso 2", "https://via.placeholder.com/300.png/a9f/fff"))
        cursos.add(Curso(3, "Curso 3", "Descrição do curso 3", "https://via.placeholder.com/300.png/0af/fff"))
        cursos.add(Curso(4, "Curso 4", "Descrição do curso 4", "https://via.placeholder.com/300.png/09a/fff"))
        cursos.add(Curso(5, "Curso 5", "Descrição do curso 5", "https://via.placeholder.com/300.png/aaf/fff"))
        cursos.add(Curso(6, "Curso 6", "Descrição do curso 6", "https://via.placeholder.com/300.png/0aa/fff"))

        // Inicializa o recycler view
        binding.recycler.layoutManager = LinearLayoutManager(this) // exibe como uma lista
        //binding.recycler.layoutManager = GridLayoutManager(this, 2) // exibe uma lista com colunas

        binding.recycler.adapter = CursoAdapter(cursos, object : CursoAdapter.Evento {
            override fun onCompartilharClick(curso: Curso) {
                Toast.makeText(this@MainActivity, "Clicou compartilhar: ${curso.id}", Toast.LENGTH_LONG).show()
            }

            override fun onMapaClick(curso: Curso) {
                Toast.makeText(this@MainActivity, "Clicou mapa: ${curso.id}", Toast.LENGTH_LONG).show()
            }

            override fun onCursoClick(curso: Curso) {
                Toast.makeText(this@MainActivity, "Clicou curso: ${curso.id}", Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_salvar -> {
                Toast.makeText(this, "Salvando...", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_carregar -> {
                Toast.makeText(this, "Carregando...", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_sair -> {
                finish()
                return true
            }
        }
        return false
    }
}
