package com.nightowl094.data.remote.api

import com.nightowl094.data.remote.response.CheckValidationToEmailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CheckValidationToEmailService {
    @GET("v1/user")
    suspend fun checkValidationToEmail(
        @Query("email") email: String
    ): CheckValidationToEmailResponse?
}