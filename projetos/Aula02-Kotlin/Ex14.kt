// Escreva um programa que imprima o fatorial dos números de 1 até 15.
// Obs: Não usaremos a implementação recursiva do fatorial, por motivos de eficiência.
fun fatorial(n: Int): Int {
    var fat = 1
    for (i in 1..n) {
        fat *= i
    }
    return fat
}

fun main() {
    for (i in 1..15) {
        val fat = fatorial(i)
        println("$i! = $fat")
    }
}