package com.example.demo.service

import com.example.demo.model.LitresBookModel
import com.example.demo.repository.Litres
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LitresService(@Autowired val litres: Litres, val gson: Gson) {
    val litresBookModelType = object : TypeToken<List<LitresBookModel>>() {}.type

    fun autoComplete(text: String, limit: Int): List<LitresBookModel> {
        val autoCompleteResult = gson.fromJson<JsonObject>(litres.autoCompleteQuery(text, limit), JsonObject::class.java)
        val litresBookList = gson.fromJson<List<LitresBookModel>>(autoCompleteResult.getAsJsonArray("result"), litresBookModelType)

        return litresBookList
    }
}

