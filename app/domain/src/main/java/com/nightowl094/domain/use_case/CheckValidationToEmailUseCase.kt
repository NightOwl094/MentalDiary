package com.nightowl094.domain.use_case

import com.nightowl094.domain.repositories.UserRepository

class CheckValidationToEmailUseCase(
    private val userRepository: UserRepository
) {
    suspend fun checkValidationToEmail(email: String) =
        userRepository.checkValidationToEmail(email)
}