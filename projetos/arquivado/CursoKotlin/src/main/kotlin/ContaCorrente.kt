// Para definir a relação de herança:
// - Incluir o construtor da classe pai depois do construtor da classe filha
//  class Filha(..) : Pai(..)
// - Necessário que a classe pai seja herdável: open

// Ctrl + Alt + L

class ContaCorrente(
    numero: Int,
    agencia: Int,
    cliente: String
) : Conta(numero, agencia, cliente) {

    // Para sobrescrever um metodo da classe pai:
    // - O metodo da classe pai, tem que estar aberto para ser sobrescrito: open
    // - Incluir override no metodo da classe filha
    override fun imprimirExtrato() {
        println("=== CONTA CORRENTE ===")
        super.imprimirExtrato()
    }

    override fun aplicarJurosDiarios(dias: Int) {
        for (dia in 1..dias) {
            saldo += (saldo * 0.002).toInt()
        }
    }

    fun executarPix() {
        println("Fazendo pix...")
    }


}
