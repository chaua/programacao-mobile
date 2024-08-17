// Escreva um programa que dado um inteiro positivo nn, calcule e imprima
// o valor da seguinte soma: f(n)=2/4+5/5+10/6+...+(n^2+1)/(n+3)
fun main() {
    println("Digite um número:")
    val n = readln().toInt()

    var soma = 0.0
    for (i in 1..n) {
        soma += (i * i + 1).toDouble() / (i + 3)
    }

    println("f($n) = $soma")
}