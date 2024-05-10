
abstract class Conta(numero: Int, agencia: Int) {
    val numero = numero
    val agencia = agencia
    protected var saldo = 0.0

    open fun depositar(quantia: Double) {
        saldo += quantia
    }

    fun retirar(quantia: Double) {
        saldo -= quantia
    }

    fun extrato() {
        println("$numero - $agencia")
        println("Saldo = R\$ $saldo")
    }

    // Método abstrato não tem implementação
    // Por isso, a classe abstrata não pode ser instanciada
    abstract fun aplicarJuros(dias: Int)

}