package com.example.technewsworks.data.datasource.api

import com.example.technewsworks.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("X-Api-Key", BuildConfig.API_KEY)
                .build()
        )
    }
}