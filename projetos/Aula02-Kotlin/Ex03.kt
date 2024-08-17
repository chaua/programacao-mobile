// Escreva um programa que leia dois números inteiros e imprima o maior deles.
def main() {
    println("Digite o primeiro número:")
    val num1 = readln().toInt()

    println("Digite o segundo número:")
    val num2 = readln().toInt()

    if (num1 > num2) {
        println("O maior número é $num1")
    } else {
        println("O maior número é $num2")
    }
}