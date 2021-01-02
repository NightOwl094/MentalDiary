package com.nightowl094.feature_signup.di.use_case_modules

import com.nightowl094.domain.repositories.UserRepository
import com.nightowl094.domain.use_case.CheckValidationToEmailUseCase
import com.nightowl094.domain.use_case.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
object SignUpUseCaseModule {

    @Provides
    fun provideCheckValidationToEmailUseCase(
        userRepository: UserRepository
    ) = CheckValidationToEmailUseCase(userRepository)

    @Provides
    fun provideSignUpUseCase(
        userRepository: UserRepository
    ) = SignUpUseCase(userRepository)

}