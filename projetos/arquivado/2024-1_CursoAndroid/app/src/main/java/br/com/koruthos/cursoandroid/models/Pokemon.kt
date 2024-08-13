package br.com.koruthos.cursoandroid.models

import com.google.gson.annotations.SerializedName

class Pokemon {

    // SerializedName: mapeia o campo JSON para a variavel
    @SerializedName("name")
    var nome: String = ""

    @SerializedName("url")
    var link: String = ""
}