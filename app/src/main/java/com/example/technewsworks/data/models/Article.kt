package com.example.technewsworks.data.models

/**
 * Article
 *
 * @property source The source this article came from.
 * @property author The author of the article.
 * @property title The headline or title of the article.
 * @property publishedAt The date and time that the article was published, in UTC (+000).
 */
class Article(
    val source: Source,
    val author: String,
    val title: String,
    val publishedAt: String,
)