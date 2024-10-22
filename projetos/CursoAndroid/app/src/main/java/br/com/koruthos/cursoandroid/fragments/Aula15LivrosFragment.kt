package br.com.koruthos.cursoandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.databinding.FragmentAula15LivrosBinding

/**
 * Aula 15 - Fragmentos
 *
 * Um fragmento é um componente de interface de usuário reutilizável que representa uma
 * parte de uma interface de usuário. Um fragmento define e gerencia seu próprio layout,
 * tem seu próprio ciclo de vida e pode receber eventos de entrada.
 *
 * Os fragmentos são usados para criar interfaces de usuário modulares e reutilizáveis,
 * que podem ser combinadas para formar uma tela maior. Eles são usados para dividir
 * a interface de usuário em partes menores, que podem ser gerenciadas separadamente.
 *
 * Para criar um fragmento, é necessário criar uma classe que estenda a classe Fragment.
 * Ela contém métodos que são chamados em diferentes momentos do ciclo de vida do fragmento.
 * Para exibir um fragmento, é necessário adicioná-lo a uma atividade, usando um gerenciador
 * de fragmentos, como o FragmentManager.
 *
 */
class Aula15LivrosFragment : Fragment() {

    private lateinit var mBinding: FragmentAula15LivrosBinding

    /**
     * onCreateView(LayoutInflater, ViewGroup, Bundle?): Chamado para criar a hierarquia de
     * visualização associada ao fragmento. O fragmento deve retornar uma View do método,
     * que é a raiz da hierarquia de visualização do fragmento.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentAula15LivrosBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    /**
     * onViewCreated(View, Bundle?): Chamado após a View retornada pelo onCreateView() ser criada.
     * É um bom lugar para inicializar a interface do usuário, como configurar eventos de clique
     * e preencher a interface com dados.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Define o texto do título
        mBinding.aula15TxtDisplay.text = activity?.getText(R.string.aula15_txt_livros)
    }


    /**
     * Companion object para instanciar o fragmento.
     *      - companion object: É um objeto que é criado apenas uma vez e compartilhado por todas as
     *                          instâncias da classe. Ele é usado para criar métodos e propriedades
     *                          estáticas, que podem ser acessadas diretamente pela classe, sem a
     *                          necessidade de instanciá-la.
     * O método newInstance() é um método estático que cria e retorna uma nova instância do fragmento.
     * Usamos este método para criar uma nova instância do fragmento, em vez de usar o construtor
     * padrão, para garantir que a instância seja criada corretamente. Principalmente quando o fragmento
     * precisa de argumentos, é recomendado usar este método para criar a instância.
     */
    companion object {
        fun newInstance() = Aula15LivrosFragment()
    }
}
