package br.com.koruthos.cursoandroid.models

/**
 * Esta classe representa um Pokémon.
 */
data class Pokemon(
    val nome: String,
    val tipo: String,
    val urlImagem: String,
    val urlDetalhes: String
)
