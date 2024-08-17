// Escreva uma função que receba 3 valores reais a, b e c que representam os lados
// de um triângulo. Para que estes valores sejam comprimentos de lados de um triângulo,
// eles precisam satisfazer a seguinte condição: cada lado de um triângulo é menor do
// que a soma dos outros dois lados. Deste modo, a função deverá verificar se os lados
// representam um triângulo e então retornar o tipo do tro triângulo conforme as
// seguintes definições:
//
//    Triângulo Equilátero: 3 lados são iguais.
//    Triângulo Isósceles: 2 lados são iguais.
//    Triângulo Escaleno: lados são diferentes.

/**
 * Verifica se os valores a, b e c representam os lados de um triângulo.
 */
fun trianguloEhValido(a: Double, b: Double, c: Double): String {
    return (a < b + c
            && b < a + c
            && c < a + b)
}

/**
 * Retorna o tipo do triângulo.
 */
fun trianguloTipo(a: Double, b: Double, c: Double): String {
    if (a == b && b == c) {
        return "Equilátero"
    } else if (a == b || b == c || a == c) {
        return "Isósceles"
    } else {
        return "Escaleno"
    }
}

fun main() {
    println("Digite o valor de a:")
    val a = readln().toDouble()

    println("Digite o valor de b:")
    val b = readln().toDouble()

    println("Digite o valor de c:")
    val c = readln().toDouble()

    if (trianguloEhValido(a, b, c)) {
        println("Os valores representam um triângulo do tipo ${trianguloTipo(a, b, c)}")
    } else {
        println("Os valores não representam um triângulo")
    }
}