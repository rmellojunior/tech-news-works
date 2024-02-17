package com.example.technewsworks.data.datasource.api

import com.example.technewsworks.data.models.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadlinesApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
    ): Response<NewsApiResponse>
}