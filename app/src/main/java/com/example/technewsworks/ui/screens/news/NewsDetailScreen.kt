package com.example.technewsworks.ui.screens.news

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    article: Article,
) {
    Scaffold(
        topBar = { SimpleAppBar(navigateUp = vm.navigation::back) },
    ) { innerPadding ->
        NewsDetailPage(
            modifier = modifier.padding(innerPadding),
            article = article,
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
    article: Article,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(MaterialTheme.pDimensions.padding)
            .verticalScroll(rememberScrollState()),
    ) {
        NewsImage(
            modifier = Modifier
                .heightIn(min = 180.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium),
            imageUrl = article.urlToImage,
        )
        Spacer(Modifier.height(MaterialTheme.pDimensions.mediumSpacerSize))
        Text(text = article.title ?: "", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(MaterialTheme.pDimensions.smallSpacerSize))
        article.description?.let {
            Text(text = it, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(MaterialTheme.pDimensions.mediumSpacerSize))
        }
        article.content?.let {
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
                article = FakeNews.articles[0],
            )
        }
    }
}