
class ContaSalario(numero: Int, agencia: Int, salario: Double) : Conta(numero, agencia) {

    init {
        saldo = salario
    }

    override fun depositar(quantia: Double) {
        throw NotImplementedError("Não é possível depositar em conta salário")
    }

    override fun aplicarJuros(dias: Int) {
        saldo += saldo * 0.0 * dias
    }

}