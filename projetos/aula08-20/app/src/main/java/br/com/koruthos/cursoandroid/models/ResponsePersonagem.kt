package br.com.koruthos.cursoandroid.models

import android.icu.text.IDNA


data class ResponsePersonagem(
    val info: IDNA.Info,
    val results: ArrayList<Personagem>
)
