
class Pessoa(nome: String = "", idade: Int = 0) {

    // atributos
    var nome = nome
        get() = field
        set(value) {
            field = value.uppercase()
        }

    var idade = idade
        get() = field
        set(value) {
            field = if (value >= 0) value else 0
        }

    // construtor secundário
    //    constructor(idade: Double) {
    //        _nome = ""
    //        _idade = idade.toInt()
    //    }

    // código executado após a inicialização do construtor
    //    init {
    //        if (idade < 0) {
    //            _idade = 0
    //        }
    //    }

    // Métodos
    fun imprimir() = println("$nome - $idade")

    fun fazerAniversario() {
        idade += 1
    }

//    fun getNome() = _nome
//    fun getIdade() = _idade
//
//    fun setNome(nome: String) {
//        _nome = nome.uppercase()
//    }
//
//    fun setIdade(idade: Int) {
//        _idade = if (idade >= 0) idade else 0
//    }

}

fun main() {
    val p = Pessoa("Homer Simpson", 40)
    println("${p.nome} - ${p.idade}")

    p.fazerAniversario()
    println("${p.nome} - ${p.idade}")

}