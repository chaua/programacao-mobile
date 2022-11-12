package br.com.koruthos.cursoandroid.models

import com.google.gson.annotations.SerializedName

data class Personagem(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("status") var status: String,
    @SerializedName("species") var species: String,
    @SerializedName("type") var type: String,
    @SerializedName("gender") var gender: String,
    @SerializedName("image") var image: String,
)
