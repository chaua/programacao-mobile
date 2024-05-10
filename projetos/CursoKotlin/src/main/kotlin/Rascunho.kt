import kotlin.math.abs

fun main() {

    var num = 0.0f

    for (i in 1..10_000_000) {
        num += 0.1f
    }

    println(num == 1.0f)
    println(abs(num - 1.0f) <= 0.0001f)

    println(num)

}