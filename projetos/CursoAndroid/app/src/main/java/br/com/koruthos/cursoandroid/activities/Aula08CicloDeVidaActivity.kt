package br.com.koruthos.cursoandroid.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.koruthos.cursoandroid.R
import br.com.koruthos.cursoandroid.util.TAG

class Aula08CicloDeVidaActivity : AppCompatActivity() {

    /**
     * onCreate(Bundle?): Chamado quando a Activity é criada pela primeira vez. É onde você
     * deve fazer a inicialização básica, como configurar o layout da interface do usuário e
     * inicializar variáveis.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --------------------------------------------------------------------
        // setContentView
        // --------------------------------------------------------------------

        // setContentView: usado para definir o layout da interface. Quando você chama setContentView
        // e passa um ID de recurso de layout, o método infla (carrega) o arquivo XML do layout e o
        // define como a visualização de conteúdo para a atividade. Isso significa que os elementos
        // da interface definidos no arquivo XML serão exibidos na tela quando a atividade for criada.
        setContentView(R.layout.activity_aula08_ciclo_de_vida)

        // --------------------------------------------------------------------
        // Classe R
        // --------------------------------------------------------------------

        // A classe R no Android é uma classe especial gerada automaticamente que serve como um índice
        // para todos os recursos do projeto, como layouts, strings e imagens. Ela permite que você
        // acesse esses recursos no seu código de forma fácil, usando identificadores únicos.
        // Por exemplo, R.layout.activity_main refere-se ao layout definido no arquivo activity_main.xml.

        // --------------------------------------------------------------------
        // Classe Log
        // --------------------------------------------------------------------

        // A classe Log no Android serve para exibir mensagens no console durante a execução do app.
        // Ela é usada para depuração (debug), ajudando a ver o que está acontecendo no código, como
        // valores de variáveis ou possíveis erros.
        // "TAG" é uma string usada para identificar de onde a mensagem está vindo no código, ajudando
        // a organizar e filtrar as mensagens no log. Isso facilita encontrar informações específicas
        // durante a depuração.

        // Log.v() (Verbose):
        // Para mensagens muito detalhadas, geralmente usadas para informações menos importantes.
        Log.v(TAG, "Log Verboso")

        // Log.d() (Debug):
        // Usado para mensagens de depuração, informações úteis durante o desenvolvimento.
        Log.d(TAG, "Log Debug")

        // Log.i() (Info):
        // Para mensagens informativas, que não são erros nem problemas, mas coisas importantes a notar.
        Log.i(TAG, "Log Info")

        // Log.w() (Warn):
        // Mensagens de aviso, para situações que podem ser problemáticas, mas não são erros.
        Log.w(TAG, "Log Warning")

        // Log.e() (Error):
        // Usado para erros, quando algo deu errado no código.
        Log.e(TAG, "Log Error")

        // Log.wtf() (What a Terrible Failure):
        // Para situações críticas que nunca deveriam ocorrer.
        Log.wtf(TAG, "Log WTF?") // erro muito bizarro

        Log.d(TAG, "--- Ciclo de Vida ---")
        Log.d(TAG, "onCreate: ")
    }

    /**
     * onStart(): Chamado quando a Activity está prestes a se tornar visível para o usuário.
     * Neste ponto, a Activity está visível, mas ainda não está interativa.
     */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    /**
     * onResume(): Chamado quando a Activity começa a interagir com o usuário.
     * Neste ponto, a Activity está no topo da pilha de atividades e o usuário pode interagir com ela.
     */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    /**
     * onPause(): Chamado quando a Activity está prestes a perder o foco.
     * Este método é usado para pausar operações que não devem continuar enquanto a Activity não
     * está em primeiro plano, como animações ou reprodução de vídeo.
     */
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    /**
     * onStop(): Chamado quando a Activity não está mais visível para o usuário.
     * Isso pode acontecer porque outra Activity foi iniciada e esta foi colocada em segundo plano,
     */
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    /**
     * onRestart(): Chamado quando a Activity foi interrompida e está prestes a ser reiniciada.
     * Este método é usado para realizar qualquer configuração necessária antes que a Activity se
     * torne visível novamente.
     */
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

    /**
     * onDestroy(): Chamado antes da Activity ser destruída.
     * Este é o último método que a Activity recebe antes de ser completamente removida da memória.
     * É onde você deve liberar todos os recursos que a Activity estava usando.
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }


}