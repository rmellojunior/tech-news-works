package com.example.technewsworks.data.repo.headlines

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.technewsworks.data.datasource.api.HeadlinesApiService
import com.example.technewsworks.data.datasource.mock.FakeNews
import javax.inject.Inject

/**
 * Headlines repository module for handling data operations.
 */
class HeadlinesRepo @Inject constructor(
    private val mockData: FakeNews,
    private val apiService: HeadlinesApiService,
) {
    fun getTopHeadlines(
        pageSize: Int = 5,
    ) = Pager(
        config = PagingConfig(
            pageSize = pageSize,
            prefetchDistance = 2,
        ),
        pagingSourceFactory = {
            HeadlinesPagingSource(apiService)
        }
    ).flow
}