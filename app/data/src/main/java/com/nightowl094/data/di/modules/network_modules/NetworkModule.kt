package com.nightowl094.data.di.modules.network_modules

import com.nightowl094.data.data_source.remote.MentalDiaryRetrofitHelper
import com.nightowl094.data.remote.api.CheckValidationToEmailService
import com.nightowl094.data.remote.api.SignUpService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideAccumulatePointService() =
        MentalDiaryRetrofitHelper.create<CheckValidationToEmailService>()

    @Provides
    fun provideSignUpService() =
        MentalDiaryRetrofitHelper.create<SignUpService>()

}