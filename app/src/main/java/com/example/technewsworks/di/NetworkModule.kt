package com.example.technewsworks.di

import com.example.technewsworks.data.datasource.api.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkInterceptor() : NetworkInterceptor = NetworkInterceptor()

    @Singleton
    @Provides
    fun provideOkHttpClient(networkInterceptor: NetworkInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(networkInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
}