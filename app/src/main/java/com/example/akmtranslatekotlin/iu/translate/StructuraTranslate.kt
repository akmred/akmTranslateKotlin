package com.example.akmtranslatekotlin.iu.translate

//import com.google.gson.Gson
//import com.google.gson.GsonBuilder
//import com.google.gson.JsonElement
//import com.google.gson.JsonParser

/*
* Структура перевода
* состоит из:
* from - с какого текста переводить (ru, en)
* to - на какой переводить (ru, en)
* textSource - текст для перевода
* textTranslateForGSon - переведенный текст в формате GSON
* */
class StructuraTranslate(
    private val textSource: String,
    private val to: String,
    private val from: String
) {
    private var textTranslateForGSon: String? = null

    /*
    * Заполняет текст перевода
    * */
    fun setTextTranslate(textTranslate: String?) {
        textTranslateForGSon = textTranslate
    }

    /*
    * Возвращает текст для перевода в формате json
    * */
    val textSourceForGSon: String
        get() {
            val textGSon = "[{\n    \"text\":$textSource\"\n}\n]"
            return prettify(textGSon)
        }

    /*
    * Берет перевденный текст в формате json и преобразует в простой текст
    * */
    fun getTextTranslateForGSon(): String? {
        val textTranslate = fromGSon(textTranslateForGSon)
        return textTranslateForGSon
    }

    /*
    * Преобразует json текст в простой текст
    * */
    private fun fromGSon(textTranslateForGSon: String?): String {
//        var bodyResponse = BodyResponse()
//        val gsonBuilder = GsonBuilder()
//        gsonBuilder.create()
//        val gson = Gson()
//        bodyResponse = gson.fromJson(textTranslateForGSon, BodyResponse::class.java)
//        return bodyResponse.text
        return ""
    }

    /*
    * Дополняет услове направление перевода
    * */
    val toFrom: String
        get() = "&to=$to&from=$from"

    companion object {
        // This function prettifies the json response.
        private fun prettify(json_text: String): String {
//            val parser = JsonParser()
//            val json: JsonElement = parser.parse(json_text)
//            val gson: Gson = GsonBuilder().setPrettyPrinting().create()
//            return gson.toJson(json)
        return ""
        }
    }
}