package com.nightowl094.domain.use_case

import com.nightowl094.domain.entities.User
import com.nightowl094.domain.repositories.UserRepository

class SignUpUseCase(
    private val userRepository: UserRepository
) {
    suspend fun requestSignUp(user: User) =
        userRepository.requestSignUp(user)
}