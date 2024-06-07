package br.com.koruthos.cursoandroid.models

class ResponsePokeAPI {

    var count: Int = 0
    var next: String = ""
    var previous: String = ""
    var results: List<Pokemon>? = null

}