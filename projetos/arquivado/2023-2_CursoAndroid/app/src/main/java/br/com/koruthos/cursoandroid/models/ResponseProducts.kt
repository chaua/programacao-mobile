package br.com.koruthos.cursoandroid.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseProducts {
    @SerializedName("products")
    var products: List<Product> = listOf()

    @SerializedName("total")
    var total: Int = 0

    @SerializedName("skip")
    var skip: Int = 0

    @SerializedName("limit")
    var limit: Int = 0
}