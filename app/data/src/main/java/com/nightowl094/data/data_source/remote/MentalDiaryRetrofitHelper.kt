package com.nightowl094.data.data_source.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MentalDiaryRetrofitHelper {

    fun getService(): Retrofit = Retrofit.Builder()
        .baseUrl("http://193.123.249.183:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    inline fun <reified T> create(): T = getService().create(T::class.java)
}