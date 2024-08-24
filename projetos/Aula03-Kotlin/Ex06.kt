// Crie uma classe abstrata Animal com atributos como nome, idade e som.
// Crie classes derivadas de Animal para representar diferentes tipos de animais,
// como cachorro, gato e pássaro. Implemente métodos específicos para cada
// tipo de animal, como latir, miar e cantar. Utilize herança e polimorfismo
// para criar uma lista de animais e exibir informações sobre cada um deles.

abstract class Animal(val nome: String, val idade: Int, val som: String) {
    // Classe abstrata tem pelo menos um método abstrato
    // As classes filhas devem implementar os métodos abstratos
    abstract fun emitirSom()
}

class Cachorro(nome: String, idade: Int) : Animal(nome, idade, "Au au") {
    override fun emitirSom() {
        println("O cachorro $nome faz $som")
    }
}

class Gato(nome: String, idade: Int) : Animal(nome, idade, "Miau") {
    override fun emitirSom() {
        println("O gato $nome faz $som")
    }
}

fun main() {
    val cachorro = Cachorro("Rex", 5)
    val gato = Gato("Garfield", 3)

    val animais = listOf(cachorro, gato)
    for (animal in animais) {
        animal.emitirSom()
    }

    // ERRO!
    // val animal = Animal("Animal", 1, "Som") // Erro: não é possível instanciar uma classe abstrata
}