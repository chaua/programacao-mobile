
data class Lampada(
    var estado: String = "acesa"
)

fun main() {
    val lampada1 = Lampada()
    val lampada2 = Lampada()

    println(lampada1.estado)

//    for (i in 1..5) {
//        lampada1.acender()
//        lampada1.apagar()
//    }

    println(lampada1.estado)
}