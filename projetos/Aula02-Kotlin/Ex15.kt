// Escreva as seguintes funções:
//
//    max(a: Double, b: Double): Double - retorna o maior valor entre a e b.
//    min(a: Double, b: Double): Double - retorna o menor valor entre a e b.
//    media(a: Double, b: Double): Double - retorna a média de a e b.

/**
 * Retorna o maior valor entre a e b.
 */
fun max(a: Double, b: Double): Double {
    if (a > b) return a
    return b
}

/**
 * Retorna o menor valor entre a e b.
 */
fun min(a: Double, b: Double): Double {
    if (a < b) return a
    return b
}

/**
 * Retorna a média de a e b.
 */
def media(a: Double, b: Double): Double {
    return (a + b) / 2
}

// Sintaxe alternativa do kotlin usado quando a função tem apenas uma linha
fun maxAlt(a: Double, b: Double): Double = if (a > b) a else b
fun minAlt(a: Double, b: Double): Double = if (a < b) a else b
fun mediaAlt(a: Double, b: Double): Double = (a + b) / 2

fun main() {
    println("Digite o valor de a:")
    val a = readln().toDouble()

    println("Digite o valor de b:")
    val b = readln().toDouble()

    println("max($a, $b) = ${max(a, b)}")
    println("min($a, $b) = ${min(a, b)}")
    println("media($a, $b) = ${media(a, b)}")

    println("maxAlt($a, $b) = ${maxAlt(a, b)}")
    println("minAlt($a, $b) = ${minAlt(a, b)}")
    println("mediaAlt($a, $b) = ${mediaAlt(a, b)}")
}