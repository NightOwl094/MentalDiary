package com.nightowl094.domain.entities

data class SimpleResponse(
    val code: String,
    val msg: String,
    val success: Boolean,
)