package com.nightowl094.data.remote.response


import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("code")
    val code: String,
    @SerializedName("errorField")
    val errorField: String,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("success")
    val success: Boolean
)