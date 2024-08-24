// Crie uma classe que representa uma Data, composta por: dia, mês e ano.
// A classe deverá ser capaz de imprimir a data no formato "dd/mm/aaaa".
// Além disso, a data deve ser capaz de calcular a sua diferença dela com
// outra data em dias.

class Data(val dia: Int, val mes: Int, val ano: Int) {
    fun imprimirData() {
        println("$dia/$mes/$ano")
    }

    fun subtrairData(outraData: Data): Int {
        val data1 = dia + mes * 30 + ano * 365
        val data2 = outraData.dia + outraData.mes * 30 + outraData.ano * 365
        return if (data1 > data2) data1 - data2 else data2 - data1
    }
}

fun main() {
    // Exemplo de comparação de datas
    val data1 = Data(1, 1, 2024)
    val data2 = Data(4, 12, 2024)

    data1.imprimirData()
    data2.imprimirData()

    println("Diferença entre as datas: ${data1.subtrairData(data2)} dias")
}