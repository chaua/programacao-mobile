package br.com.koruthos.aula17.activities

import android.content.Context
import br.com.koruthos.aula17.model.Contato
import com.google.gson.Gson
import android.util.Log

object SharedUtil {

    private const val CONFIG_FILE = "aula17.config"
    private const val KEY_LOGADO = "LOGADO"
    private const val KEY_LOGIN = "LOGIN"
    private const val KEY_CONTATO = "CONTATO"

    fun setLogado(context: Context, logado: Boolean) {
        val editor = context.getSharedPreferences(CONFIG_FILE, Context.MODE_PRIVATE).edit()
        editor.putBoolean(KEY_LOGADO, logado)
        editor.apply()
    }

    fun getLogado(context: Context) : Boolean {
        val preferences = context.getSharedPreferences(CONFIG_FILE, Context.MODE_PRIVATE)
        return preferences.getBoolean(KEY_LOGADO, false)
    }

    fun setContato(context: Context, contato: Contato) {
        val editor = context.getSharedPreferences(CONFIG_FILE, Context.MODE_PRIVATE).edit()

        val gson = Gson()
        val json = gson.toJson(contato)

        Log.d("TAG", json)

        editor.putString(KEY_CONTATO, json)
        editor.apply()
    }

    fun getContato(context: Context) : Contato {
        val preferences = context.getSharedPreferences(CONFIG_FILE, Context.MODE_PRIVATE)
        val json = preferences.getString(KEY_CONTATO, "")

        val gson = Gson()
        val contato: Contato = gson.fromJson(json, Contato::class.java)

        return contato
    }


}
