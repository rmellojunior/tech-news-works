package com.example.technewsworks.data.repo.headlines

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.technewsworks.data.datasource.api.HeadlinesApiService
import com.example.technewsworks.data.models.Article
import javax.inject.Inject

class HeadlinesPagingSource @Inject constructor(
    private val apiService: HeadlinesApiService,
): PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1

            // 1st call: pageSize will be 3xPageSize
            // 2nd/3rd/... : pageSize will be the value passed in PagingConfig
            val response = apiService.getTopHeadlines(page = page, pageSize = params.loadSize)

            // TODO: handle response
            LoadResult.Page(
                data = response.body()?.articles!!,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.body()?.articles!!.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}