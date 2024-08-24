// Crie uma classe que representa um Produto em um carrinho de compras.
// Um produto possui: nome, categoria, preço e quantidade. O produto deverá
// ser capaz de calcular o valor total com base no preço e quantidade.

class Produto(val nome: String, val categoria: String, val preco: Double, val quantidade: Int) {
    fun calcularValorTotal(): Double {
        return preco * quantidade
    }
}

fun main() {
    val produto1 = Produto("Arroz", "Alimento", 10.0, 2)
    println("Valor total do produto ${produto1.nome}: R$ ${produto1.calcularValorTotal()}")
    val produto2 = Produto("Feijão", "Alimento", 5.0, 3)
    println("Valor total do produto ${produto2.nome}: R$ ${produto2.calcularValorTotal()}")
    val produto3 = Produto("Notebook", "Eletrônico", 3000.0, 1)
    println("Valor total do produto ${produto3.nome}: R$ ${produto3.calcularValorTotal()}")
}