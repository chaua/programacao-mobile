// Crie uma classe que representa uma Conta bancária com as seguintes características:
//- Atributos: cliente, saldo, número, agência
//- Métodos: depositar, retirar, transferir, imprimirExtrato

class ContaBancaria(val cliente: String, val numero: Int, val agencia: Int) {

    // Variável saldo não permite que seja alterada fora da classe
    // Apenas os métodos da classe devem mexer nela
    var saldo: Double = 0.0
        get() = field


    fun depositar(valor: Double) {
        println("Depositando $valor na conta $numero")
        saldo += valor
    }

    fun retirar(valor: Double) {
        println("Retirando $valor da conta $numero")
        saldo -= valor
    }

    fun transferir(valor: Double, contaDestino: ContaBancaria) {
        println("Transferindo $valor da conta $numero para a conta ${contaDestino.numero}")
        this.retirar(valor)
        contaDestino.depositar(valor)
    }

    fun imprimirExtrato() {
        println("=== Extrato ===")
        println("- Conta/Ag.: $numero / $agencia")
        println("- Cliente..: $cliente")
        println("- Saldo....: R$ $saldo")
        println()
    }
}

fun main() {
    // Instanciação de uma conta
    val conta1 = ContaBancaria("Fulano", 1234, 123)
    conta1.depositar(2000.00)
    conta1.imprimirExtrato()

    // Instanciação de outra conta
    val conta2 = ContaBancaria("Ciclano", 5678, 456)
    conta2.depositar(1000.00)
    conta2.imprimirExtrato()

    // Exemplo de transferência
    conta1.transferir(500.00, conta2)
    conta1.imprimirExtrato()
    conta2.imprimirExtrato()

    // Exemplo de retirada
    conta1.retirar(4000.00)
    conta1.imprimirExtrato()
}