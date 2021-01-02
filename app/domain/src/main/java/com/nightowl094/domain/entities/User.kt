package com.nightowl094.domain.entities

data class User(
    val id: Int? = null,
    val email: String,
    val password: String,
    val gender: Int,
    val birthDay: String
)