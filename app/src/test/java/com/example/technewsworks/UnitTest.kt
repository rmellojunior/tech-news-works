package com.example.technewsworks

import com.example.technewsworks.data.datasource.mock.FakeNews
import com.example.technewsworks.domain.extensions.formatDate
import com.example.technewsworks.utils.DEFAULT_ISO_8601_DATE_TIME_FORMAT
import com.example.technewsworks.utils.DEFAULT_UI_VERBOSE_DATE_FORMAT
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {

    // TODO: add more tests
    @Test
    fun a() {

    }

    @Test
    fun formatDate() {
        // arrange
        val apiDate = FakeNews.articles[0].publishedAt!! // "2024-02-17T15:35:00Z"

        // act
        val apiDateFormatted = apiDate.formatDate(
            DEFAULT_ISO_8601_DATE_TIME_FORMAT,
            DEFAULT_UI_VERBOSE_DATE_FORMAT
        )

        // assert
        assertTrue("Feb 17, 2024" == apiDateFormatted)
    }

    @Test
    fun wrongFormatDate() {
        // arrange
        val apiDate = "2024-17"

        // act
        val apiDateFormatted = apiDate.formatDate(
            DEFAULT_ISO_8601_DATE_TIME_FORMAT,
            DEFAULT_UI_VERBOSE_DATE_FORMAT
        )

        // assert
        assertTrue("" == apiDateFormatted)
    }
}