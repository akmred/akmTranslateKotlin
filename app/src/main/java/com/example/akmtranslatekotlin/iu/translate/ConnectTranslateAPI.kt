package com.example.akmtranslatekotlin.iu.translate

import android.util.Log
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException

/*
* Класс соединения с API translate
* и получения перевода
* */
class ConnectTranslateAPI(private val translateRule: StructuraTranslate) {
    /*
     * Запрпашивает перевод у апи
     * */
    @get:Throws(IOException::class)
    val respondOnPOST: String
        get() {
            val client: OkHttpClient = OkHttpClient().newBuilder()
                .build()
            val mediaType: MediaType? = "application/json".toMediaTypeOrNull()
            val body: RequestBody =
                RequestBody.create(mediaType, translateRule.getTextSourceForGSon())
            val request: Request = Request.Builder()
                .url("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0" + translateRule.getToFrom())
                .method("POST", body)
                .addHeader("Ocp-Apim-Subscription-Key", "467a55e9232d43418688dd5fb21d345c")
                .addHeader("Content-Type", "application/json")
                .build()
            Log.i(TAG, "запрос в апи: " + request.toString())
            val response: Response = client.newCall(request).execute()
            Log.i(TAG, "ответ из апи: " + request.toString())
            return response.body().string()
        }

    /*
    * Возвращает текст перевода
    * */
    fun GetTranslateText(): String? {
        var Response = String()
        try {
            Response = respondOnPOST
        } catch (e: IOException) {
            e.printStackTrace()
        }
        translateRule.setTextTranslate(Response)
        return translateRule.getTextTranslateForGSon()
    }

    companion object {
        private const val TAG = "MyLog"
    }
}