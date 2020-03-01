package com.example.demo.repository

import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import java.net.URLEncoder

@Repository
class Litres(val restTemplate: RestTemplate = RestTemplate()) {

    fun autoCompleteQuery(text: String, limit: Int = 10): String {
        val parameter = "json=1&q=${text}&limit=${limit}&gu_ajax=true"
        println("--->>> Requesting guery ${host + parameter} ")
        val response = restTemplate.getForEntity(host + parameter, String::class.java)
        println("<<<--- Response status: ${response.statusCode}. Response body: ${response.body}")
        return if (response.statusCode.is2xxSuccessful) {
            response.body ?: ""
        } else "Not OK"
    }

    companion object Const {
        const val host = "https://www.litres.ru/pages/search_slice/?"
    }
}
