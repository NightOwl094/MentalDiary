package com.nightowl094.data.remote.response

import com.google.gson.annotations.SerializedName

data class CheckValidationToEmailResponse(
    @SerializedName("code")
    val code: String,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("success")
    val success: Boolean,
)