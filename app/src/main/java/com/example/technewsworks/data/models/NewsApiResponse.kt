package com.example.technewsworks.data.models

/**
 * News API response.
 *
 * @property status If the request was successful or not. Options: ok, error. In the case of error
 * a code and message property will be populated.
 * @property code Error code
 * @property message Error message
 * @property articles The results of the request.
 */
class NewsApiResponse(
    val status: String? = null,
    val code: String? = null,
    val message: String? = null,
    val articles: List<Article>? = null,
)