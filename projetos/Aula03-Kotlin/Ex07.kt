//Crie uma classe Carta que represente uma carta de baralho com atributos
// como naipe e valor. Crie uma classe Baralho que represente um baralho de
// cartas completo. Implemente métodos para embaralhar o baralho, distribuir
// cartas. Entregue 5 cartas para um Jogador que vai verificar se as cartas
// possuem combinações vencedoras, como:
//
//  Par: Duas cartas com mesmo valor
//  Exemplo: A♠️ + A♥️
//
//  Trinca: Três cartas com mesmo valor
//  Exemplo: A♠️ + A♥️ + A♦️
//
//  Full House: Três cartas com mesmo valor mais outras duas com mesmo valor
//  Exemplo: A♠️ + A♥️ + A♦️+ 5♣️ + 5♥️
//
//  Flush: Todas cartas com mesmo naipe
//  Exemplo: A♦️+ 3♦️+ 6♦️ + Q♦️ + 10♦️

class Carta(val naipe: String, val valor: String) {
    override fun toString(): String {
        return "$valor$naipe"
    }
}

class Jogador(val nome: String) {
    val cartas: MutableList<Carta> = mutableListOf()

    fun verificarCombinacoes() {

        // Cria uma lista somente com os valores das cartas do jogador
        val valores = cartas.map { it.valor }

        // Cria uma lista somente com os naipes do jogador
        val naipes = cartas.map { it.naipe }

        // Se tiver 4 valores distintos, então tem um par
        if (valores.distinct().size == 4) {
            println("Par")
        }
        // Se tiver 3 valores distintos, então tem uma trinca
        else if (valores.distinct().size == 3) {
            println("Trinca")
        }
        // Se tiver 2 valores distintos, então tem um full house ou dois pares
        else if (valores.distinct().size == 2) {
            println("Full House")

            // Se tiver apenas um naipe, então tem um flush
        } else if (naipes.distinct().size == 1) {
            println("Flush")
        } else {
            println("Nenhuma combinação")
        }

    }
}

class Baralho {
    val cartas: MutableList<Carta> = mutableListOf()

    init {
        val naipes = listOf("♠️", "♥️", "♦️", "♣️")
        val valores = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")

        for (naipe in naipes) {
            for (valor in valores) {
                cartas.add(Carta(naipe, valor))
            }
        }
    }

    fun embaralhar() {
        cartas.shuffle()
    }

    fun distribuirCartas(jogador: Jogador) {
        for (i in 0 until 5) {
            jogador.cartas.add(cartas.removeAt(0))
        }
    }
}

fun main() {
    val baralho = Baralho()
    baralho.embaralhar()

    val jogador = Jogador("Jogador 1")
    baralho.distribuirCartas(jogador)

    println("Cartas do jogador:")
    for (carta in jogador.cartas) {
        println(carta)
    }

    jogador.verificarCombinacoes()
}