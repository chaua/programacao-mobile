
// Escreva um programa que leia um número entre 1 e 7 correspondendo a um dia da semana, sendo domingo o primeiro dia,
// e imprima o nome do dia da semana. Utilize o comando when.
fun main() {
    println("Digite um número entre 1 e 7:")
    val num = readln().toInt()

    when (num) {
        1 -> println("Domingo")
        2 -> println("Segunda-feira")
        3 -> println("Terça-feira")
        4 -> println("Quarta-feira")
        5 -> println("Quinta-feira")
        6 -> println("Sexta-feira")
        7 -> println("Sábado")
        else -> println("Número inválido")
    }
}