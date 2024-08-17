// Escreva um programa que dado um inteiro positivo nn, calcule e imprima o valor da seguinte
// soma: f(n)=1/n+2/(n−1)+3/(n−2)+...+n/1
fun main() {
    println("Digite um número:")
    val n = readln().toInt()

    var soma = 0.0
    for (i in 1..n) {
        soma += i.toDouble() / (n - i + 1)
    }

    println("f($n) = $soma")
}