// Escreva um programa que leia três números inteiros e imprima o maior deles.
fun main() {
    println("Digite o primeiro número:")
    val num1 = readln().toInt()

    println("Digite o segundo número:")
    val num2 = readln().toInt()

    println("Digite o terceiro número:")
    val num3 = readln().toInt()

    if (num1 > num2 && num1 > num3) {
        println("O maior número é $num1")
    } else if (num2 > num1 && num2 > num3) {
        println("O maior número é $num2")
    } else {
        println("O maior número é $num3")
    }
}