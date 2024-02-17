package com.example.technewsworks.data.models

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
class Article(
    val source: Source? = null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null,
)