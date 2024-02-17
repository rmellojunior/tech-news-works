package com.example.technewsworks.data.models

/**
 * Article
 *
 * @property source The source this article came from.
 * @property author The author of the article.
 * @property title The headline or title of the article.
 * @property publishedAt The date and time that the article was published, in UTC (+000).
 * @property urlToImage The URL to a relevant image for the article.
 */
class Article(
    val source: Source? = null,
    val author: String? = null,
    val title: String? = null,
    val publishedAt: String? = null,
    val urlToImage: String? = null,
)