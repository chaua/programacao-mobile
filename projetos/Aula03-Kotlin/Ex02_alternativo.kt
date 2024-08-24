// Crie uma classe que representa uma Lâmpada. A lâmpada tem dois
// estados: acesa e apagada. Ela também pode ser acendida e apagada.
// No entanto, se ela for acendida e apagada 5 vezes seguidas ela queima.
// Escreva um programa simule duas lâmpadas e queime uma delas.

// Solução 2
// usando enum para representar os estados

enum class EstadoLampada {
    APAGADA,
    ACESA,
    QUEIMADA
}

class LampadaAlt {
    var estado: EstadoLampada = EstadoLampada.APAGADA
        get() = field

    var vezesAcesa: Int = 0
        get() = field

    fun acender() {
        // Usando when para verificar o estado atual da lâmpada
        // Sintaxe do when é mais clean que if/else if
        when (estado) {
            EstadoLampada.APAGADA -> {
                estado = EstadoLampada.ACESA
                vezesAcesa++
                queimar()
            }
            EstadoLampada.QUEIMADA -> {
                println("Lâmpada queimada não pode ser acesa")
            }
            else -> {
                println("Lâmpada já está acesa")
            }
        }

    }

    fun apagar() {
        if (estado == EstadoLampada.ACESA) {
            estado = EstadoLampada.APAGADA
        } else {
            println("Lâmpada já está apagada")
        }
    }

    fun queimar() {
        if (vezesAcesa >= 5) {
            println("Lâmpada queimou!")
            estado = EstadoLampada.QUEIMADA
        }
    }
}

fun main() {
    // Exemplo de uso de uma lampada até queimar
    val lampada = LampadaAlt()

    for (i in 1..6) {
        lampada.acender()
        lampada.apagar()
    }

}