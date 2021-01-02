package com.nightowl094.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SignUpDTO(
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("password")
    val password: String,
    @SerializedName("birthdate")
    val birthdate: String
)