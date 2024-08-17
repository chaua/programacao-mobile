// Escreva uma função chamada potência que receba dois parâmetros inteiros
// positivos a e b, e retorne o valor de potencia(a,b)=a^b.
// Realize esta operação sem o auxílio de funções prontas de exponenciação.
fun main() {
    println("Digite o valor de a:")
    val a = readln().toInt()

    println("Digite o valor de b:")
    val b = readln().toInt()

    var result = 1
    for (i in 1..b) {
        result *= a
    }

    println("O valor de $a^$b é $result")
}