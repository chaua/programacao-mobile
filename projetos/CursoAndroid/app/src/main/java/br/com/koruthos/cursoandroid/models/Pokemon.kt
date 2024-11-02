package br.com.koruthos.cursoandroid.models

import com.google.gson.annotations.SerializedName

/**
 * Esta classe representa um Pokémon.
 */
data class Pokemon(
    val id: Int = 0,
    val sprites: Sprites = Sprites("", ""),

    @SerializedName("name")
    val nome: String,
    val tipo: String,
    val urlImagem: String,
    val urlDetalhes: String
)
