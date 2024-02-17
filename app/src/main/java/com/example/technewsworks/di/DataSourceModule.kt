package com.example.technewsworks.di

import com.example.technewsworks.data.datasource.api.HeadlinesApiService
import com.example.technewsworks.data.datasource.mock.FakeNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideHeadlineApiService(retrofit: Retrofit): HeadlinesApiService =
        retrofit.create(HeadlinesApiService::class.java)

    @Provides
    @Singleton
    fun provideFakeNews(): FakeNews = FakeNews
}