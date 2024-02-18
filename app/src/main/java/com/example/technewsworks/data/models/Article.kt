package com.example.technewsworks.data.models

import android.os.Parcelable
import com.example.technewsworks.domain.extensions.formatDate
import com.example.technewsworks.utils.DEFAULT_ISO_8601_DATE_TIME_FORMAT
import com.example.technewsworks.utils.DEFAULT_UI_VERBOSE_DATE_FORMAT
import kotlinx.android.parcel.Parcelize

/**
 * Article
 *
 * @property source The source this article came from.
 * @property author The author of the article.
 * @property title The headline or title of the article.
 * @property description The URL to a relevant image for the article.
 * @property urlToImage The URL to a relevant image for the article.
 * @property publishedAt The date and time that the article was published, in UTC (+000).
 * @property content The unformatted content of the article, where available. This is truncated
 * to 200 chars.
 */
@Parcelize
class Article(
    val source: Source? = null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null,
): Parcelable {
    fun publishedAtFormatted(
        formatInput: String = DEFAULT_ISO_8601_DATE_TIME_FORMAT,
        formatOutput: String = DEFAULT_UI_VERBOSE_DATE_FORMAT,
    ): String? = publishedAt?.formatDate(formatInput, formatOutput)
}