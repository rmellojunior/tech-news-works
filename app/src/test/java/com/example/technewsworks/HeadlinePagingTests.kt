package com.example.technewsworks

import androidx.paging.PagingSource
import com.example.technewsworks.data.datasource.api.HeadlinesApiService
import com.example.technewsworks.data.datasource.mock.FakeNews
import com.example.technewsworks.data.models.Article
import com.example.technewsworks.data.models.NewsApiResponse
import com.example.technewsworks.data.repo.headlines.HeadlinesPagingSource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import retrofit2.Response


class HeadlineTests {
    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun `fetch top headlines using paging - success`() = runTest {
        // arrange
        val loadSize = 2

        val headlinesApiService = mockk<HeadlinesApiService>()
        coEvery {
            headlinesApiService.getTopHeadlines(any(), any(), any())
        } returns Response.success(NewsApiResponse(articles = FakeNews.articles.subList(0, loadSize)))

        val pagingSource = HeadlinesPagingSource(
            apiService = headlinesApiService
        )

        val params = PagingSource
            .LoadParams
            .Refresh(
                key = 1, // page
                loadSize = loadSize,
                placeholdersEnabled = false
            )

        val expected = PagingSource
            .LoadResult
            .Page(
                data = FakeNews.articles.subList(0, loadSize), // toIndex is exclusive
                prevKey = null,
                nextKey = 2,
            )

        // act
        val actual = pagingSource.load(params = params)

        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun `fetch top headlines using paging - error`() = runTest {
        // arrange
        val loadSize = 2

        val headlinesApiService = mockk<HeadlinesApiService>()
        coEvery {
            headlinesApiService.getTopHeadlines(any(), any(), any())
        } returns Response.error(401, mockk(relaxed = true))

        val pagingSource = HeadlinesPagingSource(
            apiService = headlinesApiService
        )

        val params = PagingSource
            .LoadParams
            .Refresh(
                key = 1, // page
                loadSize = loadSize,
                placeholdersEnabled = false
            )

        val expected = PagingSource
            .LoadResult
            .Error<Int, Article>(
                throwable = Throwable()
            )::class.java

        // act
        val actual = pagingSource.load(params = params)::class.java

        // assert
        assertEquals(expected, actual)
    }
}