// Para definir a relação de herança:
// - Incluir o construtor da classe pai depois do construtor da classe filha
//  class Filha(..) : Pai(..)
// - Necessário que a classe pai seja herdável: open

// Ctrl + Alt + L

class ContaSalario(
    numero: Int,
    agencia: Int,
    cliente: String
) : Conta(numero, agencia, cliente) {

    // Para sobrescrever um metodo da classe pai:
    // - O metodo da classe pai, tem que estar aberto para ser sobrescrito: open
    // - Incluir override no metodo da classe filha
    override fun imprimirExtrato() {
        println("=== CONTA SALARIO ===")
        super.imprimirExtrato()
    }

    override fun aplicarJurosDiarios(dias: Int) {
        println("Sem esta operacao!")
    }


}
