
fun main() {

    // listOf: cria uma lista estática
    // mutableListOf: cria uma lista que permite inserção e remoção

    val contas = mutableListOf<Conta>()

    contas.add(ContaCorrente(11111, 1234))
    contas.add(ContaPoupanca(22222, 1234))
    contas.add(ContaSalario(33333, 1234, 5000.0))
    // contas.add(Conta(44444, 1234)) // Erro pq Conta é abstrata

    for (conta in contas) {
        try {
            conta.depositar(1000.0)
        }
        catch (ex: NotImplementedError) {
            println(ex)
        }

    }

    for (conta in contas) {
        conta.extrato()
    }



}