package com.nightowl094.data.di.modules.repository_modules

import com.nightowl094.data.remote.api.CheckValidationToEmailService
import com.nightowl094.data.remote.api.SignUpService
import com.nightowl094.data.repositories.UserRepositoryImpl
import com.nightowl094.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        checkValidationToEmailService: CheckValidationToEmailService,
        signUpService: SignUpService
    ): UserRepository = UserRepositoryImpl(
        checkValidationToEmailService,
        signUpService
    )

}