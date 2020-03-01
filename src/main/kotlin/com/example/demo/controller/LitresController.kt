package com.example.demo.controller

import com.example.demo.service.LitresService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class LitresController(@Autowired val litresService: LitresService, val gson: Gson) {

    @GetMapping("/autocomplete")
    fun completeTheText(@RequestParam("text") text: String, @RequestParam(value = "limit") limit: Int): Any {
        val responseHeaders = HttpHeaders()
        responseHeaders.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost")
        responseHeaders.set(HttpHeaders.CONTENT_TYPE, "application/json")

        return ResponseEntity(gson.toJson(litresService.autoComplete(text, limit)), responseHeaders, HttpStatus.OK)
    }
}