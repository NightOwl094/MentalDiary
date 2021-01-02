package com.nightowl094.data.remote.api

import com.nightowl094.data.remote.dto.SignUpDTO
import com.nightowl094.data.remote.response.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SignUpService {
    @POST("v1/user/signUp")
    suspend fun requestSignUp(@Body signUpDTO: SignUpDTO): SignUpResponse?
}