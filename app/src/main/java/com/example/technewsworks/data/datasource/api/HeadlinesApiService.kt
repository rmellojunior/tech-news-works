package com.example.technewsworks.data.datasource.api

import com.example.technewsworks.data.models.CountryCode
import com.example.technewsworks.data.models.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadlinesApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = 10,
        @Query("country") country: String = CountryCode.UNITED_STATES.code,
    ): Response<NewsApiResponse>

    companion object {
        const val NEWS_PROVIDER = "News API"
    }
}