// Classes abstratas
// . Uma classe abstrata é uma classe que tem pelo menos 1 método abstrato
// . Um método abstrato é um método sem implementação
//  - Só possui a definição do método com os parâmetros
//  - Não implementa nada
//  - As classes filhas são obrigadas a implementar
//  - Uma classe abstrata não pode ser instanciada

/**
 * Representaação de uma conta bancária.
 */
abstract class Conta(
    val numero: Int,
    val agencia: Int,
    var cliente: String
) {

    protected var saldo: Int = 0

    fun depositar(quantia: Double) {
        saldo += (quantia * 100).toInt()
    }

    fun retirar(quantia: Double) {
        saldo -= (quantia * 100).toInt()
    }

    fun transferir(quantia: Double, outra: Conta) {
        this.retirar(quantia)
        outra.depositar(quantia)
    }

    open fun imprimirExtrato() {
        println("Conta..: $numero/$agencia")
        println("Cliente: $cliente")
        println("Saldo..: ${getSaldo()}")
    }

    fun getSaldo(): Double {
        return (saldo / 100).toDouble()
    }

    // Outra maneira de escrever a funcao:
    // fun getSaldo() = (saldo / 100).toDouble()

    // Juros de uma conta corrente: 2% ao dia
    // Juros de uma conta poupança: 8% ao dia
    // Juros de uma conta salario: 0% ao dia
    abstract fun aplicarJurosDiarios(dias: Int)

}