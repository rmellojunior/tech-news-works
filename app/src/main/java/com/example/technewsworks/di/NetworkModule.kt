package com.example.technewsworks.di

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

    // TODO: Retrofit does get an instance of OkHttp by itself but does not perform any
    //  customization of the OkHttpClient. If we want a custom one, we might need to customize the
    //  client to take advantage of the flexibility of OkHttp.
//    @Singleton
//    @Provides
//    fun providesOkHttpClient(): OkHttpClient {}

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
//            .baseUrl()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()

}