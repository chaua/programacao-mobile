package br.com.koruthos.aula15.models

import com.google.gson.annotations.SerializedName

class Curso {

    @SerializedName("id")
    var id: String? = null

    @SerializedName("titulo")
    var titulo: String? = null

    @SerializedName("descricao")
    var descricao: String? = null

    @SerializedName("periodo")
    var periodo: String? = null

    @SerializedName("valor")
    var valor: String? = null

    @SerializedName("local")
    var local: String? = null

    @SerializedName("local_url")
    var localUrl: String? = null

    @SerializedName("foto_url")
    var fotoUrl: String? = null
}
