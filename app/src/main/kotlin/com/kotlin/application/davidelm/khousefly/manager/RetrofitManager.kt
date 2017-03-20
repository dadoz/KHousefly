package com.kotlin.application.davidelm.khousefly.manager

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kotlin.application.davidelm.khousefly.BuildConfig
import com.kotlin.application.davidelm.khousefly.service.HouseAdService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {
    init {

    }

    var instance: RetrofitManager = this
    var service: HouseAdService? = null
    var baseUrlEndpoint = "https://api.github.com/" //BuildConfig.GITHUB_ENDPOINT

    init {
        try {
            service = Retrofit.Builder()
                    .baseUrl(baseUrlEndpoint)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
                    .create(HouseAdService::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}