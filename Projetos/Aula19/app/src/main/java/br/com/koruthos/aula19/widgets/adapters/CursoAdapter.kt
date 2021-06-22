package br.com.koruthos.aula19.widgets.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.koruthos.aula15.models.Curso
import br.com.koruthos.aula15.util.GlideApp
import br.com.koruthos.aula19.R
import br.com.koruthos.aula19.databinding.ItemCursoBinding

class CursoAdapter(var cursos: List<Curso>, var evento: CursoAdapter.Evento) : RecyclerView.Adapter<CursoAdapter.ViewHolder>(){

    // - onCreateViewHolder: inicializa o layout - infla o layout
    // - getItemCount: retorna o numero de itens
    // - onBindViewHolder: preenche o view holder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCursoBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curso = cursos[position]

        // Inicializacao dos elementos do layout
        holder.binding.txtTitulo.text = curso.titulo
        holder.binding.txtDescricao.text = curso.descricao

        // Amarracao dos eventos
        holder.binding.btnCompartilhar.setOnClickListener { evento.onCompartilharClick(curso) }
        holder.binding.btnMapa.setOnClickListener { evento.onMapaClick(curso) }
        holder.binding.cursoLayout.setOnClickListener{ evento.onCursoClick(curso) }

        // Carregar imagem com o glide
        GlideApp.with(holder.binding.root)
            .load(curso.fotoUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .circleCrop()
            .into(holder.binding.imageView)
    }

    override fun getItemCount(): Int {
        return cursos.size
    }

    // Interface com os eventos que o item dispara
    interface Evento {
        fun onCompartilharClick(curso: Curso)
        fun onMapaClick(curso: Curso)
        fun onCursoClick(curso: Curso)
    }

    // Classe de ViewHolder que armazena os itens do layout do item do recycler
    data class ViewHolder(var binding: ItemCursoBinding) : RecyclerView.ViewHolder(binding.root)

}
