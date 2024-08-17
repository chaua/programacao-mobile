// Escreva um programa que leia um inteiro nn e calcule o fatorial deste número.
// O fatorial é dado pela fórmula: n!=n⋅(n−1)⋅...⋅2⋅1n!=n⋅(n−1)⋅...⋅2⋅1
fun main() {
    println("Digite um número:")
    val n = readln().toInt()

    var fat = 1
    for (i in 1..n) {
        fat *= i
    }

    println("$n! = $fact")
}