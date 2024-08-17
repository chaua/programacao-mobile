// Escreva uma função que receba um valor inteiro como parâmetro e retorne o
// fatorial deste número.
fun fatorial(n: Int): Int {
    if (n == 0 || n == 1) return 1
    return n * fatorial(n - 1)
}

fun main() {
    println("Digite um número:")
    val n = readln().toInt()

    val fat = fatorial(n)

    println("$n! = $fat")
}