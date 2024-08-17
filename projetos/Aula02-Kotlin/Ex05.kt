// Escreva um programa que leia um número e verifique se este número é
// múltiplo de 3 e 4.
fun main() {
    println("Digite um número:")
    val num = readln().toInt()

    // Solução 1
    if (num % 3 == 0 && num % 4 == 0) {
        println("$num é múltiplo de 3 e 4")
    } else {
        println("$num não é múltiplo de 3 e 4")
    }

    // Solução alternativa
    if (num % 12 == 0) {
        println("$num é múltiplo de 3 e 4")
    } else {
        println("$num não é múltiplo de 3 e 4")
    }
}