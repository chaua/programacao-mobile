package br.com.koruthos.cursoandroid.models

import com.google.gson.annotations.SerializedName

data class Sprites(
    @SerializedName("back_default")
    val backDefault: String,

    @SerializedName("front_default")
    val frontDefault: String
)