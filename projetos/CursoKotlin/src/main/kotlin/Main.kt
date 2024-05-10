fun main() {
    val conta1 = ContaCorrente(1111, 123, "Homer Simpson")
    val conta2 = ContaPoupanca(2222, 123, "Bart Simpson")

    conta1.depositar(100.00)
    conta2.depositar(500.00)

    conta1.imprimirExtrato()
    conta2.imprimirExtrato()

    conta2.transferir(200.00, conta1)
    conta2.imprimirExtrato()

    conta1.retirar(1000.00)
    conta1.imprimirExtrato()

    // Testes de polimofismo
    val conta3: Conta = ContaCorrente(3333, 123, "Lisa Simpson")
    //val conta4: Conta = Conta(4444, 123, "Marge Simpson") // ERRO!

    val banco = mutableListOf<Conta>()
    banco.add(conta1)
    banco.add(conta2)
    banco.add(conta3)

    println("\nImprimindo todas as contas do banco!\n")
    for (conta in banco) {
        conta.imprimirExtrato()
    }




    // ----------------
    // Exemplo de listas
    val lista1 = listOf(1, 2, 3, 4) // Retorna uma lista imutável
    val lista2 = mutableListOf(1, 2, 3, 4) // Retorna uma lista mutavel

    for (item in lista2) {
        print("$item, ")
    }
    println()

    lista2.add(100)
    lista2.add(300)

    for (item in lista2) {
        print("$item, ")
    }
    println()



}