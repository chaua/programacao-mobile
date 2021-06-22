package br.com.koruthos.aula15.models

import com.google.gson.annotations.SerializedName

class Curso(
    var id: Int = 0,
    var titulo: String = "",
    var descricao: String = "",
    var fotoUrl: String? = ""
) {

    @SerializedName("periodo")
    var periodo: String? = null

    @SerializedName("valor")
    var valor: String? = null

    @SerializedName("local")
    var local: String? = null

    @SerializedName("local_url")
    var localUrl: String? = null


}
