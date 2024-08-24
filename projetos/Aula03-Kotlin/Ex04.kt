// Crie uma classe que representa uma Pessoa. A pessoa possui um nome, uma data
// de nascimento, peso e altura.
//
//    Crie um método para calcular a idade da pessoa com base na data de hoje.
//    Utilize a classe Data criada no exercício anterior através da composição.
//
//    Crie um método para calcular o imc da Pessoa e retorne a sua classificação
//    de obesidade.

class Pessoa(val nome: String, val dataNascimento: Data, val peso: Double, val altura: Double) {

    fun calcularIdade(dataAtual: Data): Int {
        return dataAtual.subtrairData(dataNascimento) / 365
    }

    fun calcularImc(): String {
        val imc = peso / (altura * altura)
        return when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 24.9 -> "Peso normal"
            imc < 29.9 -> "Sobrepeso"
            imc < 34.9 -> "Obesidade grau 1"
            imc < 39.9 -> "Obesidade grau 2"
            else -> "Obesidade grau 3"
        }
    }
}

fun main() {
    val hoje = Data(1, 1, 2024)
    val pessoa = Pessoa("Fulano", Data(1, 1, 2000), 70.0, 1.75)
    println("Idade: ${pessoa.calcularIdade(hoje)} anos")
    println("IMC: ${pessoa.calcularImc()}")
}