/* Copyright (c) 2022 Chauã Queirolo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 */

// Convenção da linguagem - Conjunto de regras de formatação da linguagem
// - Comentário de bloco: /* */             usado para copyright
// - Comentário de linha: //                usado para explicar blocos ou comentar código (Ctrl + /)
// - Comentário de documentação: /** */     usado para gerar documentação - classe, atributo, método

/**
 * Função principal
 *
 * @author Chauã Queirolo
 * @version 1.0
 */
fun main() {
    // Imprime mensagem na tela sem pular linha
    print("Alô, mamãe! ")

    // Imprime mensagem na tela e pula uma linha
    println("Alô, mamãe!")

    // Declaração de variáveis
    //  - val: variável somente leitura
    //  - var: variável de leitura e escrita
    val nome = "Bart"
    val sobrenome = "Simpson"

    // nome = "Lisa" // Erro pois a variável é somente leitura

    // Interpolação de strings:
    // - $variavel
    // - ${variavel} ou ${funcao()}
    println("Nome: $nome $sobrenome")

    // Tipo da variável é definido com base no valor atribuído
    // !!! Kotlin é uma linguagem fortemente tipada
    var numero = 15     // 15 é inteiro
    // numero = "teste" // ERRO!

    numero = 100 + 30
    println("Numero = $numero")

    val disciplina: String = "Inglês"
    val idade: Int = 25
    val saldo: Float = 12.99F

    val area = 5.inc() * 10.toFloat()
    println(area)
    println(5.toString())

}