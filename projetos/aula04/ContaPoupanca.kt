
class ContaPoupanca(numero: Int, agencia: Int) : Conta(numero, agencia) {

    override fun aplicarJuros(dias: Int) {
        saldo += saldo * 0.003 * dias
    }

}