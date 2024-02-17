package com.example.technewsworks.ui.screens.news

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.technewsworks.data.datasource.mock.FakeNews
import com.example.technewsworks.data.models.Article
import com.example.technewsworks.ui.components.NewsImage
import com.example.technewsworks.ui.components.SimpleAppBar
import com.example.technewsworks.ui.theme.TechNewsWorksTheme
import com.example.technewsworks.ui.theme.pDimensions

/**
 * Composable function that represents the news detail screen.
 *
 * @param modifier The Modifier to be applied to this screen.
 * @param vm View model.
 */
@Composable
fun NewsDetailScreen(
    modifier: Modifier = Modifier,
    vm: NewsDetailViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = { SimpleAppBar(navigateUp = vm.navigation::back) },
    ) { innerPadding ->
        NewsDetailPage(
            modifier = modifier.padding(innerPadding),
            news = vm.article,
        )
    }
}

/**
 * Composable function that represents the news detail page.
 *
 * @param modifier The Modifier to be applied to this page.
 */
@Composable
fun NewsDetailPage(
    news: Article,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(MaterialTheme.pDimensions.padding)
    ) {
        NewsImage(
            modifier = Modifier.fillMaxWidth(),
            imageUrl = news.urlToImage,
        )
        Spacer(Modifier.height(MaterialTheme.pDimensions.mediumSpacerSize))
        Text(text = news.title ?: "", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(MaterialTheme.pDimensions.smallSpacerSize))
        news.description?.let {
            Text(text = it, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(MaterialTheme.pDimensions.mediumSpacerSize))
        }
        news.content?.let {
            Text(text = it, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(
    name = "Light Theme",
    showBackground = true
)
@Preview(
    name = "Dark Theme",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Composable
internal fun NewsDetailPreview() {
    TechNewsWorksTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NewsDetailPage(
                news = FakeNews.articles[0],
            )
        }
    }
}