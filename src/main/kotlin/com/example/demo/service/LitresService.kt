package com.example.demo.service

import com.example.demo.model.Book
import com.example.demo.repository.Litres
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LitresService(@Autowired val litres: Litres, val gson: Gson) {

    fun autoComplete(text: String, limit:Int): List<Book> {
        val autoCompleteResult = gson.fromJson<JsonObject>(litres.autoCompleteQuery(text, limit), JsonObject::class.java)
        val bookList = autoCompleteResult.getAsJsonArray("result")
                .map { it as JsonObject }
                .map { convertLitres(it) }
                .toList()


        println(bookList)
        return bookList
    }

    private fun convertLitres(jsonObject: JsonObject): Book {
        val title = jsonObject.getAsJsonPrimitive("title")?.asString
        val person = jsonObject.getAsJsonObject("persons")?.getAsJsonArray("person")?.get(0)?.asJsonObject
        val author = person?.getAsJsonPrimitive("s_full_name")?.asString

        return Book(author?:"", "", title?:"")
    }
}

