package com.example.technewsworks.data.datasource.mock

import com.example.technewsworks.data.models.Article
import com.example.technewsworks.data.models.Source

/**
 * Mock data.
 */
object FakeNews {
    val articles = listOf(
        Article(
            source = Source(
                name = "KCRA Sacramento",
            ),
            author = "Heather Waldman",
            title = "Northern California forecast: Rounds of rain, snow for Feb. 17-19 - KCRA Sacramento",
            description = "The holiday weekend will be active, but there will be dry breaks for those with travel plans.",
            urlToImage = "",
            publishedAt = "2024-02-17T15:35:00Z",
            content = "Several rounds of rain and snow are in the forecast this Presidents Day weekend.\r\nOn Saturday, rain and snow showers are likely to arrive in the afternoon hours. The KCRA 3 weather team is calling Sa… [+2086 chars]",
        ),
        Article(
            source = Source(
                name = "Fox News",
            ),
            author = "Janelle Ash",
            title = "Amy Schumer shuts down critics commenting that her face is 'puffier than normal' - Fox News",
            description = "Amy Schumer has addressed critics who have commented on her appearance. In an Instagram post, the comedian admitted her face is \"puffier than normal right now\" before giving fans a health update.",
            publishedAt = "2024-02-17T15:19:00Z",
            urlToImage = "",
            content = "Amy Schumer has responded to recent commentary about her appearance and is telling fans her \"puffier\" face is due to a health condition.\r\nSchumer took to Instagram to promote the new season of her sh… [+2367 chars]",
        ),
        Article(
            source = Source(
                name = "YouTube",
            ),
            author = null,
            title = "A Commercial Mission Heads to the Moon with NASA Science on This Week @NASA – February 16, 2024 - NASA",
            description = "A commercial mission heads to the Moon with NASA science, our Artemis II crew conducts some preflight training, and a major milestone for a planetary science...",
            publishedAt = "2024-02-17T15:00:42Z",
            urlToImage = "",
            content = null,
        ),
        Article(
            source = Source(
                name = "Variety"
            ),
            author = "Ellise Shafer",
            title = "Lena Dunham on Her ‘Incredibly Resonant’ Holocaust Drama ‘Treasure’ and Recent ‘Girls’ Renaissance: ‘Not Something I Expected’ - Variety",
            description = "Lena Dunham discusses her new film 'Treasure,' which premieres at Berlin Film Festival on Saturday night, and all the recent love for 'Girls.'",
            publishedAt = "2024-02-13T10:04:00Z",
            urlToImage = "",
            content = "When Lena Dunham first read the script for Julia von Heinz’s “Treasure,” it hit home. \r\nThe “Girls” creator’s grandmother had just died at 96, and Dunham found herself thinking a lot about her herita… [+7884 chars]",
        ),
        Article(
            source = Source(
                name = "SciTechDaily"
            ),
            author = null,
            title = "NASA's OSIRIS-REx spacecraft delivered an unprecedented 4.29 ounces of asteroid Bennu material to Earth, surpassing its mission goals. Despite initial challenges, the sample was successfully secured for future scientific research, ensuring a legacy of interna…",
            publishedAt = "2024-02-17T14:53:18Z",
            urlToImage = "",
            content = "A view of eight sample trays containing the final material from asteroid Bennu. The dust and rocks were poured into the trays from the top plate of the Touch-and-Go Sample Acquisition Mechanism (TAGS… [+3085 chars]"
        )
    )
}