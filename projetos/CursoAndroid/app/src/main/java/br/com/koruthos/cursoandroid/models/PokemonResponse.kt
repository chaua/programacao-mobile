package br.com.koruthos.cursoandroid.models

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val count: Int,
    val next: String?,

    @SerializedName("previous")
    val prev: String?,

    @SerializedName("results")
    val results: List<Pokemon>
)