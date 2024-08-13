package br.com.koruthos.cursoandroid.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("description")
    var description: String = ""

    @SerializedName("price")
    var price: Int = 0

    @SerializedName("rating")
    var rating: Double = 0.0

    @SerializedName("images")
    var images: List<String> = listOf()
}