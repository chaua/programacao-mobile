// Crie uma classe que representa uma Lâmpada. A lâmpada tem dois
// estados: acesa e apagada. Ela também pode ser acendida e apagada.
// No entanto, se ela for acendida e apagada 5 vezes seguidas ela queima.
// Escreva um programa simule duas lâmpadas e queime uma delas.

// Solução 1
// usando o estado como string
class Lampada {
    var estado: String = "apagada"
        get() = field

    var vezesAcesa: Int = 0
        get() = field

    fun acender() {
        if (estado == "apagada") {
            estado = "acesa"
            vezesAcesa++
            queimar()
        } else if (estado == "queimada") {
            println("Lâmpada queimada não pode ser acesa")
        }
        else {
            println("Lâmpada já está acesa")
        }

    }

    fun apagar() {
        if (estado == "acesa") {
            estado = "apagada"
        } else {
            println("Lâmpada já está apagada")
        }
    }

    fun queimar() {
        if (vezesAcesa >= 5) {
            println("Lâmpada queimou!")
            estado = "queimada"
        }
    }
}

fun main() {
    // Exemplo de uso de uma lampada até queimar
    val lampada1 = Lampada()

    for (i in 1..6) {
        lampada1.acender()
        lampada1.apagar()
    }

}