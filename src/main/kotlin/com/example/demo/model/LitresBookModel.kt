package com.example.demo.model

import com.google.gson.annotations.SerializedName

data class LitresBookModel(
        val id: Int,
        val title: String,
        val persons: Persons
)

data class Persons(val person: List<Person>)
data class Person(@SerializedName(value = "full_name", alternate = ["s_full_name"]) val fullName: String,
                  @SerializedName(value = "last_name", alternate = ["s_last_name"]) val lastName: String,
                  @SerializedName(value = "first_name", alternate = ["s_first_name"]) val firstName: String,
                  @SerializedName(value = "middle_name", alternate = ["s_middle_name"]) val middleName: String,
                  @SerializedName(value = "pseudonym", alternate = ["fake"]) val pseudonym: String,
                  @SerializedName(value = "translator", alternate = ["relation"]) val translator: String)