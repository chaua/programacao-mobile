package br.com.koruthos.cursoandroid.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Ability {
    @SerializedName("is_hidden")
    @Expose
    var isHidden: Boolean? = null

    @SerializedName("slot")
    @Expose
    var slot: Int? = null
}