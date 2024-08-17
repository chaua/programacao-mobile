// Escreva um programa que leia o peso e altura de uma pessoa e calcule o seu IMC,
// dado pela seguinte fórmula: imc=peso/altura2imc=peso/altura2.
// Imprima a classificação do IMC de acordo com a seguinte tabela:
// IMC	                Classificação	Obesidade (grau)
// Menor que 18,5       Magreza         0
// Entre 18,5 e 24,9    Normal          0
// Entre 25,0 e 29,9    Sobrepeso       I
// Entre 30,0 e 39,9    Obesidade       II
// Maior que 40,0       Obesidade Grave III
fun main() {
    println("Digite o peso:")
    val peso = readln().toDouble()

    println("Digite a altura:")
    val altura = readln().toDouble()

    val imc = peso / (altura * altura)

    if (imc < 18.5) {
        println("IMC: $imc - Magreza")
    } else if (imc >= 18.5 && imc <= 24.9) {
        println("IMC: $imc - Normal")
    } else if (imc >= 25.0 && imc <= 29.9) {
        println("IMC: $imc - Sobrepeso")
    } else if (imc >= 30.0 && imc <= 39.9) {
        println("IMC: $imc - Obesidade")
    } else {
        println("IMC: $imc - Obesidade Grave")
    }
}