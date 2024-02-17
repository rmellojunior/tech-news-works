package com.example.technewsworks.data.repo

import com.example.technewsworks.data.datasource.api.HeadlinesApiService
import com.example.technewsworks.data.datasource.mock.FakeNews
import com.example.technewsworks.data.models.Article
import com.example.technewsworks.data.models.CountryCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Headlines repository module for handling data operations.
 */
class HeadlinesRepo @Inject constructor(
    private val mockData: FakeNews,
    private val api: HeadlinesApiService,
) {
    fun getNewsProvider(): String = HeadlinesApiService.NEWS_PROVIDER

    fun getTopHeadlines(
        country: CountryCode,
    ): Flow<List<Article>> = flow {
        val response = api.getTopHeadlines(
            country = country.code
        )

        emit(response.body()?.articles ?: listOf())
    }
}