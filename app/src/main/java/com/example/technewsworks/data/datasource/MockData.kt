package com.example.technewsworks.data.datasource

import com.example.technewsworks.data.models.Article
import com.example.technewsworks.data.models.Source

object MockData {
    val articles = listOf(
        Article(
            source = Source(
                name = "The Washington Post",
            ),
            author = "Rachel Pannett",
            title = "Usher marries Jennifer Goicoechea on Super Bowl Sunday - The Washington Post - The Washington Post",
            publishedAt = "2024-02-13T10:24:13Z",
        ),
        Article(
            source = Source(
                name = "Fox News",
            ),
            author = "Ruth Marks Eglash",
            title = "Jordan's King Abdullah meeting with Biden highlights US ally's dilemma in Israel-Hamas war - Fox News",
            publishedAt = "2024-02-13T09:00:00Z",
        ),
        Article(
            source = Source(
                name = "MLB.com",
            ),
            author = "MLB.com",
            title = "Shohei Ohtani impresses in first batting practice with Dodgers - MLB.com",
            publishedAt = "2024-02-13T08:31:25Z",
        ),
        Article(
            source = Source(
                name = "Google News",
            ),
            author = "finanzen.net",
            title = "TUI-Aktie im Aufwind: TUI im eigentlich schwachen Winterquartal mit Gewinn - finanzen.net",
            publishedAt = "2024-02-13T10:04:00Z",
        ),
        Article(
            source = Source(
                name = "Google News",
            ),
            author = "n-tv NACHRICHTEN",
            title = "Der Börsen-Tag Dienstag, 13. Februar 2024 - n-tv.de - n-tv NACHRICHTEN",
            publishedAt = "2024-02-13T09:53:01Z",
        )
    )
}