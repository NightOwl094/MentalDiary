package com.nightowl094.domain.repositories

import com.nightowl094.domain.entities.SimpleResponse
import com.nightowl094.domain.entities.User

interface UserRepository {
    suspend fun checkValidationToEmail(email: String): SimpleResponse?
    suspend fun requestSignUp(user: User): SimpleResponse?
}