package com.example.akmtranslatekotlin.iu.translate

import android.util.Log

class ThreadTranslate(text: String?, to: String?, from: String?) :
    Thread() {
    var translateRule: StructuraTranslate
    var textRespond: String? = null
    override fun run() {
        Log.i(TAG, "Запущен поток")
        val connectTranslateAPI = ConnectTranslateAPI(translateRule)
        textRespond = connectTranslateAPI.GetTranslateText()
        Log.i(TAG, "Текст ответа в потоке: $textRespond")
    }

    fun GetTextTranslate(): String? {
        return textRespond
    }

    companion object {
        private const val TAG = "MyLog"
    }

    init {
        translateRule = StructuraTranslate(text!!, to!!, from!!)
    }
}