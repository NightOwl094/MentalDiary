package com.nightowl094.data.repositories

import android.util.Log
import com.nightowl094.data.remote.api.CheckValidationToEmailService
import com.nightowl094.data.remote.api.SignUpService
import com.nightowl094.data.remote.dto.SignUpDTO
import com.nightowl094.domain.entities.SimpleResponse
import com.nightowl094.domain.entities.User
import com.nightowl094.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val checkValidationToEmailService: CheckValidationToEmailService,
    private val signUpService: SignUpService
) : UserRepository {
    override suspend fun checkValidationToEmail(email: String) =
        try {
            checkValidationToEmailService.checkValidationToEmail(email)?.run {
                SimpleResponse(code, msg, success)
            }
        } catch (e: Exception) {
            Log.d("ttt", "UserRepositoryImpl checkValidationToEmail: $e")
            null
        }

    override suspend fun requestSignUp(user: User) =
        try {
            signUpService.requestSignUp(
                SignUpDTO(
                    email = user.email,
                    gender = user.gender,
                    password = user.password,
                    birthdate = user.birthDay
                ).also {
                    Log.d("ttt", "UserRepositoryImpl requestSignUp: ${it}")
                }
            )?.run {
                SimpleResponse(code, msg, success)
            }
        } catch (e: Exception) {
            Log.d("ttt", "UserRepositoryImpl checkValidationToEmail: $e")
            null
        }

}