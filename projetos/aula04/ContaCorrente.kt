
class ContaCorrente(numero: Int, agencia:Int) : Conta(numero, agencia){

    override fun aplicarJuros(dias: Int) {
        saldo += saldo * 0.01 * dias
    }

}